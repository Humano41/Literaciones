// Generated from Literaciones.g4 by ANTLR 4.13.2

    package com.ittepic.literaciones;
    
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;  
    import static com.ittepic.literaciones.Custom.HelperParser.*;
    import com.ittepic.literaciones.Custom.Simbolo;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LiteracionesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INICIO=3, FINAL=4, IF=5, ELSE=6, WHILE=7, THEN=8, FOR=9, 
		FIN=10, PRINT=11, ASIGNA=12, DECLARA=13, SUMA=14, RESTA=15, MULT=16, DIV=17, 
		AND=18, OR=19, NOT=20, IGUAL_QUE=21, MAYOR=22, MENOR=23, VERDADERO=24, 
		FALSO=25, CADENA=26, NUMERO_DEC=27, NUMERO=28, ID=29, FINSENTENCIA=30, 
		COMPLEMENTO=31, WS=32, LINE_COMMENT=33, BLOCK_COMMENT=34, PALABRA_VACIA=35, 
		ERROR=36;
	public static final int
		RULE_programa = 0, RULE_sentencias = 1, RULE_sentencia = 2, RULE_declaracion = 3, 
		RULE_asignacion = 4, RULE_imprimir = 5, RULE_condicion = 6, RULE_ciclo = 7, 
		RULE_repeat = 8, RULE_valor = 9, RULE_expr = 10, RULE_expr_or = 11, RULE_expr_and = 12, 
		RULE_expr_comp = 13, RULE_expr_arit = 14, RULE_expr_term = 15, RULE_term = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "sentencias", "sentencia", "declaracion", "asignacion", "imprimir", 
			"condicion", "ciclo", "repeat", "valor", "expr", "expr_or", "expr_and", 
			"expr_comp", "expr_arit", "expr_term", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INICIO", "FINAL", "IF", "ELSE", "WHILE", "THEN", "FOR", 
			"FIN", "PRINT", "ASIGNA", "DECLARA", "SUMA", "RESTA", "MULT", "DIV", 
			"AND", "OR", "NOT", "IGUAL_QUE", "MAYOR", "MENOR", "VERDADERO", "FALSO", 
			"CADENA", "NUMERO_DEC", "NUMERO", "ID", "FINSENTENCIA", "COMPLEMENTO", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT", "PALABRA_VACIA", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Literaciones.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public Map<String, Simbolo> tablaSimbolos = new HashMap<>();
	    public List<String> listaErrores = new ArrayList<>();
	    
	public LiteracionesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(LiteracionesParser.INICIO, 0); }
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public TerminalNode FINAL() { return getToken(LiteracionesParser.FINAL, 0); }
		public TerminalNode EOF() { return getToken(LiteracionesParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(INICIO);
			setState(35);
			sentencias();
			setState(36);
			match(FINAL);
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciasContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public List<TerminalNode> FINSENTENCIA() { return getTokens(LiteracionesParser.FINSENTENCIA); }
		public TerminalNode FINSENTENCIA(int i) {
			return getToken(LiteracionesParser.FINSENTENCIA, i);
		}
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterSentencias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitSentencias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitSentencias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentencias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536881824L) != 0)) {
				{
				{
				setState(39);
				sentencia();
				setState(40);
				match(FINSENTENCIA);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	 
		public SentenciaContext() { }
		public void copyFrom(SentenciaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaraContext extends SentenciaContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public DeclaraContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitDeclara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitDeclara(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShowContext extends SentenciaContext {
		public ImprimirContext imprimir() {
			return getRuleContext(ImprimirContext.class,0);
		}
		public ShowContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterShow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitShow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitShow(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondContext extends SentenciaContext {
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public CondContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CicContext extends SentenciaContext {
		public CicloContext ciclo() {
			return getRuleContext(CicloContext.class,0);
		}
		public CicContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterCic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitCic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitCic(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepContext extends SentenciaContext {
		public RepeatContext repeat() {
			return getRuleContext(RepeatContext.class,0);
		}
		public RepContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterRep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitRep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitRep(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsigContext extends SentenciaContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public AsigContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterAsig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitAsig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentencia);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARA:
				_localctx = new DeclaraContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				declaracion();
				}
				break;
			case ID:
				_localctx = new AsigContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				asignacion();
				}
				break;
			case PRINT:
				_localctx = new ShowContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				imprimir();
				}
				break;
			case IF:
				_localctx = new CondContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				condicion();
				}
				break;
			case WHILE:
				_localctx = new CicContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				ciclo();
				}
				break;
			case FOR:
				_localctx = new RepContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				repeat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	 
		public DeclaracionContext() { }
		public void copyFrom(DeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Crea_asignaContext extends DeclaracionContext {
		public Token ID;
		public ExprContext expr;
		public TerminalNode DECLARA() { return getToken(LiteracionesParser.DECLARA, 0); }
		public TerminalNode ID() { return getToken(LiteracionesParser.ID, 0); }
		public TerminalNode ASIGNA() { return getToken(LiteracionesParser.ASIGNA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Crea_asignaContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterCrea_asigna(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitCrea_asigna(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitCrea_asigna(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CrearContext extends DeclaracionContext {
		public Token ID;
		public TerminalNode DECLARA() { return getToken(LiteracionesParser.DECLARA, 0); }
		public TerminalNode ID() { return getToken(LiteracionesParser.ID, 0); }
		public CrearContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterCrear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitCrear(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitCrear(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new CrearContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(DECLARA);
				setState(56);
				((CrearContext)_localctx).ID = match(ID);
				 
				                if (tablaSimbolos.containsKey((((CrearContext)_localctx).ID!=null?((CrearContext)_localctx).ID.getText():null))) {
				                    listaErrores.add(ErrorText(((CrearContext)_localctx).ID.getLine(), ((CrearContext)_localctx).ID.getCharPositionInLine(), "la variable '" + (((CrearContext)_localctx).ID!=null?((CrearContext)_localctx).ID.getText():null) + "' ya fue declarada."));
				                } else {
				                    tablaSimbolos.put((((CrearContext)_localctx).ID!=null?((CrearContext)_localctx).ID.getText():null), null); 
				                }
				    
				}
				break;
			case 2:
				_localctx = new Crea_asignaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(DECLARA);
				setState(59);
				((Crea_asignaContext)_localctx).ID = match(ID);
				setState(60);
				match(ASIGNA);
				setState(61);
				((Crea_asignaContext)_localctx).expr = expr();
				 
				        if (tablaSimbolos.containsKey((((Crea_asignaContext)_localctx).ID!=null?((Crea_asignaContext)_localctx).ID.getText():null))) {
				            listaErrores.add(ErrorText(((Crea_asignaContext)_localctx).ID.getLine(), ((Crea_asignaContext)_localctx).ID.getCharPositionInLine(), "la variable '" + (((Crea_asignaContext)_localctx).ID!=null?((Crea_asignaContext)_localctx).ID.getText():null) + "' ya fue declarada."));
				        } 
				        else {
				                    Simbolo S = new Simbolo(((Crea_asignaContext)_localctx).expr.value);
				                    tablaSimbolos.put((((Crea_asignaContext)_localctx).ID!=null?((Crea_asignaContext)_localctx).ID.getText():null), S);
				        }
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	 
		public AsignacionContext() { }
		public void copyFrom(AsignacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignarContext extends AsignacionContext {
		public Token ID;
		public ExprContext expr;
		public TerminalNode ID() { return getToken(LiteracionesParser.ID, 0); }
		public TerminalNode ASIGNA() { return getToken(LiteracionesParser.ASIGNA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsignarContext(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterAsignar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitAsignar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitAsignar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_asignacion);
		try {
			_localctx = new AsignarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((AsignarContext)_localctx).ID = match(ID);
			setState(67);
			match(ASIGNA);
			setState(68);
			((AsignarContext)_localctx).expr = expr();
			 
			        if (!tablaSimbolos.containsKey((((AsignarContext)_localctx).ID!=null?((AsignarContext)_localctx).ID.getText():null))) {
			                listaErrores.add(ErrorText(((AsignarContext)_localctx).ID.getLine(), ((AsignarContext)_localctx).ID.getCharPositionInLine(), "la variable '" + (((AsignarContext)_localctx).ID!=null?((AsignarContext)_localctx).ID.getText():null) + "' no ha sido declarada."));
			        }
			        else {
			                    Simbolo S = new Simbolo(((AsignarContext)_localctx).expr.value);
			                    tablaSimbolos.put((((AsignarContext)_localctx).ID!=null?((AsignarContext)_localctx).ID.getText():null), S);
			        }

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImprimirContext extends ParserRuleContext {
		public ImprimirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imprimir; }
	 
		public ImprimirContext() { }
		public void copyFrom(ImprimirContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImpContext extends ImprimirContext {
		public Token PRINT;
		public ExprContext e;
		public TerminalNode PRINT() { return getToken(LiteracionesParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ImpContext(ImprimirContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterImp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitImp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitImp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImprimirContext imprimir() throws RecognitionException {
		ImprimirContext _localctx = new ImprimirContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_imprimir);
		try {
			_localctx = new ImpContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((ImpContext)_localctx).PRINT = match(PRINT);
			setState(72);
			((ImpContext)_localctx).e = expr();

			                if (((ImpContext)_localctx).e.value == null) {
			                    listaErrores.add(ErrorText(((ImpContext)_localctx).PRINT.getLine(), ((ImpContext)_localctx).PRINT.getCharPositionInLine(),
			                                               "No se puede imprimir un valor nulo"));
			                }
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionContext extends ParserRuleContext {
		public CondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion; }
	 
		public CondicionContext() { }
		public void copyFrom(CondicionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class If_elseContext extends CondicionContext {
		public Token IF;
		public ExprContext e;
		public TerminalNode IF() { return getToken(LiteracionesParser.IF, 0); }
		public List<TerminalNode> THEN() { return getTokens(LiteracionesParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(LiteracionesParser.THEN, i);
		}
		public List<SentenciasContext> sentencias() {
			return getRuleContexts(SentenciasContext.class);
		}
		public SentenciasContext sentencias(int i) {
			return getRuleContext(SentenciasContext.class,i);
		}
		public List<TerminalNode> FIN() { return getTokens(LiteracionesParser.FIN); }
		public TerminalNode FIN(int i) {
			return getToken(LiteracionesParser.FIN, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(LiteracionesParser.ELSE, 0); }
		public If_elseContext(CondicionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterIf_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitIf_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitIf_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionContext condicion() throws RecognitionException {
		CondicionContext _localctx = new CondicionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condicion);
		int _la;
		try {
			_localctx = new If_elseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((If_elseContext)_localctx).IF = match(IF);
			setState(76);
			((If_elseContext)_localctx).e = expr();
			setState(77);
			match(THEN);
			setState(78);
			sentencias();
			setState(79);
			match(FIN);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(80);
				match(ELSE);
				setState(81);
				match(THEN);
				setState(82);
				sentencias();
				setState(83);
				match(FIN);
				}
			}


			                if (!(((If_elseContext)_localctx).e.value instanceof Boolean)) {
			                    listaErrores.add(ErrorText(((If_elseContext)_localctx).IF.getLine(), ((If_elseContext)_localctx).IF.getCharPositionInLine(), 
			                                                "Condición no booleana en IF"));
			                }
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CicloContext extends ParserRuleContext {
		public CicloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclo; }
	 
		public CicloContext() { }
		public void copyFrom(CicloContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends CicloContext {
		public Token WHILE;
		public ExprContext e;
		public TerminalNode WHILE() { return getToken(LiteracionesParser.WHILE, 0); }
		public TerminalNode THEN() { return getToken(LiteracionesParser.THEN, 0); }
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public TerminalNode FIN() { return getToken(LiteracionesParser.FIN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhileContext(CicloContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloContext ciclo() throws RecognitionException {
		CicloContext _localctx = new CicloContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ciclo);
		try {
			_localctx = new WhileContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			((WhileContext)_localctx).WHILE = match(WHILE);
			setState(90);
			((WhileContext)_localctx).e = expr();
			setState(91);
			match(THEN);
			setState(92);
			sentencias();
			setState(93);
			match(FIN);

			            if (!(((WhileContext)_localctx).e.value instanceof Boolean)) {
			                listaErrores.add(ErrorText(((WhileContext)_localctx).WHILE.getLine(), ((WhileContext)_localctx).WHILE.getCharPositionInLine(),
			                                           "Condición no booleana en WHILE"));
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatContext extends ParserRuleContext {
		public RepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat; }
	 
		public RepeatContext() { }
		public void copyFrom(RepeatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class For_simpleContext extends RepeatContext {
		public TerminalNode FOR() { return getToken(LiteracionesParser.FOR, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public TerminalNode THEN() { return getToken(LiteracionesParser.THEN, 0); }
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public TerminalNode FIN() { return getToken(LiteracionesParser.FIN, 0); }
		public For_simpleContext(RepeatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterFor_simple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitFor_simple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitFor_simple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatContext repeat() throws RecognitionException {
		RepeatContext _localctx = new RepeatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_repeat);
		try {
			_localctx = new For_simpleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(FOR);
			setState(97);
			valor();
			setState(98);
			match(THEN);
			setState(99);
			sentencias();
			setState(100);
			match(FIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorContext extends ParserRuleContext {
		public Object value;
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
	 
		public ValorContext() { }
		public void copyFrom(ValorContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentContext extends ValorContext {
		public Token ID;
		public TerminalNode ID() { return getToken(LiteracionesParser.ID, 0); }
		public IdentContext(ValorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ValorContext {
		public Token NUMERO;
		public TerminalNode NUMERO() { return getToken(LiteracionesParser.NUMERO, 0); }
		public NumContext(ValorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valor);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERO:
				_localctx = new NumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((NumContext)_localctx).NUMERO = match(NUMERO);
				 ((NumContext)_localctx).value =  Integer.parseInt((((NumContext)_localctx).NUMERO!=null?((NumContext)_localctx).NUMERO.getText():null)); 
				}
				break;
			case ID:
				_localctx = new IdentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				((IdentContext)_localctx).ID = match(ID);

				          Simbolo s = tablaSimbolos.get((((IdentContext)_localctx).ID!=null?((IdentContext)_localctx).ID.getText():null));
				          if (s == null) {
				              listaErrores.add(
				                  ErrorText(((IdentContext)_localctx).ID.getLine(), ((IdentContext)_localctx).ID.getCharPositionInLine(), 
				                            "la variable '" + (((IdentContext)_localctx).ID!=null?((IdentContext)_localctx).ID.getText():null) + "' no ha sido declarada.")
				              );
				              ((IdentContext)_localctx).value =  null;
				          } else if (!s.getTipo().equals("Entero")) {
				              // La variable existe pero no es un entero
				              listaErrores.add(
				                  ErrorText(((IdentContext)_localctx).ID.getLine(), ((IdentContext)_localctx).ID.getCharPositionInLine(),
				                            "La variable '" + (((IdentContext)_localctx).ID!=null?((IdentContext)_localctx).ID.getText():null) + "' debe ser un número entero.")
				              );
				              ((IdentContext)_localctx).value =  null;
				          } else {
				              ((IdentContext)_localctx).value =  s.getValor(); // seguro que es Integer
				          }
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Object value;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ExprContext {
		public Expr_orContext expr_or;
		public Expr_orContext expr_or() {
			return getRuleContext(Expr_orContext.class,0);
		}
		public ExpresionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			_localctx = new ExpresionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((ExpresionContext)_localctx).expr_or = expr_or();
			 ((ExpresionContext)_localctx).value =  ((ExpresionContext)_localctx).expr_or.value; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_orContext extends ParserRuleContext {
		public Object value;
		public Expr_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_or; }
	 
		public Expr_orContext() { }
		public void copyFrom(Expr_orContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends Expr_orContext {
		public Expr_andContext a;
		public Token OR;
		public Expr_andContext b;
		public List<Expr_andContext> expr_and() {
			return getRuleContexts(Expr_andContext.class);
		}
		public Expr_andContext expr_and(int i) {
			return getRuleContext(Expr_andContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LiteracionesParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LiteracionesParser.OR, i);
		}
		public ExprOrContext(Expr_orContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_orContext expr_or() throws RecognitionException {
		Expr_orContext _localctx = new Expr_orContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr_or);
		try {
			int _alt;
			_localctx = new ExprOrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((ExprOrContext)_localctx).a = expr_and();
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(112);
					((ExprOrContext)_localctx).OR = match(OR);
					setState(113);
					((ExprOrContext)_localctx).b = expr_and();
					 
					        ((ExprOrContext)_localctx).a.value = evalOr(
					            wrap(((ExprOrContext)_localctx).a.value),
					            wrap(((ExprOrContext)_localctx).b.value),
					            listaErrores,
					            ((ExprOrContext)_localctx).OR.getLine(),
					            ((ExprOrContext)_localctx).OR.getCharPositionInLine()
					        );
					    
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			 ((ExprOrContext)_localctx).value =  ((ExprOrContext)_localctx).a.value; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_andContext extends ParserRuleContext {
		public Object value;
		public Expr_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_and; }
	 
		public Expr_andContext() { }
		public void copyFrom(Expr_andContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLogicaAndContext extends Expr_andContext {
		public Expr_compContext a;
		public Token AND;
		public Expr_compContext b;
		public List<Expr_compContext> expr_comp() {
			return getRuleContexts(Expr_compContext.class);
		}
		public Expr_compContext expr_comp(int i) {
			return getRuleContext(Expr_compContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LiteracionesParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LiteracionesParser.AND, i);
		}
		public ExprLogicaAndContext(Expr_andContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterExprLogicaAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitExprLogicaAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitExprLogicaAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_andContext expr_and() throws RecognitionException {
		Expr_andContext _localctx = new Expr_andContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr_and);
		try {
			int _alt;
			_localctx = new ExprLogicaAndContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			((ExprLogicaAndContext)_localctx).a = expr_comp();
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124);
					((ExprLogicaAndContext)_localctx).AND = match(AND);
					setState(125);
					((ExprLogicaAndContext)_localctx).b = expr_comp();

					        ((ExprLogicaAndContext)_localctx).a.value = evalAnd(
					            wrap(((ExprLogicaAndContext)_localctx).a.value),
					            wrap(((ExprLogicaAndContext)_localctx).b.value),
					            listaErrores,
					            ((ExprLogicaAndContext)_localctx).AND.getLine(),
					            ((ExprLogicaAndContext)_localctx).AND.getCharPositionInLine()
					        );
					    
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			 ((ExprLogicaAndContext)_localctx).value =  ((ExprLogicaAndContext)_localctx).a.value; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_compContext extends ParserRuleContext {
		public Object value;
		public Expr_compContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_comp; }
	 
		public Expr_compContext() { }
		public void copyFrom(Expr_compContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprComparacionContext extends Expr_compContext {
		public Expr_aritContext a;
		public Token op;
		public Expr_aritContext b;
		public List<Expr_aritContext> expr_arit() {
			return getRuleContexts(Expr_aritContext.class);
		}
		public Expr_aritContext expr_arit(int i) {
			return getRuleContext(Expr_aritContext.class,i);
		}
		public List<TerminalNode> IGUAL_QUE() { return getTokens(LiteracionesParser.IGUAL_QUE); }
		public TerminalNode IGUAL_QUE(int i) {
			return getToken(LiteracionesParser.IGUAL_QUE, i);
		}
		public List<TerminalNode> MAYOR() { return getTokens(LiteracionesParser.MAYOR); }
		public TerminalNode MAYOR(int i) {
			return getToken(LiteracionesParser.MAYOR, i);
		}
		public List<TerminalNode> MENOR() { return getTokens(LiteracionesParser.MENOR); }
		public TerminalNode MENOR(int i) {
			return getToken(LiteracionesParser.MENOR, i);
		}
		public ExprComparacionContext(Expr_compContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterExprComparacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitExprComparacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitExprComparacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_compContext expr_comp() throws RecognitionException {
		Expr_compContext _localctx = new Expr_compContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr_comp);
		int _la;
		try {
			int _alt;
			_localctx = new ExprComparacionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			((ExprComparacionContext)_localctx).a = expr_arit();
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(136);
					((ExprComparacionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
						((ExprComparacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(137);
					((ExprComparacionContext)_localctx).b = expr_arit();

					        ((ExprComparacionContext)_localctx).a.value = evalComp(
					            wrap(((ExprComparacionContext)_localctx).a.value),
					            (((ExprComparacionContext)_localctx).op!=null?((ExprComparacionContext)_localctx).op.getText():null),
					            wrap(((ExprComparacionContext)_localctx).b.value),
					            listaErrores,
					            ((ExprComparacionContext)_localctx).op.getLine(),
					            ((ExprComparacionContext)_localctx).op.getCharPositionInLine()
					        );
					    
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			 ((ExprComparacionContext)_localctx).value =  ((ExprComparacionContext)_localctx).a.value; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_aritContext extends ParserRuleContext {
		public Object value;
		public Expr_aritContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_arit; }
	 
		public Expr_aritContext() { }
		public void copyFrom(Expr_aritContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAritContext extends Expr_aritContext {
		public Expr_termContext a;
		public Token op;
		public Expr_termContext b;
		public List<Expr_termContext> expr_term() {
			return getRuleContexts(Expr_termContext.class);
		}
		public Expr_termContext expr_term(int i) {
			return getRuleContext(Expr_termContext.class,i);
		}
		public List<TerminalNode> SUMA() { return getTokens(LiteracionesParser.SUMA); }
		public TerminalNode SUMA(int i) {
			return getToken(LiteracionesParser.SUMA, i);
		}
		public List<TerminalNode> RESTA() { return getTokens(LiteracionesParser.RESTA); }
		public TerminalNode RESTA(int i) {
			return getToken(LiteracionesParser.RESTA, i);
		}
		public ExprAritContext(Expr_aritContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterExprArit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitExprArit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitExprArit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_aritContext expr_arit() throws RecognitionException {
		Expr_aritContext _localctx = new Expr_aritContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr_arit);
		int _la;
		try {
			int _alt;
			_localctx = new ExprAritContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			((ExprAritContext)_localctx).a = expr_term();
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(148);
					((ExprAritContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==SUMA || _la==RESTA) ) {
						((ExprAritContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(149);
					((ExprAritContext)_localctx).b = expr_term();

					        ((ExprAritContext)_localctx).a.value = evalArit(
					            wrap(((ExprAritContext)_localctx).a.value),
					            (((ExprAritContext)_localctx).op!=null?((ExprAritContext)_localctx).op.getText():null),
					            wrap(((ExprAritContext)_localctx).b.value),
					            listaErrores,
					            ((ExprAritContext)_localctx).op.getLine(),
					            ((ExprAritContext)_localctx).op.getCharPositionInLine()
					        );
					    
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			 ((ExprAritContext)_localctx).value =  ((ExprAritContext)_localctx).a.value; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_termContext extends ParserRuleContext {
		public Object value;
		public Expr_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_term; }
	 
		public Expr_termContext() { }
		public void copyFrom(Expr_termContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprTermContext extends Expr_termContext {
		public TermContext a;
		public Token op;
		public TermContext b;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(LiteracionesParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LiteracionesParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LiteracionesParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LiteracionesParser.DIV, i);
		}
		public ExprTermContext(Expr_termContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterExprTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitExprTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitExprTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_termContext expr_term() throws RecognitionException {
		Expr_termContext _localctx = new Expr_termContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr_term);
		int _la;
		try {
			int _alt;
			_localctx = new ExprTermContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			((ExprTermContext)_localctx).a = term();
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(160);
					((ExprTermContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==MULT || _la==DIV) ) {
						((ExprTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(161);
					((ExprTermContext)_localctx).b = term();

					        ((ExprTermContext)_localctx).a.value = evalArit(
					            wrap(((ExprTermContext)_localctx).a.value),
					            (((ExprTermContext)_localctx).op!=null?((ExprTermContext)_localctx).op.getText():null),
					            wrap(((ExprTermContext)_localctx).b.value),
					            listaErrores,
					            ((ExprTermContext)_localctx).op.getLine(),
					            ((ExprTermContext)_localctx).op.getCharPositionInLine()
					        );
					    
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			 ((ExprTermContext)_localctx).value =  ((ExprTermContext)_localctx).a.value; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public Object value;
		public String tipo;
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
			this.tipo = ctx.tipo;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AgrupContext extends TermContext {
		public ExprContext e;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AgrupContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterAgrup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitAgrup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitAgrup(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Bool_trueContext extends TermContext {
		public TerminalNode VERDADERO() { return getToken(LiteracionesParser.VERDADERO, 0); }
		public TerminalNode FALSO() { return getToken(LiteracionesParser.FALSO, 0); }
		public Bool_trueContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterBool_true(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitBool_true(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitBool_true(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CadContext extends TermContext {
		public Token CADENA;
		public TerminalNode CADENA() { return getToken(LiteracionesParser.CADENA, 0); }
		public CadContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterCad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitCad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitCad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegacionContext extends TermContext {
		public Token NOT;
		public ExprContext e;
		public TerminalNode NOT() { return getToken(LiteracionesParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegacionContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterNegacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitNegacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitNegacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnteroContext extends TermContext {
		public Token NUMERO;
		public TerminalNode NUMERO() { return getToken(LiteracionesParser.NUMERO, 0); }
		public EnteroContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterEntero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitEntero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitEntero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdeContext extends TermContext {
		public Token ID;
		public TerminalNode ID() { return getToken(LiteracionesParser.ID, 0); }
		public IdeContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterIde(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitIde(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitIde(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalContext extends TermContext {
		public Token NUMERO_DEC;
		public TerminalNode NUMERO_DEC() { return getToken(LiteracionesParser.NUMERO_DEC, 0); }
		public DecimalContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LiteracionesListener ) ((LiteracionesListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LiteracionesVisitor ) return ((LiteracionesVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_term);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new AgrupContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(T__0);
				setState(172);
				((AgrupContext)_localctx).e = expr();
				setState(173);
				match(T__1);
				 ((AgrupContext)_localctx).value =  ((AgrupContext)_localctx).e.value; 
				}
				break;
			case NOT:
				_localctx = new NegacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				((NegacionContext)_localctx).NOT = match(NOT);
				setState(177);
				((NegacionContext)_localctx).e = expr();
				 ((NegacionContext)_localctx).value =  evalNot(wrap(((NegacionContext)_localctx).e.value), listaErrores, ((NegacionContext)_localctx).NOT.getLine(), ((NegacionContext)_localctx).NOT.getCharPositionInLine()); 
				}
				break;
			case NUMERO:
				_localctx = new EnteroContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				((EnteroContext)_localctx).NUMERO = match(NUMERO);
				 ((EnteroContext)_localctx).value =  Integer.parseInt((((EnteroContext)_localctx).NUMERO!=null?((EnteroContext)_localctx).NUMERO.getText():null)); 
				}
				break;
			case NUMERO_DEC:
				_localctx = new DecimalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				((DecimalContext)_localctx).NUMERO_DEC = match(NUMERO_DEC);
				 ((DecimalContext)_localctx).value =  Double.parseDouble((((DecimalContext)_localctx).NUMERO_DEC!=null?((DecimalContext)_localctx).NUMERO_DEC.getText():null)); 
				}
				break;
			case CADENA:
				_localctx = new CadContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(184);
				((CadContext)_localctx).CADENA = match(CADENA);
				 ((CadContext)_localctx).value =  (((CadContext)_localctx).CADENA!=null?((CadContext)_localctx).CADENA.getText():null).substring(1, (((CadContext)_localctx).CADENA!=null?((CadContext)_localctx).CADENA.getText():null).length()-1); 
				}
				break;
			case VERDADERO:
				_localctx = new Bool_trueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
				match(VERDADERO);
				 ((Bool_trueContext)_localctx).value =  true; 
				}
				break;
			case FALSO:
				_localctx = new Bool_trueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				match(FALSO);
				 ((Bool_trueContext)_localctx).value =  false; 
				}
				break;
			case ID:
				_localctx = new IdeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				((IdeContext)_localctx).ID = match(ID);

				          Simbolo s = tablaSimbolos.get((((IdeContext)_localctx).ID!=null?((IdeContext)_localctx).ID.getText():null));
				          if (s == null) {
				              listaErrores.add(
				                  ErrorText(((IdeContext)_localctx).ID.getLine(), ((IdeContext)_localctx).ID.getCharPositionInLine(), 
				                                         "la variable '" + (((IdeContext)_localctx).ID!=null?((IdeContext)_localctx).ID.getText():null) + "' no ha sido declarada.")
				              );
				              ((IdeContext)_localctx).value =  null;
				          } else {
				              ((IdeContext)_localctx).value =  s.getValor();
				          }
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u00c3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001+\b\u0001"+
		"\n\u0001\f\u0001.\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003A\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tk\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bu\b\u000b\n\u000b\f\u000bx\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0081\b\f\n\f\f\f\u0084"+
		"\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u008d"+
		"\b\r\n\r\f\r\u0090\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0099\b\u000e\n\u000e\f\u000e\u009c"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00a5\b\u000f\n\u000f\f\u000f\u00a8\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00c1\b\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0003"+
		"\u0001\u0000\u0015\u0017\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0011"+
		"\u00c6\u0000\"\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000\u0000"+
		"\u00045\u0001\u0000\u0000\u0000\u0006@\u0001\u0000\u0000\u0000\bB\u0001"+
		"\u0000\u0000\u0000\nG\u0001\u0000\u0000\u0000\fK\u0001\u0000\u0000\u0000"+
		"\u000eY\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000\u0000\u0012j"+
		"\u0001\u0000\u0000\u0000\u0014l\u0001\u0000\u0000\u0000\u0016o\u0001\u0000"+
		"\u0000\u0000\u0018{\u0001\u0000\u0000\u0000\u001a\u0087\u0001\u0000\u0000"+
		"\u0000\u001c\u0093\u0001\u0000\u0000\u0000\u001e\u009f\u0001\u0000\u0000"+
		"\u0000 \u00c0\u0001\u0000\u0000\u0000\"#\u0005\u0003\u0000\u0000#$\u0003"+
		"\u0002\u0001\u0000$%\u0005\u0004\u0000\u0000%&\u0005\u0000\u0000\u0001"+
		"&\u0001\u0001\u0000\u0000\u0000\'(\u0003\u0004\u0002\u0000()\u0005\u001e"+
		"\u0000\u0000)+\u0001\u0000\u0000\u0000*\'\u0001\u0000\u0000\u0000+.\u0001"+
		"\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-\u0003\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/6\u0003\u0006"+
		"\u0003\u000006\u0003\b\u0004\u000016\u0003\n\u0005\u000026\u0003\f\u0006"+
		"\u000036\u0003\u000e\u0007\u000046\u0003\u0010\b\u00005/\u0001\u0000\u0000"+
		"\u000050\u0001\u0000\u0000\u000051\u0001\u0000\u0000\u000052\u0001\u0000"+
		"\u0000\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u00006\u0005"+
		"\u0001\u0000\u0000\u000078\u0005\r\u0000\u000089\u0005\u001d\u0000\u0000"+
		"9A\u0006\u0003\uffff\uffff\u0000:;\u0005\r\u0000\u0000;<\u0005\u001d\u0000"+
		"\u0000<=\u0005\f\u0000\u0000=>\u0003\u0014\n\u0000>?\u0006\u0003\uffff"+
		"\uffff\u0000?A\u0001\u0000\u0000\u0000@7\u0001\u0000\u0000\u0000@:\u0001"+
		"\u0000\u0000\u0000A\u0007\u0001\u0000\u0000\u0000BC\u0005\u001d\u0000"+
		"\u0000CD\u0005\f\u0000\u0000DE\u0003\u0014\n\u0000EF\u0006\u0004\uffff"+
		"\uffff\u0000F\t\u0001\u0000\u0000\u0000GH\u0005\u000b\u0000\u0000HI\u0003"+
		"\u0014\n\u0000IJ\u0006\u0005\uffff\uffff\u0000J\u000b\u0001\u0000\u0000"+
		"\u0000KL\u0005\u0005\u0000\u0000LM\u0003\u0014\n\u0000MN\u0005\b\u0000"+
		"\u0000NO\u0003\u0002\u0001\u0000OU\u0005\n\u0000\u0000PQ\u0005\u0006\u0000"+
		"\u0000QR\u0005\b\u0000\u0000RS\u0003\u0002\u0001\u0000ST\u0005\n\u0000"+
		"\u0000TV\u0001\u0000\u0000\u0000UP\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0006\u0006\uffff\uffff\u0000"+
		"X\r\u0001\u0000\u0000\u0000YZ\u0005\u0007\u0000\u0000Z[\u0003\u0014\n"+
		"\u0000[\\\u0005\b\u0000\u0000\\]\u0003\u0002\u0001\u0000]^\u0005\n\u0000"+
		"\u0000^_\u0006\u0007\uffff\uffff\u0000_\u000f\u0001\u0000\u0000\u0000"+
		"`a\u0005\t\u0000\u0000ab\u0003\u0012\t\u0000bc\u0005\b\u0000\u0000cd\u0003"+
		"\u0002\u0001\u0000de\u0005\n\u0000\u0000e\u0011\u0001\u0000\u0000\u0000"+
		"fg\u0005\u001c\u0000\u0000gk\u0006\t\uffff\uffff\u0000hi\u0005\u001d\u0000"+
		"\u0000ik\u0006\t\uffff\uffff\u0000jf\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000k\u0013\u0001\u0000\u0000\u0000lm\u0003\u0016\u000b\u0000"+
		"mn\u0006\n\uffff\uffff\u0000n\u0015\u0001\u0000\u0000\u0000ov\u0003\u0018"+
		"\f\u0000pq\u0005\u0013\u0000\u0000qr\u0003\u0018\f\u0000rs\u0006\u000b"+
		"\uffff\uffff\u0000su\u0001\u0000\u0000\u0000tp\u0001\u0000\u0000\u0000"+
		"ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wy\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000yz\u0006\u000b"+
		"\uffff\uffff\u0000z\u0017\u0001\u0000\u0000\u0000{\u0082\u0003\u001a\r"+
		"\u0000|}\u0005\u0012\u0000\u0000}~\u0003\u001a\r\u0000~\u007f\u0006\f"+
		"\uffff\uffff\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080|\u0001\u0000"+
		"\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000"+
		"\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0006\f\uffff"+
		"\uffff\u0000\u0086\u0019\u0001\u0000\u0000\u0000\u0087\u008e\u0003\u001c"+
		"\u000e\u0000\u0088\u0089\u0007\u0000\u0000\u0000\u0089\u008a\u0003\u001c"+
		"\u000e\u0000\u008a\u008b\u0006\r\uffff\uffff\u0000\u008b\u008d\u0001\u0000"+
		"\u0000\u0000\u008c\u0088\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000"+
		"\u0000\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0006\r\uffff\uffff\u0000\u0092\u001b\u0001\u0000"+
		"\u0000\u0000\u0093\u009a\u0003\u001e\u000f\u0000\u0094\u0095\u0007\u0001"+
		"\u0000\u0000\u0095\u0096\u0003\u001e\u000f\u0000\u0096\u0097\u0006\u000e"+
		"\uffff\uffff\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0094\u0001"+
		"\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0001"+
		"\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0006"+
		"\u000e\uffff\uffff\u0000\u009e\u001d\u0001\u0000\u0000\u0000\u009f\u00a6"+
		"\u0003 \u0010\u0000\u00a0\u00a1\u0007\u0002\u0000\u0000\u00a1\u00a2\u0003"+
		" \u0010\u0000\u00a2\u00a3\u0006\u000f\uffff\uffff\u0000\u00a3\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a0\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0006\u000f\uffff\uffff\u0000\u00aa\u001f"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0001\u0000\u0000\u00ac\u00ad"+
		"\u0003\u0014\n\u0000\u00ad\u00ae\u0005\u0002\u0000\u0000\u00ae\u00af\u0006"+
		"\u0010\uffff\uffff\u0000\u00af\u00c1\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005\u0014\u0000\u0000\u00b1\u00b2\u0003\u0014\n\u0000\u00b2\u00b3\u0006"+
		"\u0010\uffff\uffff\u0000\u00b3\u00c1\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0005\u001c\u0000\u0000\u00b5\u00c1\u0006\u0010\uffff\uffff\u0000\u00b6"+
		"\u00b7\u0005\u001b\u0000\u0000\u00b7\u00c1\u0006\u0010\uffff\uffff\u0000"+
		"\u00b8\u00b9\u0005\u001a\u0000\u0000\u00b9\u00c1\u0006\u0010\uffff\uffff"+
		"\u0000\u00ba\u00bb\u0005\u0018\u0000\u0000\u00bb\u00c1\u0006\u0010\uffff"+
		"\uffff\u0000\u00bc\u00bd\u0005\u0019\u0000\u0000\u00bd\u00c1\u0006\u0010"+
		"\uffff\uffff\u0000\u00be\u00bf\u0005\u001d\u0000\u0000\u00bf\u00c1\u0006"+
		"\u0010\uffff\uffff\u0000\u00c0\u00ab\u0001\u0000\u0000\u0000\u00c0\u00b0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00b4\u0001\u0000\u0000\u0000\u00c0\u00b6"+
		"\u0001\u0000\u0000\u0000\u00c0\u00b8\u0001\u0000\u0000\u0000\u00c0\u00ba"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c0\u00be"+
		"\u0001\u0000\u0000\u0000\u00c1!\u0001\u0000\u0000\u0000\u000b,5@Ujv\u0082"+
		"\u008e\u009a\u00a6\u00c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}