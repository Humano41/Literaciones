// Generated from Literaciones.g4 by ANTLR 4.13.2

    package com.ittepic.literaciones;
    
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;  
    import static com.ittepic.literaciones.Custom.HelperParser.*;
    import com.ittepic.literaciones.Custom.Simbolo;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LiteracionesParser}.
 */
public interface LiteracionesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LiteracionesParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LiteracionesParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LiteracionesParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LiteracionesParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LiteracionesParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void enterSentencias(LiteracionesParser.SentenciasContext ctx);
	/**
	 * Exit a parse tree produced by {@link LiteracionesParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void exitSentencias(LiteracionesParser.SentenciasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declara}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(LiteracionesParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declara}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(LiteracionesParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asig}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterAsig(LiteracionesParser.AsigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asig}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitAsig(LiteracionesParser.AsigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code show}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterShow(LiteracionesParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code show}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitShow(LiteracionesParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterCond(LiteracionesParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitCond(LiteracionesParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cic}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterCic(LiteracionesParser.CicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cic}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitCic(LiteracionesParser.CicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rep}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterRep(LiteracionesParser.RepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rep}
	 * labeled alternative in {@link LiteracionesParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitRep(LiteracionesParser.RepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code crear}
	 * labeled alternative in {@link LiteracionesParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterCrear(LiteracionesParser.CrearContext ctx);
	/**
	 * Exit a parse tree produced by the {@code crear}
	 * labeled alternative in {@link LiteracionesParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitCrear(LiteracionesParser.CrearContext ctx);
	/**
	 * Enter a parse tree produced by the {@code crea_asigna}
	 * labeled alternative in {@link LiteracionesParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterCrea_asigna(LiteracionesParser.Crea_asignaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code crea_asigna}
	 * labeled alternative in {@link LiteracionesParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitCrea_asigna(LiteracionesParser.Crea_asignaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asignar}
	 * labeled alternative in {@link LiteracionesParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignar(LiteracionesParser.AsignarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asignar}
	 * labeled alternative in {@link LiteracionesParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignar(LiteracionesParser.AsignarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code imp}
	 * labeled alternative in {@link LiteracionesParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void enterImp(LiteracionesParser.ImpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code imp}
	 * labeled alternative in {@link LiteracionesParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void exitImp(LiteracionesParser.ImpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_else}
	 * labeled alternative in {@link LiteracionesParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterIf_else(LiteracionesParser.If_elseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_else}
	 * labeled alternative in {@link LiteracionesParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitIf_else(LiteracionesParser.If_elseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link LiteracionesParser#ciclo}.
	 * @param ctx the parse tree
	 */
	void enterWhile(LiteracionesParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link LiteracionesParser#ciclo}.
	 * @param ctx the parse tree
	 */
	void exitWhile(LiteracionesParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for_simple}
	 * labeled alternative in {@link LiteracionesParser#repeat}.
	 * @param ctx the parse tree
	 */
	void enterFor_simple(LiteracionesParser.For_simpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for_simple}
	 * labeled alternative in {@link LiteracionesParser#repeat}.
	 * @param ctx the parse tree
	 */
	void exitFor_simple(LiteracionesParser.For_simpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link LiteracionesParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterNum(LiteracionesParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link LiteracionesParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitNum(LiteracionesParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ident}
	 * labeled alternative in {@link LiteracionesParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterIdent(LiteracionesParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ident}
	 * labeled alternative in {@link LiteracionesParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitIdent(LiteracionesParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresion}
	 * labeled alternative in {@link LiteracionesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(LiteracionesParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresion}
	 * labeled alternative in {@link LiteracionesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(LiteracionesParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link LiteracionesParser#expr_or}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(LiteracionesParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link LiteracionesParser#expr_or}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(LiteracionesParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogicaAnd}
	 * labeled alternative in {@link LiteracionesParser#expr_and}.
	 * @param ctx the parse tree
	 */
	void enterExprLogicaAnd(LiteracionesParser.ExprLogicaAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogicaAnd}
	 * labeled alternative in {@link LiteracionesParser#expr_and}.
	 * @param ctx the parse tree
	 */
	void exitExprLogicaAnd(LiteracionesParser.ExprLogicaAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprComparacion}
	 * labeled alternative in {@link LiteracionesParser#expr_comp}.
	 * @param ctx the parse tree
	 */
	void enterExprComparacion(LiteracionesParser.ExprComparacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprComparacion}
	 * labeled alternative in {@link LiteracionesParser#expr_comp}.
	 * @param ctx the parse tree
	 */
	void exitExprComparacion(LiteracionesParser.ExprComparacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArit}
	 * labeled alternative in {@link LiteracionesParser#expr_arit}.
	 * @param ctx the parse tree
	 */
	void enterExprArit(LiteracionesParser.ExprAritContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArit}
	 * labeled alternative in {@link LiteracionesParser#expr_arit}.
	 * @param ctx the parse tree
	 */
	void exitExprArit(LiteracionesParser.ExprAritContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprTerm}
	 * labeled alternative in {@link LiteracionesParser#expr_term}.
	 * @param ctx the parse tree
	 */
	void enterExprTerm(LiteracionesParser.ExprTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprTerm}
	 * labeled alternative in {@link LiteracionesParser#expr_term}.
	 * @param ctx the parse tree
	 */
	void exitExprTerm(LiteracionesParser.ExprTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code agrup}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAgrup(LiteracionesParser.AgrupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code agrup}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAgrup(LiteracionesParser.AgrupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negacion}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterNegacion(LiteracionesParser.NegacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negacion}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitNegacion(LiteracionesParser.NegacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code entero}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterEntero(LiteracionesParser.EnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code entero}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitEntero(LiteracionesParser.EnteroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(LiteracionesParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(LiteracionesParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cad}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterCad(LiteracionesParser.CadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cad}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitCad(LiteracionesParser.CadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool_true}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBool_true(LiteracionesParser.Bool_trueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool_true}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBool_true(LiteracionesParser.Bool_trueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ide}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIde(LiteracionesParser.IdeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ide}
	 * labeled alternative in {@link LiteracionesParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIde(LiteracionesParser.IdeContext ctx);
}