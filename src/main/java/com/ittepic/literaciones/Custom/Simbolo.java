/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ittepic.literaciones.Custom;

/**
 *
 * @author jaime
 */
public class Simbolo {

    private String tipo;
    private Object valor;

public Simbolo(Object valor) {
    if (valor instanceof Simbolo) {
        // Si se pasa un Simbolo, se copia su estado interno en lugar de anidarlo.
        Simbolo inner = (Simbolo) valor;
        this.valor = inner.getValor();
        this.tipo = inner.getTipo();
    } else {
        this.valor = valor;
        this.tipo = inferirTipo(valor);
    }
}

    private String inferirTipo(Object valor) {
        if (valor == null) {
            return "Indefinido";
        }
        if (valor instanceof Integer) {
            return "Entero";
        }
        if (valor instanceof Double || valor instanceof Float) {
            return "Decimal";
        }
        if (valor instanceof String) {
            return "Cadena";
        }
        if (valor instanceof Boolean) {
            return "Boolean";
        }
        return "Desconocido";
    }

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
        this.tipo = inferirTipo(valor); // actualiza tipo al cambiar valor
    }

    @Override
    public String toString() {
        return String.format("[%s: %s]", tipo, valor);
    }

}
