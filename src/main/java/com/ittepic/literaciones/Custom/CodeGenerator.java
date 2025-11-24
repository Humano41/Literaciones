/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    
    // Lista para almacenar todas las instrucciones generadas
    private final List<Instruction3DC> threeAddressCode = new ArrayList<>();
    
    // Contadores para asegurar nombres únicos
    private int tempCounter = 0;
    private int labelCounter = 0;
    
    // ===============================================
    // Métodos de Emisión
    // ===============================================

    /**
     * Añade una instrucción 3DC a la lista de código.
     * @param instruction
     */
    public void emit(Instruction3DC instruction) {
        threeAddressCode.add(instruction);
    }

    
    /**
     * Genera y retorna un nuevo nombre de variable temporal (ej: T0, T1, T2...).
     * @return 
     */
    public String newTemp() {
        return "T" + tempCounter++;
    }

    /**
     * Genera y retorna un nuevo nombre de etiqueta (ej: L0, L1, L2...).
     * @return 
     */
    public String newLabel() {
        return "L" + labelCounter++;
    }
    
    /**
     * Devuelve el código intermedio generado hasta el momento.
     * @return 
     */
    public List<Instruction3DC> getThreeAddressCode() {
        return threeAddressCode;
    }
    
    // Opcional: Implementar un singleton para fácil acceso global
    private static CodeGenerator instance;

    private CodeGenerator() {}

    public static CodeGenerator getInstance() {
        if (instance == null) {
            instance = new CodeGenerator();
        }
        return instance;
    }
    
    public List<Instruction3DC> getCode() {
        return this.threeAddressCode;
    }
    
    public void reset() {
        threeAddressCode.clear();
        tempCounter = 0;
        labelCounter = 0;
    }
}
