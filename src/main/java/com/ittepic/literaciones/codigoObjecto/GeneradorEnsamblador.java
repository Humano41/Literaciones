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

    // Rastrear qué variables contienen Strings
    private Set<String> variablesTipoString = new HashSet<>();

    public void generarArchivo(List<Instruction3DC> instrucciones, String rutaSalida) {
        StringBuilder dataSection = new StringBuilder();
        StringBuilder bssSection = new StringBuilder();
        StringBuilder textSection = new StringBuilder();

        // Resetear para cada generación
        variablesDeclaradas.clear();
        stringLiterals.clear();
        variablesTipoString.clear();

        // 1. CABECERA Y FUNCIONES EXTERNAS
        textSection.append("global _main\n");
        textSection.append("extern printf\n");
        textSection.append("extern sprintf\n");
        textSection.append("extern system\n");
        textSection.append("extern _exit\n");
        textSection.append("extern _strdup\n\n");

        textSection.append("section .text\n");
        textSection.append("_main:\n");
        textSection.append("    push ebp\n");
        textSection.append("    mov ebp, esp\n\n");

        // 2. SECCIÓN DATA (Constantes y Formatos)
        dataSection.append("section .data\n");
        dataSection.append("    fmt_int db \"%d\", 10, 0\n");
        dataSection.append("    fmt_str db \"%s\", 10, 0\n");
        dataSection.append("    fmt_str_str db \"%s%s\", 0\n");
        dataSection.append("    fmt_str_int db \"%s%d\", 0\n");
        dataSection.append("    fmt_int_str db \"%d%s\", 0\n");

        // CORRECCIÓN AQUÍ: Usamos "> NUL" que es compatible con cmd.exe
        dataSection.append("    cmd_speak_str db \"powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%s') > NUL\", 0\n");
        dataSection.append("    cmd_speak_int db \"powershell -c (New-Object -ComObject SAPI.SpVoice).Speak('%d') > NUL\", 0\n");

        // 3. SECCIÓN BSS (Variables y Buffers)
        bssSection.append("section .bss\n");
        bssSection.append("    buffer resb 1024\n");

        // 4. TRADUCCIÓN DE INSTRUCCIONES
        // 1: Registrar variables
        for (Instruction3DC inst : instrucciones) {
            registrarVariable(inst.result, bssSection);
        }

        // 2: Generar código
        for (Instruction3DC inst : instrucciones) {
            textSection.append("    ; ").append(inst.toString()).append("\n");

            switch (inst.operation) {
                case "ASSIGN":
                    if (esTexto(inst.operand1)) {
                        variablesTipoString.add(inst.result);
                        String val = procesarOperando(inst.operand1, dataSection);
                        if (inst.operand1.startsWith("\"")) {
                            textSection.append("    mov dword [").append(inst.result).append("], ").append(val).append("\n");
                        } else {
                            textSection.append("    mov eax, ").append(val).append("\n");
                            textSection.append("    mov [").append(inst.result).append("], eax\n");
                        }
                    } else {
                        variablesTipoString.remove(inst.result);
                        String val = procesarOperando(inst.operand1, dataSection);
                        textSection.append("    mov eax, ").append(val).append("\n");
                        textSection.append("    mov [").append(inst.result).append("], eax\n");
                    }
                    break;

                case "SUMA":
                    if (esTexto(inst.operand1) || esTexto(inst.operand2)) {
                        variablesTipoString.add(inst.result);
                        generarConcatenacion(inst, textSection, dataSection);
                    } else {
                        variablesTipoString.remove(inst.result);
                        textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                        textSection.append("    add eax, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                        textSection.append("    mov [").append(inst.result).append("], eax\n");
                    }
                    break;

                case "RESTA":
                case "MULT":
                case "DIV":
                    variablesTipoString.remove(inst.result);
                    String opCode = "";
                    if (inst.operation.equals("RESTA")) {
                        opCode = "sub";
                    }
                    if (inst.operation.equals("MULT")) {
                        opCode = "imul";
                    }

                    if (inst.operation.equals("DIV")) {
                        textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                        textSection.append("    mov ecx, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                        textSection.append("    cdq\n");
                        textSection.append("    idiv ecx\n");
                        textSection.append("    mov [").append(inst.result).append("], eax\n");
                    } else {
                        textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                        textSection.append("    ").append(opCode).append(" eax, ").append(procesarOperando(inst.operand2, dataSection)).append("\n");
                        textSection.append("    mov [").append(inst.result).append("], eax\n");
                    }
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

                case "MAYOR":
                    generarComp("setg", inst, textSection, dataSection);
                    break;
                case "MENOR":
                    generarComp("setl", inst, textSection, dataSection);
                    break;
                case "IGUAL_QUE":
                    generarComp("sete", inst, textSection, dataSection);
                    break;

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

                case "NOT":
                    textSection.append("    mov eax, ").append(procesarOperando(inst.operand1, dataSection)).append("\n");
                    textSection.append("    cmp eax, 0\n");
                    textSection.append("    mov eax, 0\n");
                    textSection.append("    sete al\n");
                    textSection.append("    mov [").append(inst.result).append("], eax\n");
                    break;
            }
            textSection.append("\n");
        }

        // Salida
        textSection.append("    push 0\n");
        textSection.append("    call _exit\n");

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
            bss.append("    ").append(var).append(" resd 1\n");
            variablesDeclaradas.add(var);
        }
    }

    private boolean esTexto(String op) {
        if (op == null) {
            return false;
        }
        return op.startsWith("\"") || variablesTipoString.contains(op);
    }

    private String procesarOperando(String op, StringBuilder data) {
        if (op == null) {
            return "0";
        }

        if (op.startsWith("\"")) {
            if (stringLiterals.containsKey(op)) {
                return stringLiterals.get(op);
            }
            String label = "str_" + Math.abs(op.hashCode()) + "_" + stringLiterals.size();
            data.append("    ").append(label).append(" db ").append(op).append(", 0\n");
            stringLiterals.put(op, label);
            return label;
        }

        if (op.matches("-?\\d+")) {
            return op;
        }
        if (op.equalsIgnoreCase("true") || op.equalsIgnoreCase("VERDADERO")) {
            return "1";
        }
        if (op.equalsIgnoreCase("false") || op.equalsIgnoreCase("FALSO")) {
            return "0";
        }

        return "[" + op + "]";
    }

    private void generarComp(String setInst, Instruction3DC inst, StringBuilder sb, StringBuilder data) {
        variablesTipoString.remove(inst.result);
        sb.append("    mov eax, ").append(procesarOperando(inst.operand1, data)).append("\n");
        sb.append("    cmp eax, ").append(procesarOperando(inst.operand2, data)).append("\n");
        sb.append("    mov eax, 0\n");
        sb.append("    ").append(setInst).append(" al\n");
        sb.append("    mov [").append(inst.result).append("], eax\n");
    }

    private void generarConcatenacion(Instruction3DC inst, StringBuilder text, StringBuilder data) {
        String op1Val = procesarOperando(inst.operand1, data);
        String op2Val = procesarOperando(inst.operand2, data);

        boolean op1Texto = esTexto(inst.operand1);
        boolean op2Texto = esTexto(inst.operand2);

        String fmt;
        if (op1Texto && op2Texto) {
            fmt = "fmt_str_str";
        } else if (op1Texto && !op2Texto) {
            fmt = "fmt_str_int";
        } else {
            fmt = "fmt_int_str";
        }

        text.append("    ; -- Concat --\n");

        if (op2Texto) {
            text.append("    push ").append(op2Val).append("\n");
        } else {
            text.append("    push dword ").append(op2Val).append("\n");
        }

        if (op1Texto) {
            text.append("    push ").append(op1Val).append("\n");
        } else {
            text.append("    push dword ").append(op1Val).append("\n");
        }

        text.append("    push ").append(fmt).append("\n");
        text.append("    push buffer\n");
        text.append("    call sprintf\n");
        text.append("    add esp, 16\n");

        text.append("    push buffer\n");
        text.append("    call _strdup\n");
        text.append("    add esp, 4\n");
        text.append("    mov [").append(inst.result).append("], eax\n");
    }

    private void generarPrint(String op, StringBuilder text, StringBuilder data) {
        String val = procesarOperando(op, data);
        boolean esTxt = esTexto(op);

        // 1. IMPRIMIR EN CONSOLA
        text.append("    ; Imprimir en Pantalla\n");
        if (esTxt) {
            text.append("    push ").append(val).append("\n");
            text.append("    push fmt_str\n");
        } else {
            text.append("    push dword ").append(val).append("\n");
            text.append("    push fmt_int\n");
        }
        text.append("    call printf\n");
        text.append("    add esp, 8\n");

        // 2. NARRAR CON POWERSHELL
        text.append("    ; Narrar con PowerShell\n");

        if (esTxt) {
            text.append("    push ").append(val).append("\n");
            text.append("    push cmd_speak_str\n");
        } else {
            text.append("    push dword ").append(val).append("\n");
            text.append("    push cmd_speak_int\n");
        }
        text.append("    push buffer\n");
        text.append("    call sprintf\n");
        text.append("    add esp, 12\n");

        text.append("    push buffer\n");
        text.append("    call system\n");
        text.append("    add esp, 4\n");
    }
}
