/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

import com.ittepic.literaciones.*;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.*;

/**
 *
 * @author Humano 14
 */
public class CustomParser extends LiteracionesParser {

    private final CustomErrorListener ErrLis;
    
    public CustomParser(TokenStream input, JTextArea jtaOutput) {
        super(input);
        this.removeErrorListeners();
        this.ErrLis = new CustomErrorListener(jtaOutput);
     this.addErrorListener(this.ErrLis);
    }
  
    
public boolean ErrorSintax(){
    return this.ErrLis.ErrorList();
}
    

}
