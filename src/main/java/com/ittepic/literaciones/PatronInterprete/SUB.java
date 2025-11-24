/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.PatronInterprete;

/**
 *
 * @author Humano 14
 */
public class SUB implements ASTNode {
private ASTNode Op1;
private ASTNode Op2;

    public SUB(ASTNode Op1, ASTNode Op2) {
        super();
        this.Op1 = Op1;
        this.Op2 = Op2;
    }
    

    @Override
    public Object execute() {
        
        return (int)Op1.execute() - (int)Op2.execute();
    }
    
}
