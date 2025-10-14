/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones;
/**
 *
 * @author orozc
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import org.antlr.v4.runtime.*;
import com.ittepic.literaciones.*;
import com.ittepic.literaciones.LiteracionesLexer;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import org.antlr.v4.runtime.*;

// Asegúrate de que tu Lexer sea accesible
// import com.ittepic.literaciones.LiteracionesLexer; 

public class Coloreador {
    private final JTextPane jtp;
    private final StyledDocument doc;
    // Agregamos estiloID a la declaración de variables finales
    private final Style estiloDefault, estiloKeyword, estiloNumero, estiloCadena, estiloComentario, estiloID;

    public Coloreador(JTextPane jtp) {
        this.jtp = jtp;
        this.doc = jtp.getStyledDocument();
        doc.removeStyle("default");
        doc.removeStyle("keyword");
        doc.removeStyle("numero");
        doc.removeStyle("cadena");
        doc.removeStyle("comentario");
        doc.removeStyle("identificador"); // Limpiar el estilo si existe

        // --- estilos básicos ---
        estiloDefault = doc.addStyle("default", null);
        StyleConstants.setForeground(estiloDefault, Color.BLACK); 

        // AZUL (Palabras Clave)
        estiloKeyword = doc.addStyle("keyword", null);
        StyleConstants.setForeground(estiloKeyword, new Color(0, 0, 255)); 

        // ROJO (Números)
        estiloNumero = doc.addStyle("numero", null);
        StyleConstants.setForeground(estiloNumero, new Color(200, 0, 0)); 

        // NARANJA (Cadenas de Texto)
        estiloCadena = doc.addStyle("cadena", null);
        StyleConstants.setForeground(estiloCadena, new Color(255, 140, 0)); 

        // VERDE (Comentarios)
        estiloComentario = doc.addStyle("comentario", null);
        StyleConstants.setForeground(estiloComentario, new Color(0, 150, 0)); 
        
        // ************ NUEVO ESTILO: IDENTIFICADORES (ID) ************
        estiloID = doc.addStyle("identificador", null);
        StyleConstants.setBold(estiloID, true); // En Negritas
        // ************************************************************
    }

    public void colorear() {
        SwingUtilities.invokeLater(() -> {
            try {
                String textoOriginal = jtp.getText();
                doc.setCharacterAttributes(0, textoOriginal.length(), estiloDefault, true);

                // 1. Normalizar la entrada para manejar saltos de línea consistentes.
                String textoNormalizado = textoOriginal.replace("\r\n", "\n");
                CharStream input = CharStreams.fromString(textoNormalizado); 
                LiteracionesLexer lexer = new LiteracionesLexer(input);

                lexer.removeErrorListeners();

                Token token;
                while ((token = lexer.nextToken()).getType() != Token.EOF) {
                    
                    int start = token.getStartIndex();
                    int length = token.getStopIndex() - start + 1; 

                    // Filtro para ignorar tokens de longitud 1 (caracteres invisibles) y WS
                    if (length == 1 && 
                        (token.getType() == LiteracionesLexer.ERROR || 
                         token.getType() == LiteracionesLexer.WS)) 
                    {
                        continue; 
                    }
                    
                    // Asegurar que los tokens WS (si el Lexer los envía) no se pinten.
                    if (token.getType() == LiteracionesLexer.WS || 
                        token.getType() == LiteracionesLexer.PALABRA_VACIA) {
                        continue; 
                    }

                    Style estilo = obtenerEstilo(token);
                    if (estilo != null)
                        doc.setCharacterAttributes(start, length, estilo, true);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    private Style obtenerEstilo(Token token) {
        int type = token.getType();

        // ** REGLAS LÉXICAS PRIORITARIAS **
        if (type == LiteracionesLexer.LINE_COMMENT || type == LiteracionesLexer.BLOCK_COMMENT)
            return estiloComentario;

        if (type == LiteracionesLexer.NUMERO || type == LiteracionesLexer.NUMERO_DEC)
            return estiloNumero;

        if (type == LiteracionesLexer.CADENA)
            return estiloCadena;
        
        // ************ AHORA ID SE PINTA DE PÚRPURA Y NEGRITA ************
        if (type == LiteracionesLexer.ID)
            return estiloID;

        // ** KEYWORDS (Palabras Clave) **
        switch (type) {
            case LiteracionesLexer.INICIO:
            case LiteracionesLexer.FINAL:
            case LiteracionesLexer.IF:
            case LiteracionesLexer.ELSE:
            case LiteracionesLexer.WHILE:
            case LiteracionesLexer.THEN:
            case LiteracionesLexer.FOR:
            case LiteracionesLexer.FIN:
            case LiteracionesLexer.PRINT:
            case LiteracionesLexer.ASIGNA:
            case LiteracionesLexer.DECLARA:
            case LiteracionesLexer.SUMA:
            case LiteracionesLexer.RESTA:
            case LiteracionesLexer.MULT:
            case LiteracionesLexer.DIV:
            case LiteracionesLexer.AND:
            case LiteracionesLexer.OR:
            case LiteracionesLexer.NOT:
            case LiteracionesLexer.IGUAL_QUE:
            case LiteracionesLexer.MAYOR:
            case LiteracionesLexer.MENOR:
            case LiteracionesLexer.VERDADERO:
            case LiteracionesLexer.FALSO:
                return estiloKeyword;
        }
        
        // ** MANEJO DE ERRORES **
        // Si el Lexer devuelve un tipo de token desconocido o ERROR.
        return estiloDefault; 
    }
}