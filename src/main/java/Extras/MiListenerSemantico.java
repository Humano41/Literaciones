/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;
import com.ittepic.literaciones.Custom.Simbolo;
import com.ittepic.literaciones.LiteracionesBaseListener;
import com.ittepic.literaciones.LiteracionesParser;
import java.util.List;
import java.util.ArrayList;   
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
/**
 *
 * @author jaime
 */

public class MiListenerSemantico extends LiteracionesBaseListener {
    
    private final TablaSimbolos tablaSimbolos;
    private final List<String> listaErrores;

    public MiListenerSemantico(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
        this.listaErrores = new ArrayList<>();
    }

    public List<String> getErroresSemanticos() {
        return listaErrores;
    }

    // --- MANEJO DE DECLARACIONES ---

    // Se ejecuta para la regla: DECLARA nombre=ID
    @Override
    public void enterCrear(LiteracionesParser.CrearContext ctx) {
        revisarDeclaracion(ctx.ID);
    }

    // Se ejecuta para la regla: DECLARA nombre=ID ASIGNA expr
    @Override
    public void enterCrea_asigna(LiteracionesParser.Crea_asignaContext ctx) {
        revisarDeclaracion(ctx.ID);
        // Aquí también podrías analizar el tipo de la 'expr' si tuvieras tipos
    }

    // --- MANEJO DE USO DE VARIABLES ---

    // Se ejecuta para: variable=ID ASIGNA expr
    @Override
    public void enterAsignar(LiteracionesParser.AsignarContext ctx) {
        revisarUsoVariable(ctx.ID);
    }

    // Se ejecuta cuando un ID se usa en una expresión (ej: SI Energia > 5)
    @Override
    public void enterIde(LiteracionesParser.IdeContext ctx) {
        revisarUsoVariable(ctx.ID);
    }
    
    /* Se ejecuta cuando un ID se usa en un ciclo REPETIR (ej: REPETIR variable)
    @Override
    public void enterIdentificador(LiteracionesParser.IdentificadorContext ctx) {
        revisarUsoVariable(ctx.variable);
    }
    */

    // --- MÉTODOS DE AYUDA PARA NO REPETIR CÓDIGO ---

    /**
     * Revisa si una variable ya fue declarada. Si no, la agrega a la tabla.
     * @param idToken El token del identificador que se está declarando.
     */
    private void revisarDeclaracion(Token idToken) {
        String nombreVariable = idToken.getText();
        Simbolo nuevoSimbolo = new Simbolo("Variable");

        if (!tablaSimbolos.agregar(nuevoSimbolo)) {
            // Error: la variable ya existe
            int linea = idToken.getLine();
            int columna = idToken.getCharPositionInLine();
            String error = String.format("Error semántico en línea %d:%d - La variable '%s' ya ha sido declarada.",
                    linea, columna, nombreVariable);
            listaErrores.add(error);
        }
    }

    /**
     * Revisa si una variable que se está usando ha sido declarada previamente.
     * @param idToken El token del identificador que se está usando.
     */
    private void revisarUsoVariable(Token idToken) {
        String nombreVariable = idToken.getText();
        if (tablaSimbolos.buscar(nombreVariable) == null) {
            // Error: la variable no existe
            int linea = idToken.getLine();
            int columna = idToken.getCharPositionInLine();
            String error = String.format("Error semántico en línea %d:%d - La variable '%s' no ha sido declarada.",
                    linea, columna, nombreVariable);
            listaErrores.add(error);
        }
    }
}

