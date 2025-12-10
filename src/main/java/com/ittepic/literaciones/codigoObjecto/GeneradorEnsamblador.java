/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.codigoObjecto;

import com.ittepic.literaciones.Custom.Instruction3DC;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneradorEnsamblador {

    // Control de variables para la sección .bss
    private Set<String> variablesDeclaradas = new HashSet<>();
    // Mapa para reutilizar strings literales y no repetirlos en .data
    private Map<String, String> stringLiterals = new HashMap<>();

    public void generarArchivo(List<Instruction3DC> instrucciones, String rutaSalida) {
        StringBuilder dataSection = new StringBuilder();
        StringBuilder bssSection = new StringBuilder();
        StringBuilder textSection = new StringBuilder();
        
        // Resetear para cada generación
        variablesDeclaradas.clear();
        stringLiterals.clear();

        // ---------------------------------------------------------
        // 1. CABECERA Y FUNCIONES EXTERNAS
        // ---------------------------------------------------------
        textSection.append("global _main\n");
        textSection.append("extern _printf\n");
        textSection.append("extern _sprintf\n");
        textSection.append("extern _system\n");
        textSection.append("extern _exit\n\n");
        
        textSection.append("section .text\n");
        textSection.append("_main:\n");
        textSection.append("    push ebp\n");
        textSection.append("    mov ebp, esp\n\n");

        // ---------------------------------------------------------
        // 2. SECCIÓN DATA (Constantes y Formatos)
        // ---------------------------------------------------------
        dataSection.append("section .data\n");
        dataSection.append("    fmt_int db \"%d\", 10, 0\n"); 
        dataSection.append("    fmt_str db \"%s\", 10, 0\n"); 
        dataSection.append("    fmt_str_str db \"%s%s\", 0\n"); // Formato para concatenar string + string
        dataSection.append("    fmt_str_int db \"%s%d\", 0\n"); // Formato para concatenar string + numero
        
        // Comandos de PowerShell para TTS (Text-To-Speech)
        dataSection.append("    cmd_speak_str db \"powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%s')\", 0\n");
        dataSection.append("    cmd_speak_int db \"powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%d')\", 0\n");

        // ---------------------------------------------------------
        // 3. SECCIÓN BSS (Variables y Buffers)
        // ---------------------------------------------------------
        bssSection.append("section .bss\n");
        // Aseguramos que HEROE tenga un espacio reservado para su puntero
        bssSection.append("    HEROE resd 1\n"); 
        bssSection.append("    ENERGIA resd 1\n");
        // Buffer donde se construyen las cadenas concatenadas (clave para la solución)
        bssSection.append("    buffer resb 512\n"); 

        // ---------------------------------------------------------
        // 4. TRADUCCIÓN DE INSTRUCCIONES
        // ---------------------------------------------------------
        for (Instruction3DC inst : instrucciones) {
            textSection.append("    ; ").append(inst.toString()).append("\n");

            // Registrar variable destino si hace falta (aunque las del ejemplo ya están arriba)
            registrarVariable(inst.result, bssSection);
            
            switch (inst.operation) {
                case "ASSIGN":
                    // Si el operando es un string, asignamos su puntero (dirección)
                    String val = procesarOperando(inst.operand1, dataSection);
                    
                    if (inst.operand1 != null && inst.operand1.startsWith("\"")) {
                         // Si es string literal, el procesarOperando devuelve el puntero
                         textSection.append("    mov dword [").append(inst.result).append("], ").append(val).append("\n");
                    } else {
                        // Si es valor numérico o un puntero de variable (ej. T1), el procesarOperando devuelve el valor/puntero entre corchetes
                        textSection.append("    mov eax, ").append(val).append("\n");
                        textSection.append("    mov [").append(inst.result).append("], eax\n");
                    }
                    break;
                    
                case "SUMA":
                    // Lógica crítica para la concatenación de cadenas
                    if (esStringOperacion(inst.operand1) || esStringOperacion(inst.operand2)) {
                        // Concatenación
                        textSection.append("    ; -- INICIO CONCATENACION --\n");
                        String op1_ptr = procesarOperando(inst.operand1, dataSection);
                        String op2_ptr = procesarOperando(inst.operand2, dataSection);

                        // Asumimos que si op1 es HEROE/T*, es la parte de la cadena
                        // Usamos fmt_str_int si op2 es un número (ENERGIA o literal)
                        boolean op2_is_number = inst.operand2.matches("-?\\d+") || inst.operand2.equals("ENERGIA");

                        // PUSH argumentos en orden inverso: 4to, 3ro, 2do, 1ro
                        if (op2_is_number) {
                            textSection.append("    push dword ").append(op2_ptr).append("\n"); // 4to: Valor (ej. [ENERGIA])
                        } else {
                            textSection.append("    push ").append(op2_ptr).append("\n"); // 4to: Puntero (ej. str_...)
                        }
                        
                        textSection.append("    push ").append(op1_ptr).append("\n"); // 3ro: Puntero (ej. [HEROE])

                        if (op2_is_number) {
                            textSection.append("    push fmt_str_int\n"); // 2do: Formato (%s%d)
                        } else {
                            textSection.append("    push fmt_str_str\n"); // 2do: Formato (%s%s)
                        }
                        
                        textSection.append("    push buffer\n"); // 1ro: Destino (buffer)
                        
                        textSection.append("    call _sprintf\n");
                        textSection.append("    add esp, 16\n"); 

                        // Guardamos el puntero al buffer en la variable de resultado
                        textSection.append("    mov dword [").append(inst.result).append("], buffer\n");
                        textSection.append("    ; -- FIN CONCATENACION --\n");

                    } else {
                        // Suma Aritmética
                        textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                        textSection.append("    add eax, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                        textSection.append("    mov [").append(inst.result).append("], eax\n");
                    }
                    break;

                case "RESTA":
                case "MULT":
                case "DIV":
                    // Solo operaciones numéricas, sin concatenación
                    String op_inst = inst.operation.equals("RESTA") ? "sub" : inst.operation.equals("MULT") ? "imul" : "idiv";
                    textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                    
                    if (op_inst.equals("idiv")) {
                        textSection.append("    mov ecx, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                        textSection.append("    cdq\n"); 
                        textSection.append("    idiv ecx\n");
                    } else {
                        textSection.append("    ").append(op_inst).append(" eax, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                    }
                    
                    textSection.append("    mov [").append(inst.result).append("], eax\n");
                    break;
                    
                case "LABEL":
                    textSection.append(inst.result).append(":\n");
                    break;
                case "GOTO":
                    textSection.append("    jmp ").append(inst.operand1).append("\n");
                    break;
                case "IF_GOTO":
                    textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                    textSection.append("    cmp eax, 0\n"); 
                    textSection.append("    jne ").append(inst.operand2).append("\n"); 
                    break;

                case "PRINT":
                    generarPrint(inst.operand1, textSection, dataSection);
                    break;

                case "MAYOR": generarComp("setg", inst, textSection, dataSection); break;
                case "MENOR": generarComp("setl", inst, textSection, dataSection); break;
                case "IGUAL_QUE": generarComp("sete", inst, textSection, dataSection); break;
                
                case "AND":
                     textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                     textSection.append("    and eax, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                     textSection.append("    mov [").append(inst.result).append("], eax\n");
                     break;
                case "OR":
                     textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                     textSection.append("    or eax, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                     textSection.append("    mov [").append(inst.result).append("], eax\n");
                     break;
            }
            textSection.append("\n");
        }

        // SALIDA LIMPIA
        textSection.append("    push 0\n");
        textSection.append("    call _exit\n");

        // Escribir archivo .asm
        try (FileWriter writer = new FileWriter(rutaSalida)) {
            writer.write(dataSection.toString() + "\n");
            writer.write(bssSection.toString() + "\n");
            writer.write(textSection.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- MÉTODOS AUXILIARES ---

    private void registrarVariable(String var, StringBuilder bss) {
        if (var != null && !var.matches("-?\\d+") && !var.startsWith("\"") && !var.startsWith("L") && !variablesDeclaradas.contains(var)) {
            // Asumimos que toda nueva variable temporal es un puntero por seguridad (4 bytes)
            bss.append("    ").append(var).append(" resd 1\n");
            variablesDeclaradas.add(var);
        }
    }

    // Determina si el operando requiere manejo de cadena (es un puntero a string)
    private boolean esStringOperacion(String op) {
        if (op == null) return false;
        // String literal o variable conocida para puntero (HEROE) o temporal (T*)
        return op.startsWith("\"") || op.equals("HEROE") || op.startsWith("T");
    }

    // Método INTELIGENTE: Si es string, lo define en .data y devuelve su puntero. Si es variable, devuelve [var].
    private String procesarOperando(String op, StringBuilder data) {
        if (op == null) return "0";
        
        // 1. Si es String Literal ("Hola")
        if (op.startsWith("\"")) {
            if (stringLiterals.containsKey(op)) {
                return stringLiterals.get(op); // Retorna la etiqueta (puntero)
            }
            // Crear nueva etiqueta en .data
            String label = "str_" + Math.abs(op.hashCode());
            data.append("    ").append(label).append(" db ").append(op).append(", 0\n");
            stringLiterals.put(op, label);
            return label; // Retorna la dirección (etiqueta)
        }
        
        // 2. Si es número
        if (op.matches("-?\\d+")) return op;
        
        // 3. Booleanos
        if (op.equalsIgnoreCase("true")) return "1";
        if (op.equalsIgnoreCase("false")) return "0";
        
        // 4. Variable (HEROE, ENERGIA, T1, etc.). Devolvemos el valor/puntero entre corchetes.
        return "[" + op + "]"; 
    }
    
    private void generarComp(String setInst, Instruction3DC inst, StringBuilder sb, StringBuilder data) {
        sb.append("    mov eax, ").append(procesarOperando(inst.operand1, data)).append("\n");
        sb.append("    cmp eax, ").append(procesarOperando(inst.operand2, data)).append("\n");
        sb.append("    mov eax, 0\n");
        sb.append("    ").append(setInst).append(" al\n"); 
        sb.append("    mov [").append(inst.result).append("], eax\n");
    }

    private void generarPrint(String op, StringBuilder text, StringBuilder data) {
        // Determinar el puntero o valor. Si es una variable, devuelve [VAR]
        String val = procesarOperando(op, data);
        
        // Si el operando es un puntero a cadena ([HEROE], [T*], o una etiqueta str_...)
        if (op.startsWith("\"") || op.equals("HEROE") || op.startsWith("T") || op.equals("buffer")) {
            // La variable contiene la dirección de la cadena.
            String pointer = op.startsWith("\"") ? val : op.equals("buffer") ? "buffer" : "dword " + val;
            
            // 1. PANTALLA: printf("%s", pointer)
            text.append("    push ").append(pointer).append("\n"); 
            text.append("    push fmt_str\n");
            text.append("    call _printf\n");
            text.append("    add esp, 8\n"); 

            // 2. VOZ: system(sprintf(cmd_fmt_str, pointer))
            text.append("    push ").append(pointer).append("\n");
            text.append("    push cmd_speak_str\n");
            text.append("    push buffer\n");
            text.append("    call _sprintf\n"); 
            text.append("    add esp, 12\n");
            
            text.append("    push buffer\n");
            text.append("    call _system\n");
            text.append("    add esp, 4\n");
            
        } else {
            // Es un número ([ENERGIA] o literal)
            // 1. PANTALLA: printf("%d", val)
            text.append("    push dword ").append(val).append("\n");
            text.append("    push fmt_int\n");
            text.append("    call _printf\n");
            text.append("    add esp, 8\n");

            // 2. VOZ: system(sprintf(cmd_fmt_int, val))
            text.append("    push dword ").append(val).append("\n");
            text.append("    push cmd_speak_int\n");
            text.append("    push buffer\n");
            text.append("    call _sprintf\n");
            text.append("    add esp, 12\n");

            text.append("    push buffer\n");
            text.append("    call _system\n");
            text.append("    add esp, 4\n");
        }
    }
}