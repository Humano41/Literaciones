/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orozc
 */
public class Instruction3DC {
    // Usamos String para los campos ya que pueden ser IDs (ej: 'x'),
    // Temporales (ej: 'T1'), Literales (ej: '10'), o Etiquetas (ej: 'L1').
    public final String operation;
    public final String result;
    public final String operand1;
    public final String operand2;

    
    /**
     * Constructor para operaciones binarias (ej: T1 = A + B)
     */
    public Instruction3DC(String operation, String result, String operand1, String operand2) {
        this.operation = operation;
        this.result = result;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    /**
     * Constructor para GOTO, PRINT, o instrucciones de un solo operando (ej: GOTO L1, PRINT X)
     */
    public Instruction3DC(String operation, String operand1) {
        // En este caso, el operando se asigna a operand1, y los demás son null
        this(operation, null, operand1, null);
    }
    
    /**
     * Constructor para ASIGNACIÓN simple (ej: X = T1) o LABEL (ej: L1:)
     */
    public Instruction3DC(String operation, String result, String operand1) {
        // Para asignación simple (result = operand1) o LABEL (result = Etiqueta)
        this(operation, result, operand1, null);
    }

    @Override
    public String toString() {
        // Formato para impresión o depuración
        switch (operation) {
            // Operaciones Aritméticas y Lógicas Binarias (Resultado = Op1 OPERACIÓN Op2)
            case "SUMA":
            case "RESTA":
            case "MULT": // MULT
            case "DIV":      // DIV
            case "AND":
            case "OR":
            case "MAYOR":
            case "MENOR":
            case "IGUAL_QUE":
                // Formato para operaciones binarias: T1 = A + B
                return String.format("%s = %s %s %s", result, operand1, operation, operand2);
            
            // Operaciones de Asignación y Unarias (Resultado = Operando1)
            case "ASSIGN":
                // Formato para asignación: X = T1 (o X = 10)
                return String.format("%s = %s", result, operand1);
            case "NOT":
                // Formato para negación: T1 = NOT T2
                return String.format("%s = NOT %s", result, operand1);
            
            // Estructuras de Control de Flujo
            case "IF_GOTO":
                // Formato IF_GOTO: IF T1 GOTO L1 (operand1 es la condición, operand2 es la etiqueta)
                return String.format("IF %s GOTO %s", operand1, operand2);
                
            case "GOTO":
                // Formato GOTO: GOTO L1 (operand1 es la etiqueta)
                return String.format("GOTO %s", operand1);
            
            // Etiquetas
            case "LABEL":
                // Formato LABEL: L1: (result es la etiqueta)
                return String.format("%s:", result);
            
            // I/O
            case "PRINT":
                // Formato PRINT: PRINT T1 (operand1 es el valor/temporal a imprimir)
                return String.format("PRINT %s", operand1);

            default:
                return "INSTRUCCIÓN INVÁLIDA (" + operation + ")";
        }
    }
}
