// Archivo: com/ittepic/literaciones/Custom/Optimizador.java
package com.ittepic.literaciones.Custom;

import com.ittepic.literaciones.Custom.Instruction3DC;
import com.ittepic.literaciones.Custom.HelperParser;
import com.ittepic.literaciones.Custom.Simbolo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class optimizar {
public List<Instruction3DC> optimizar(List<Instruction3DC> codigoOriginal) {
        System.out.println("--- INICIANDO OPTIMIZACIÓN ---");
        
        // PASO 1: Plegado y Propagación de Constantes
        List<Instruction3DC> codigoPlegado = plegarConstantes(codigoOriginal);
        
        // PASO 2: Eliminación de Código Muerto (NUEVO)
        // Ejecutamos esto en un ciclo porque eliminar una línea puede volver inútil a la anterior.
        List<Instruction3DC> codigoLimpio = codigoPlegado;
        boolean huboCambios;
        do {
            int tamanoAntes = codigoLimpio.size();
            codigoLimpio = eliminarCodigoMuerto(codigoLimpio);
            huboCambios = codigoLimpio.size() < tamanoAntes;
            if(huboCambios) System.out.println("   -> Ciclo de limpieza: se eliminaron instrucciones.");
        } while (huboCambios);
        
        System.out.println("--- OPTIMIZACIÓN TERMINADA ---");
        return codigoLimpio;
    }
    
    // -------------------------------------------------------
    // PASO 1: PLEGADO DE CONSTANTES (Tu código actual corregido)
    // -------------------------------------------------------
    private List<Instruction3DC> plegarConstantes(List<Instruction3DC> codigo) {
        List<Instruction3DC> codigoOptimizado = new ArrayList<>();
        Map<String, Object> constantes = new HashMap<>();

        for (Instruction3DC inst : codigo) {
            if (esOperacion(inst.operation)) {
                Object valorOp1 = constantes.getOrDefault(inst.operand1, inst.operand1);
                Object valorOp2 = constantes.getOrDefault(inst.operand2, inst.operand2);
                Object parsedOp1 = parseConstante(valorOp1);
                Object parsedOp2 = parseConstante(valorOp2);

                if (esValorCalculable(parsedOp1) && esValorCalculable(parsedOp2)) {
                    Simbolo s1 = new Simbolo(parsedOp1); 
                    Simbolo s2 = new Simbolo(parsedOp2); 
                    Object resultado = null;
                    List<String> erroresFalsos = new ArrayList<>();
                    
                    switch (inst.operation) {
                        case "SUMA": resultado = HelperParser.evalArit(s1, "+", s2, erroresFalsos, 0, 0); break;
                        case "RESTA": resultado = HelperParser.evalArit(s1, "-", s2, erroresFalsos, 0, 0); break;
                        case "MULT": resultado = HelperParser.evalArit(s1, "*", s2, erroresFalsos, 0, 0); break;
                        case "DIV": resultado = HelperParser.evalArit(s1, "/", s2, erroresFalsos, 0, 0); break;
                        case "MAYOR": resultado = HelperParser.evalComp(s1, ">", s2, erroresFalsos, 0, 0); break;
                        case "MENOR": resultado = HelperParser.evalComp(s1, "<", s2, erroresFalsos, 0, 0); break;
                        case "IGUAL_QUE": resultado = HelperParser.evalComp(s1, "==", s2, erroresFalsos, 0, 0); break;
                        case "AND": resultado = HelperParser.evalAnd(s1, s2, erroresFalsos, 0, 0); break;
                        case "OR": resultado = HelperParser.evalOr(s1, s2, erroresFalsos, 0, 0); break;
                    }

                    if (resultado != null && erroresFalsos.isEmpty()) {
                        System.out.println("Optimizando: " + inst + " -> " + resultado);
                        Instruction3DC nuevaInst = new Instruction3DC("ASSIGN", inst.result, resultado.toString());
                        codigoOptimizado.add(nuevaInst);
                        constantes.put(inst.result, resultado);
                    } else {
                        codigoOptimizado.add(inst);
                    }
                } else {
                    codigoOptimizado.add(inst);
                }
            } 
            else if (inst.operation.equals("ASSIGN")) {
                Object valorAsignado = constantes.getOrDefault(inst.operand1, inst.operand1);
                Object parsedValor = parseConstante(valorAsignado);
                
                if (esValorCalculable(parsedValor)) {
                    constantes.put(inst.result, parsedValor);
                } else {
                    constantes.remove(inst.result);
                }
                codigoOptimizado.add(inst);
            }
            else {
                codigoOptimizado.add(inst);
            }
        }
        return codigoOptimizado;
    }

    // -------------------------------------------------------
    // PASO 2: ELIMINACIÓN DE CÓDIGO MUERTO (NUEVO)
    // -------------------------------------------------------
    private List<Instruction3DC> eliminarCodigoMuerto(List<Instruction3DC> codigo) {
        // 1. Identificar qué variables se USAN en alguna parte
        Set<String> variablesUsadas = new HashSet<>();
        
        for (Instruction3DC inst : codigo) {
            // Si la instrucción usa operandos, los agregamos al set de usados
            if (inst.operand1 != null) variablesUsadas.add(inst.operand1);
            if (inst.operand2 != null) variablesUsadas.add(inst.operand2);
            
            // Caso especial: IF_GOTO usa el operando1 como condición
            if (inst.operation.equals("IF_GOTO")) variablesUsadas.add(inst.operand1);
            
            // Caso especial: PRINT usa el operando1
            if (inst.operation.equals("PRINT")) variablesUsadas.add(inst.operand1);
        }

        // 2. Filtrar instrucciones inútiles
        List<Instruction3DC> codigoLimpio = new ArrayList<>();
        
        for (Instruction3DC inst : codigo) {
            // Si es una asignación o una operación que genera un resultado (ej. T1 = ...)
            if (inst.result != null && (esOperacion(inst.operation) || inst.operation.equals("ASSIGN") || inst.operation.equals("NOT"))) {
                
                // ¿Es una variable temporal (empieza con 'T' y un número)?
                boolean esTemporal = inst.result.matches("^T\\d+$");
                
                // SI es temporal Y nadie lo usa -> ES CÓDIGO MUERTO -> No lo agregamos
                if (esTemporal && !variablesUsadas.contains(inst.result)) {
                    continue; // ¡Eliminado!
                }
            }
            
            // Si no fue eliminado, lo conservamos
            codigoLimpio.add(inst);
        }
        
        return codigoLimpio;
    }

    // --- Métodos de Ayuda ---
    
    private boolean esOperacion(String op) {
        if (op == null) return false;
        return op.equals("SUMA") || op.equals("RESTA") || op.equals("MULT") || 
               op.equals("DIV") || op.equals("MAYOR") || op.equals("MENOR") ||
               op.equals("IGUAL_QUE") || op.equals("AND") || op.equals("OR");
    }

    private Object parseConstante(Object valor) {
        if (valor == null) return null;
        if (valor instanceof Number || valor instanceof Boolean) return valor;

        if (valor instanceof String) {
            String str = (String) valor;
            if (str.equals("true")) return true;
            if (str.equals("false")) return false;
            if (str.startsWith("\"") && str.endsWith("\"")) return str;
            try { return Integer.parseInt(str); } catch (NumberFormatException e) {}
            try { return Double.parseDouble(str); } catch (NumberFormatException e) {}
            return str; 
        }
        return valor;
    }

    private boolean esValorCalculable(Object valor) {
        return valor instanceof Number || valor instanceof Boolean;
    }
}