package com.ittepic.literaciones.Custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class optimizar {

    public List<Instruction3DC> optimizar(List<Instruction3DC> codigoOriginal) {
        System.out.println("--- INICIANDO OPTIMIZACIÓN AVANZADA ---");

        List<Instruction3DC> codigo = new ArrayList<>(codigoOriginal);
        boolean huboCambios;
        int ciclo = 1;

        do {
            String hashAntes = codigo.toString(); // Detección simple de cambios

            // 1. Plegado de Constantes y Simplificación Algebraica
            codigo = plegarConstantesYAlgebra(codigo);

            // 2. Propagación de Copias
            codigo = propagacionCopias(codigo);

            // 3. Eliminación de Subexpresiones Comunes
            codigo = eliminarSubexpresiones(codigo);

            // 4. Eliminación de Código Inalcanzable (Control de flujo)
            codigo = eliminarInalcanzable(codigo);

            // 5. Eliminación de Código Muerto (Variables no usadas)
            codigo = eliminarCodigoMuerto(codigo);

            String hashDespues = codigo.toString();
            huboCambios = !hashAntes.equals(hashDespues);

            if (huboCambios) {
                System.out.println("   -> Ciclo " + ciclo + ": Se aplicaron optimizaciones.");
            }
            ciclo++;
        } while (huboCambios);

        System.out.println("--- OPTIMIZACIÓN TERMINADA ---");
        return codigo;
    }

    // -------------------------------------------------------
    // 1. PLEGADO DE CONSTANTES Y ÁLGEBRA
    // -------------------------------------------------------
    private List<Instruction3DC> plegarConstantesYAlgebra(List<Instruction3DC> codigo) {
        List<Instruction3DC> opt = new ArrayList<>();
        Map<String, Object> constantes = new HashMap<>();

        for (Instruction3DC inst : codigo) {

            // --- CORRECCIÓN CRÍTICA ---
            // Si encontramos una etiqueta, vaciamos el conocimiento de constantes.
            // Esto evita que asumamos valores dentro de bucles.
            if (inst.operation.equals("LABEL")) {
                constantes.clear();
                opt.add(inst);
                continue;
            }
            // --------------------------

            // Recuperar valores constantes si existen
            Object v1 = constantes.getOrDefault(inst.operand1, parseConstante(inst.operand1));
            Object v2 = constantes.getOrDefault(inst.operand2, parseConstante(inst.operand2));

            if (esOperacion(inst.operation)) {
                // A. Intento de Plegado (ambos son constantes)
                if (esCalculable(v1) && esCalculable(v2)) {
                    Object res = calcular(inst.operation, v1, v2);
                    if (res != null) {
                        opt.add(new Instruction3DC("ASSIGN", inst.result, res.toString()));
                        constantes.put(inst.result, res);
                        continue;
                    }
                }

                // B. Simplificación Algebraica (Identidades)
                String s1 = inst.operand1;
                String s2 = inst.operand2;
                Instruction3DC simplificada = null;

                switch (inst.operation) {
                    case "SUMA": // x + 0 = x, 0 + x = x
                        if (esCero(v2)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, s1);
                        } else if (esCero(v1)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, s2);
                        }
                        break;
                    case "RESTA": // x - 0 = x, x - x = 0
                        if (esCero(v2)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, s1);
                        } else if (s1 != null && s1.equals(s2)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, "0");
                        }
                        break;
                    case "MULT": // x * 1 = x, x * 0 = 0
                        if (esUno(v2)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, s1);
                        } else if (esUno(v1)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, s2);
                        } else if (esCero(v1) || esCero(v2)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, "0");
                        }
                        break;
                    case "DIV": // x / 1 = x, 0 / x = 0
                        if (esUno(v2)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, s1);
                        } else if (esCero(v1)) {
                            simplificada = new Instruction3DC("ASSIGN", inst.result, "0");
                        }
                        break;
                }

                if (simplificada != null) {
                    opt.add(simplificada);
                } else {
                    opt.add(inst);
                }

            } else if (inst.operation.equals("ASSIGN")) {
                if (esCalculable(v1)) {
                    constantes.put(inst.result, v1);
                } else {
                    constantes.remove(inst.result); // Variable dejó de ser constante
                }
                opt.add(inst);
            } else {
                // Limpiar constantes si se redefine una variable en otra operación no manejada
                if (inst.result != null) {
                    constantes.remove(inst.result);
                }
                opt.add(inst);
            }
        }
        return opt;
    }

    // -------------------------------------------------------
    // 2. PROPAGACIÓN DE COPIAS
    // -------------------------------------------------------
    private List<Instruction3DC> propagacionCopias(List<Instruction3DC> codigo) {
        List<Instruction3DC> opt = new ArrayList<>();
        Map<String, String> copias = new HashMap<>(); // Map destino -> origen

        for (Instruction3DC inst : codigo) {
            String op1 = copias.getOrDefault(inst.operand1, inst.operand1);
            String op2 = copias.getOrDefault(inst.operand2, inst.operand2);
            // Nota: No reemplazamos en 'result' porque es definición, no uso.

            // Reconstruir instrucción con operandos propagados
            Instruction3DC nueva = new Instruction3DC(inst.operation, inst.result, op1, op2);

            // Manejo de redefiniciones (Invalidación)
            if (inst.result != null) {
                // Si la variable 'result' se redefine, ya no es copia válida de nada anterior
                // Y nada que fuera copia de 'result' es válido ahora (aunque en 3DC T# no suelen cambiar, vars sí)
                copias.values().removeIf(val -> val.equals(inst.result));
                copias.remove(inst.result);
            }

            // Registrar nueva copia si es asignación simple
            if (inst.operation.equals("ASSIGN")) {
                copias.put(inst.result, op1);
            } else if (inst.operation.equals("LABEL")) {
                copias.clear(); // Reset en saltos para seguridad (contexto cambia)
            }

            opt.add(nueva);
        }
        return opt;
    }

    // -------------------------------------------------------
    // 3. ELIMINACIÓN DE SUBEXPRESIONES COMUNES (CSE)
    // -------------------------------------------------------
    private List<Instruction3DC> eliminarSubexpresiones(List<Instruction3DC> codigo) {
        List<Instruction3DC> opt = new ArrayList<>();
        // Key: "OP op1 op2", Value: TempVariable
        Map<String, String> expresiones = new HashMap<>();

        for (Instruction3DC inst : codigo) {
            if (esOperacion(inst.operation)) {
                String key = inst.operation + " " + inst.operand1 + " " + inst.operand2;
                // Conmutatividad para suma y mult
                if (inst.operation.equals("SUMA") || inst.operation.equals("MULT")) {
                    String keyComm = inst.operation + " " + inst.operand2 + " " + inst.operand1;
                    if (expresiones.containsKey(keyComm)) {
                        key = keyComm;
                    }
                }

                if (expresiones.containsKey(key)) {
                    // Encontramos subexpresión! Reemplazar por asignación del temp existente
                    String tempExistente = expresiones.get(key);
                    opt.add(new Instruction3DC("ASSIGN", inst.result, tempExistente));
                } else {
                    expresiones.put(key, inst.result);
                    opt.add(inst);
                }
            } else {
                // Si una variable cambia, invalidar expresiones que la usen
                if (inst.result != null) {
                    String var = inst.result;
                    expresiones.keySet().removeIf(k -> k.contains(" " + var + " ") || k.endsWith(" " + var));
                }
                if (inst.operation.equals("LABEL")) {
                    expresiones.clear(); // Reset en saltos
                }
                opt.add(inst);
            }
        }
        return opt;
    }

    // -------------------------------------------------------
    // 4. ELIMINACIÓN DE CÓDIGO INALCANZABLE
    // -------------------------------------------------------
    private List<Instruction3DC> eliminarInalcanzable(List<Instruction3DC> codigo) {
        List<Instruction3DC> opt = new ArrayList<>();
        boolean inalcanzable = false;

        for (Instruction3DC inst : codigo) {
            if (inst.operation.equals("LABEL")) {
                inalcanzable = false; // Una etiqueta siempre es un punto de entrada potencial
            }

            if (!inalcanzable) {
                opt.add(inst);
                if (inst.operation.equals("GOTO")) {
                    inalcanzable = true; // Después de GOTO incondicional, el código es muerto hasta prox Label
                }
            }
        }
        return opt;
    }

    // -------------------------------------------------------
    // 5. ELIMINACIÓN DE CÓDIGO MUERTO (Variables no usadas)
    // -------------------------------------------------------
    private List<Instruction3DC> eliminarCodigoMuerto(List<Instruction3DC> codigo) {
        Set<String> usadas = new HashSet<>();
        // Paso 1: Identificar variables usadas
        for (Instruction3DC inst : codigo) {
            if (inst.operand1 != null) {
                usadas.add(inst.operand1);
            }
            if (inst.operand2 != null) {
                usadas.add(inst.operand2);
            }
            // Casos especiales donde operand1 no es solo dato
            if (inst.operation.equals("IF_GOTO") || inst.operation.equals("PRINT")) {
                usadas.add(inst.operand1);
            }
        }

        List<Instruction3DC> opt = new ArrayList<>();
        for (Instruction3DC inst : codigo) {
            // Si define una variable temporal (T...) y no se usa, eliminar
            if (inst.result != null && inst.result.startsWith("T")) { // Asumiendo temporales T0, T1...
                if (!usadas.contains(inst.result) && esOperacionOAsignacion(inst.operation)) {
                    continue; // Eliminar
                }
            }
            opt.add(inst);
        }
        return opt;
    }

    /*
    // -------------------------------------------------------
    // 5. ELIMINACIÓN DE CÓDIGO MUERTO (VERSIÓN AGRESIVA)
    // -------------------------------------------------------
    private List<Instruction3DC> eliminarCodigoMuerto(List<Instruction3DC> codigo) {
        Set<String> usadas = new HashSet<>();
        
        // Paso 1: Identificar qué variables se LEEN/USAN
        for (Instruction3DC inst : codigo) {
            if (inst.operand1 != null) usadas.add(inst.operand1);
            if (inst.operand2 != null) usadas.add(inst.operand2);
            
            // IF y PRINT usan el operand1
            if (inst.operation.equals("IF_GOTO") || inst.operation.equals("PRINT")) {
                usadas.add(inst.operand1);
            }
        }

        List<Instruction3DC> opt = new ArrayList<>();
        for (Instruction3DC inst : codigo) {
            // Verificamos si la instrucción produce un resultado (Asignación u Operación)
            boolean generaResultado = inst.result != null && esOperacionOAsignacion(inst.operation);
            
            if (generaResultado) {
                // CORRECCIÓN: Eliminamos la restricción .startsWith("T")
                // Si la variable resultado NO está en la lista de usadas, ADIÓS.
                if (!usadas.contains(inst.result)) {
                     continue; // Se elimina la instrucción
                }
            }
            opt.add(inst);
        }
        return opt;
    }
     */
    // --- UTILIDADES ---
    private boolean esOperacion(String op) {
        return List.of("SUMA", "RESTA", "MULT", "DIV", "AND", "OR", "MAYOR", "MENOR", "IGUAL_QUE").contains(op);
    }

    private boolean esOperacionOAsignacion(String op) {
        return esOperacion(op) || op.equals("ASSIGN") || op.equals("NOT");
    }

    private boolean esCalculable(Object o) {
        return o instanceof Number || o instanceof Boolean;
    }

    private boolean esCero(Object o) {
        if (o == null) {
            return false;
        }
        return o.toString().equals("0") || o.toString().equals("0.0");
    }

    private boolean esUno(Object o) {
        if (o == null) {
            return false;
        }
        return o.toString().equals("1") || o.toString().equals("1.0");
    }

    private Object parseConstante(String s) {
        if (s == null) {
            return null;
        }
        if (s.equalsIgnoreCase("true")) {
            return true;
        }
        if (s.equalsIgnoreCase("false")) {
            return false;
        }
        try {
            if (s.contains(".")) {
                return Double.valueOf(s);
            }
            return Integer.valueOf(s);
        } catch (Exception e) {
            return s;
        }
    }

    private Object calcular(String op, Object v1, Object v2) {
        List<String> dummy = new ArrayList<>();
        Simbolo s1 = new Simbolo(v1);
        Simbolo s2 = new Simbolo(v2);
        try {
            switch (op) {
                case "SUMA":
                    return HelperParser.evalArit(s1, "+", s2, dummy, 0, 0);
                case "RESTA":
                    return HelperParser.evalArit(s1, "-", s2, dummy, 0, 0);
                case "MULT":
                    return HelperParser.evalArit(s1, "*", s2, dummy, 0, 0);
                case "DIV":
                    return HelperParser.evalArit(s1, "/", s2, dummy, 0, 0);
                case "AND":
                    return HelperParser.evalAnd(s1, s2, dummy, 0, 0);
                case "OR":
                    return HelperParser.evalOr(s1, s2, dummy, 0, 0);
                case "MAYOR":
                    return HelperParser.evalComp(s1, ">", s2, dummy, 0, 0);
                case "MENOR":
                    return HelperParser.evalComp(s1, "<", s2, dummy, 0, 0);
                case "IGUAL_QUE":
                    return HelperParser.evalComp(s1, "==", s2, dummy, 0, 0);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
