/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.misc.Interval;

import java.util.List;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public class NodoSimplificado implements ParseTree {

    private final String nombre;
    private final List<ParseTree> hijos;

    public NodoSimplificado(String nombre, List<ParseTree> hijos) {
        this.nombre = nombre;
        this.hijos = hijos;
    }

    // ---------- MÉTODOS OBLIGATORIOS DE Tree / ParseTree ----------
    @Override
    public ParseTree getChild(int i) {
        return hijos.get(i);
    }

    @Override
    public int getChildCount() {
        return hijos.size();
    }

    @Override
    public ParseTree getParent() {
        return null; // no necesitamos jerarquía inversa para el TreeViewer
    }

    @Override
    public Object getPayload() {
        return nombre;
    }

    @Override
    public Interval getSourceInterval() {
        return Interval.INVALID; // no se usa, pero es requerido
    }

    @Override
    public String getText() {
        return nombre;
    }

    // ---------- VISUALIZACIÓN ----------
    @Override
    public String toStringTree() {
        return nombre;
    }

    @Override
    public String toStringTree(org.antlr.v4.runtime.Parser parser) {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public void setParent(RuleContext rc) {
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> ptv) {
        return null;
    }

}
