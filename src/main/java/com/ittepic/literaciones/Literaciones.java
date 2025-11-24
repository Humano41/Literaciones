/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ittepic.literaciones;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Literaciones {

    public static void main(String[] args) throws Exception {
  String input = "INICIO DECLARA X IGUAL 5 MOSTRAR X MAS 3 FINAL";

        // Lexer
        CharStream cs = CharStreams.fromString(input);
        LiteracionesLexer lexer = new LiteracionesLexer(cs);

        // Manejo de errores léxicos
        lexer.removeErrorListeners();
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine, String msg, RecognitionException e) {
                System.err.println("Error léxico en línea " + line + ":" + charPositionInLine + " -> " + msg);
            }
        });

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Parser
        LiteracionesParser parser = new LiteracionesParser(tokens);

        // Manejo de errores sintácticos
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine, String msg, RecognitionException e) {
                System.err.println("Error sintáctico en línea " + line + ":" + charPositionInLine + " -> " + msg);
            }
        });

        // Parsear el programa
        ParseTree tree = parser.programa();
        System.out.println(tree.toStringTree(parser));
    }
}