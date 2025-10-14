/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

import java.util.List;
import java.util.Map;

public class HelperParser {

// ==============================
// 🔹 Operaciones aritméticas
// ==============================
    public static Object evalArit(Simbolo a, String op, Simbolo b, List<String> listaErrores, int linea, int columna) {
        // Verificar que ambos sean numéricos
        if (a == null || b == null || a.getTipo().equals("Indefinido") || b.getTipo().equals("Indefinido")) {
            listaErrores.add(ErrorText(linea, columna, "Operacion aritmética sobre valor nulo o indefinido"));
            return null;
        }

        if (a.getTipo().equals("Cadena") || b.getTipo().equals("Cadena")) {
            switch (op) {
                case "+", "SUMA", "MAS", "AÑADE", "JUNTA" -> {
                    String x = a.getValor().toString();
                    String y = b.getValor().toString();
                    return x + y;
                }
            }
        }

        if (!a.getTipo().equals("Entero") && !a.getTipo().equals("Decimal")
                || !b.getTipo().equals("Entero") && !b.getTipo().equals("Decimal")) {
            listaErrores.add(ErrorText(linea, columna, "Operacion aritmética entre tipos incompatibles: " + a.getTipo() + " y " + b.getTipo()));
            return null;
        }

        double x = ((Number) a.getValor()).doubleValue();
        double y = ((Number) b.getValor()).doubleValue();

        switch (op) {
            case "+", "SUMA", "MAS", "AÑADE", "JUNTA" -> {
                // Mantener entero si ambos son "Numero"
                if (a.getTipo().equals("Entero") && b.getTipo().equals("Entero")) {
                    return (int) (x + y); // devuelve Integer
                } else {
                    return x + y; // devuelve Double
                }
            }
            case "-", "RESTA", "QUITA", "REDUCE", "MENOS" -> {
                if (a.getTipo().equals("Entero") && b.getTipo().equals("Entero")) {
                    return (int) (x - y);
                } else {
                    return x - y;
                }
            }
            case "*", "MULTIPLICA", "POR", "CRECE" -> {
                if (a.getTipo().equals("Entero") && b.getTipo().equals("Entero")) {
                    return (int) (x * y);
                } else {
                    return x * y;
                }
            }
            case "/", "ENTRE", "REPARTE", "SEPARA" -> {
                if (y == 0) {
                    listaErrores.add(ErrorText(linea, columna, "Division entre cero"));
                    return null;
                }
                return x / y; // siempre Double para división
            }
            default -> {
                listaErrores.add(ErrorText(linea, columna, "Operador aritmético desconocido: " + op));
                return null;
            }
        }
    }
        // ==============================
        // 🔹 Operaciones lógicas
        // ==============================

    public static Boolean evalAnd(Simbolo a, Simbolo b, List<String> listaErrores, int linea, int columna) {
        if (a == null || b == null || !a.getTipo().equals("Boolean") || !b.getTipo().equals("Boolean")) {
            listaErrores.add(ErrorText(linea, columna, "Operacion AND entre tipos incompatibles"));
            return null;
        }
        return (Boolean) a.getValor() && (Boolean) b.getValor();
    }

    public static Boolean evalOr(Simbolo a, Simbolo b, List<String> listaErrores, int linea, int columna) {
        if (a == null || b == null || !a.getTipo().equals("Boolean") || !b.getTipo().equals("Boolean")) {
            listaErrores.add(ErrorText(linea, columna, "Operacion OR entre tipos incompatibles"));
            return null;
        }
        return (Boolean) a.getValor() || (Boolean) b.getValor();
    }

// ==============================
// 🔹 Comparaciones
// ==============================
    public static Boolean evalComp(Simbolo a, String op, Simbolo b, List<String> listaErrores, int linea, int columna) {
        if (a == null || b == null) {
            listaErrores.add(ErrorText(linea, columna, "Comparacion sobre valor nulo"));
            return null;
        }

        // Comparación de números
        if ((a.getTipo().equals("Entero") || a.getTipo().equals("Decimal"))
                && (b.getTipo().equals("Entero") || b.getTipo().equals("Decimal"))) {

            double x = ((Number) a.getValor()).doubleValue();
            double y = ((Number) b.getValor()).doubleValue();

            return switch (op) {
                case "==", "COINCIDE", "EQUIVALE", "MISMO", "IGUAL_QUE" ->
                    x == y;
                case "MAYOR", "SOBREPASA", "ARRIBA", "SUPERIOR", ">" ->
                    x > y;
                case "MENOR", "INFERIOR", "DEBAJO", "<" ->
                    x < y;
                default -> {
                    listaErrores.add(ErrorText(linea, columna, "Operador de comparación desconocido: " + op));
                    yield null;
                }
            };
        }

        // Comparación de cadenas o booleanos
        if (a.getTipo().equals(b.getTipo())) {
            if (op.equals("==") || op.equals("COINCIDE") || op.equals("EQUIVALE") || op.equals("MISMO") || op.equals("IGUAL_QUE")) {
                return a.getValor().equals(b.getValor());
            } else {
                listaErrores.add(ErrorText(linea, columna, "Operador de comparación no válido para tipo: " + a.getTipo()));
                return null;
            }
        }

        // Tipos incompatibles
        listaErrores.add(ErrorText(linea, columna, "Comparación entre tipos incompatibles: " + a.getTipo() + " y " + b.getTipo()));
        return null;
    }

// ==============================
// 🔹 Negación lógica
// ==============================
    public static Boolean evalNot(Simbolo a, List<String> listaErrores, int linea, int columna) {
        if (a == null || !a.getTipo().equals("Boolean")) {
            listaErrores.add(ErrorText(linea, columna, "Negación de tipo no booleano"));
            return null;
        }
        return !(Boolean) a.getValor();
    }

    public static Simbolo wrap(Object o) {
        if (o instanceof Simbolo) {
            return (Simbolo) o;
        }
        return new Simbolo(o); // inferirá tipo automáticamente
    }

    //CLASE PARA INSERTAR ERRORES
    public static String ErrorText(int line, int column, String textError) {
        return String.format("Error semántico en línea %d, columna %d: %s", line, column, textError);
    }

}
