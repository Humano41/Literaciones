/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {

    public List<String> Errores = new ArrayList<>();
    private JTextArea outputArea;

    public CustomErrorListener(JTextArea jtaOutput) {
        this.outputArea = jtaOutput;
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        // Identifica si es léxico o sintáctico según el recognizer
        String tipo = (recognizer instanceof Lexer) ? "Error Léxico" : "Error Sintáctico";
        
        Errores.add(tipo + " -> linea " + line + ":" + charPositionInLine + " " + trans(msg));
        outputArea.append("\n" + tipo + " -> linea " + line + ":" + charPositionInLine + " " + trans(msg));
    }
    
    private String trans(String msg) {
        // Traducciones básicas de mensajes comunes de ANTLR
        msg = msg.replace("mismatched input", "entrada no coincide");
        msg = msg.replace("expecting", "se esperaba");
        msg = msg.replace("extraneous input", "entrada extra");
        msg = msg.replace("missing", "falta");
        msg = msg.replace("<EOF>", "fin de codigo");
        msg = msg.replace("at", "en");
        msg = msg.replace("no viable alternenive", "no hay alternativa viable");
        return msg;
    }
    
    
public boolean ErrorList(){
    return Errores.isEmpty();
}

}
