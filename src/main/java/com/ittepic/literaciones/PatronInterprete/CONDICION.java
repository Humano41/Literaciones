/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.PatronInterprete;

import java.util.List;

/**
 *
 * @author Humano 14
 */
public class CONDICION implements ASTNode {

    private ASTNode condition;
    private List<ASTNode> body;
    private List<ASTNode> elseBody;

    public CONDICION(ASTNode condition, List<ASTNode> body, List<ASTNode> elseBody) {
        super();
        this.condition = condition;
        this.body = body;
        this.elseBody = elseBody;
    }
    
    

    @Override
    public Object execute() {
        if ((boolean) condition.execute()) {
            for (ASTNode n : body) {
                n.execute();
            }
        } else {
            for (ASTNode n : body) {
                n.execute();
            }
        }
        return null;
    }

}
