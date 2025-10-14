// Generated from Literaciones.g4 by ANTLR 4.13.2

    package com.ittepic.literaciones;
    
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;  
    import static com.ittepic.literaciones.Custom.HelperParser.*;
    import com.ittepic.literaciones.Custom.Simbolo;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LiteracionesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LiteracionesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LiteracionesParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LiteracionesParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LiteracionesParser#sentencias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencias(LiteracionesParser.SentenciasContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declara}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclara(LiteracionesParser.DeclaraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asig}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsig(LiteracionesParser.AsigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code show}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow(LiteracionesParser.ShowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(LiteracionesParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cic}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCic(LiteracionesParser.CicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rep}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRep(LiteracionesParser.RepContext ctx);
	/**
	 * Visit a parse tree produced by the {@code crear}
	 * labeled alternative in {@link LiteracionesParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrear(LiteracionesParser.CrearContext ctx);
	/**
	 * Visit a parse tree produced by the {@code crea_asigna}
	 * labeled alternative in {@link LiteracionesParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrea_asigna(LiteracionesParser.Crea_asignaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asignar}
	 * labeled alternative in {@link LiteracionesParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignar(LiteracionesParser.AsignarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code imp}
	 * labeled alternative in {@link LiteracionesParser#imprimir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImp(LiteracionesParser.ImpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_else}
	 * labeled alternative in {@link LiteracionesParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else(LiteracionesParser.If_elseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link LiteracionesParser#ciclo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(LiteracionesParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for_simple}
	 * labeled alternative in {@link LiteracionesParser#repeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_simple(LiteracionesParser.For_simpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link LiteracionesParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(LiteracionesParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ident}
	 * labeled alternative in {@link LiteracionesParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(LiteracionesParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresion}
	 * labeled alternative in {@link LiteracionesParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(LiteracionesParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link LiteracionesParser#expr_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(LiteracionesParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLogicaAnd}
	 * labeled alternative in {@link LiteracionesParser#expr_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogicaAnd(LiteracionesParser.ExprLogicaAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprComparacion}
	 * labeled alternative in {@link LiteracionesParser#expr_comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprComparacion(LiteracionesParser.ExprComparacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArit}
	 * labeled alternative in {@link LiteracionesParser#expr_arit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArit(LiteracionesParser.ExprAritContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprTerm}
	 * labeled alternative in {@link LiteracionesParser#expr_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTerm(LiteracionesParser.ExprTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code agrup}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgrup(LiteracionesParser.AgrupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negacion}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegacion(LiteracionesParser.NegacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code entero}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntero(LiteracionesParser.EnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(LiteracionesParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cad}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCad(LiteracionesParser.CadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_true}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_true(LiteracionesParser.Bool_trueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ide}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIde(LiteracionesParser.IdeContext ctx);
}