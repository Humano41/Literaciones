/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.PatronInterprete;

/**
 *
 * @author Humano 14
 */
public class PRINT implements ASTNode {
    private ASTNode data;

    public PRINT(ASTNode data) {
        super();
        this.data = data;
    }
    
    
    @Override
    public Object execute() {
        System.out.println(data.execute());
        return null;
    }
    
}
