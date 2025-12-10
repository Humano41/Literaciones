/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.*;

/**
 *
 * @author Humano 14
 */
public class simplyTree {
    // Lista de reglas que NO queremos mostrar

    private static final String[] IGNORAR = {
        "expr_logica", "expr_comp", "expr_arit", "expr_term", "expr_factor",
        "logica", "comp", "arit", "expr"
    };

    // Método principal
    public static ParseTree simplificar(ParseTree nodo, List<String> ruleNames) {
        if (nodo instanceof TerminalNode) {
            return nodo; // Es un token final (NUMERO, ID, etc.)
        }

        String nombreRegla = ruleNames.get(((RuleNode) nodo).getRuleContext().getRuleIndex());

        // Si es una regla irrelevante con solo un hijo, la eliminamos
        if (esIrrelevante(nombreRegla) && nodo.getChildCount() == 1) {
            return simplificar(nodo.getChild(0), ruleNames);
        }

        // Si tiene varios hijos, simplificamos cada uno
        List<ParseTree> hijosSimplificados = new ArrayList<>();
        for (int i = 0; i < nodo.getChildCount(); i++) {
            hijosSimplificados.add(simplificar(nodo.getChild(i), ruleNames));
        }

        // Creamos un nuevo árbol más compacto
        return new NodoSimplificado(nombreRegla, hijosSimplificados) {};
    }

    private static boolean esIrrelevante(String nombre) {
        for (String r : IGNORAR) {
            if (nombre.equals(r)) {
                return true;
            }
        }
        return false;
    }
}
