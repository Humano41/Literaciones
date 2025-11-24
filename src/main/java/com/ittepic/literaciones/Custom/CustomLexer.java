/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

import com.ittepic.literaciones.*;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;

/**
 *
 * @author Humano 14
 */
public class CustomLexer extends LiteracionesLexer {

    public CustomLexer(CharStream input, JTextArea jtaOutput) {
        super(input);
        this.removeErrorListeners();
        this.addErrorListener(new CustomErrorListener(jtaOutput));
    }
    
    


}
