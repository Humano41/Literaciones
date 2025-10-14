
grammar Literaciones;


// Agregamos los paquetes necesarios para la tabla de simbolos al parser   
@header {
    package com.ittepic.literaciones;
    
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;  
    import static com.ittepic.literaciones.Custom.HelperParser.*;
    import com.ittepic.literaciones.Custom.Simbolo;
}

// Insertar codigo en la parte de atributos del lexer
@lexer::members {
    public List<String> listaErrores = new ArrayList<>();
}
    
    // Insertar codigo en la parte de atributos del parser
@parser::members {
    public Map<String, Simbolo> tablaSimbolos = new HashMap<>();
    public List<String> listaErrores = new ArrayList<>();
    }
    
    
    // --------- REGLAS DEL PARSER (estructura) ---------
    programa : INICIO sentencias FINAL EOF ;

sentencias : (sentencia FINSENTENCIA)*;

sentencia :     declaracion         #declara
    |   asignacion          #asig
    |   imprimir            #show
    |   condicion           #cond
    |   ciclo               #cic
    |   repeat              #rep
    ;

// REGLAS CORREGIDAS Y LIMPIAS
declaracion : 
        DECLARA ID { 
                if (tablaSimbolos.containsKey($ID.text)) {
                    listaErrores.add(ErrorText($ID.getLine(), $ID.getCharPositionInLine(), "la variable '" + $ID.text + "' ya fue declarada."));
                } else {
                    tablaSimbolos.put($ID.text, null); 
                }
    }#crear 
        | DECLARA ID ASIGNA expr   { 
        if (tablaSimbolos.containsKey($ID.text)) {
            listaErrores.add(ErrorText($ID.getLine(), $ID.getCharPositionInLine(), "la variable '" + $ID.text + "' ya fue declarada."));
        } 
        else {
                    Simbolo S = new Simbolo($expr.value);
                    tablaSimbolos.put($ID.text, S);
        }
    } #crea_asigna
    ;

asignacion : ID ASIGNA expr { 
        if (!tablaSimbolos.containsKey($ID.text)) {
                listaErrores.add(ErrorText($ID.getLine(), $ID.getCharPositionInLine(), "la variable '" + $ID.text + "' no ha sido declarada."));
        }
        else {
                    Simbolo S = new Simbolo($expr.value);
                    tablaSimbolos.put($ID.text, S);
        }
} #asignar
    ;

imprimir : PRINT e=expr {
                if ($e.value == null) {
                    listaErrores.add(ErrorText($PRINT.getLine(), $PRINT.getCharPositionInLine(),
                                               "No se puede imprimir un valor nulo"));
                }
            } #imp
;


condicion : IF e=expr THEN sentencias FIN (ELSE THEN sentencias FIN)? {
                if (!($e.value instanceof Boolean)) {
                    listaErrores.add(ErrorText($IF.getLine(), $IF.getCharPositionInLine(), 
                                                "Condición no booleana en IF"));
                }
            } #if_else
;

ciclo : WHILE e=expr THEN sentencias FIN {
            if (!($e.value instanceof Boolean)) {
                listaErrores.add(ErrorText($WHILE.getLine(), $WHILE.getCharPositionInLine(),
                                           "Condición no booleana en WHILE"));
            }
        } #while
;

      
repeat : FOR valor THEN sentencias FIN   #for_simple
    ;

valor returns [Object value]:
    NUMERO    { $value = Integer.parseInt($NUMERO.text); }  #num
    | ID {
          Simbolo s = tablaSimbolos.get($ID.text);
          if (s == null) {
              listaErrores.add(
                  ErrorText($ID.getLine(), $ID.getCharPositionInLine(), 
                            "la variable '" + $ID.text + "' no ha sido declarada.")
              );
              $value = null;
          } else if (!s.getTipo().equals("Entero")) {
              // La variable existe pero no es un entero
              listaErrores.add(
                  ErrorText($ID.getLine(), $ID.getCharPositionInLine(),
                            "La variable '" + $ID.text + "' debe ser un número entero.")
              );
              $value = null;
          } else {
              $value = s.getValor(); // seguro que es Integer
          }
      } #ident
    ;

// ===========================================
//  EXPRESIONES PRINCIPALES
// ===========================================
expr returns [Object value]
    : expr_or { $value = $expr_or.value; } #expresion
    ;

// ===========================================
//  OPERADORES LÓGICOS
// ===========================================
expr_or returns [Object value]
    : a=expr_and (OR b=expr_and { 
        $a.value = evalOr(
            wrap($a.value),
            wrap($b.value),
            listaErrores,
            $OR.getLine(),
            $OR.getCharPositionInLine()
        );
    })*
    { $value = $a.value; } #exprOr
    ;

expr_and returns [Object value]
    : a=expr_comp (AND b=expr_comp {
        $a.value = evalAnd(
            wrap($a.value),
            wrap($b.value),
            listaErrores,
            $AND.getLine(),
            $AND.getCharPositionInLine()
        );
    })*
    { $value = $a.value; } #exprLogicaAnd
    ;

// ===========================================
//  COMPARACIONES
// ===========================================
expr_comp returns [Object value]
    : a=expr_arit (op=(IGUAL_QUE | MAYOR | MENOR) b=expr_arit {
        $a.value = evalComp(
            wrap($a.value),
            $op.text,
            wrap($b.value),
            listaErrores,
            $op.getLine(),
            $op.getCharPositionInLine()
        );
    })*
    { $value = $a.value; } #exprComparacion
    ;

// ===========================================
//  ARITMÉTICAS
// ===========================================
expr_arit returns [Object value]
    : a=expr_term (op=(SUMA | RESTA) b=expr_term {
        $a.value = evalArit(
            wrap($a.value),
            $op.text,
            wrap($b.value),
            listaErrores,
            $op.getLine(),
            $op.getCharPositionInLine()
        );
    })*
    { $value = $a.value; } #exprArit
    ;

// ===========================================
//  MULTIPLICACIÓN / DIVISIÓN
// ===========================================
expr_term returns [Object value]
    : a=term (op=(MULT | DIV) b=term {
        $a.value = evalArit(
            wrap($a.value),
            $op.text,
            wrap($b.value),
            listaErrores,
            $op.getLine(),
            $op.getCharPositionInLine()
        );
    })*
    { $value = $a.value; } #exprTerm
    ;

// ===========================================
//  FACTORES
// ===========================================
term returns [Object value, String tipo]
    : '(' e=expr ')'              { $value = $e.value; }                                           #agrup
    | NOT e=expr                  { $value = evalNot(wrap($e.value), listaErrores, $NOT.getLine(), $NOT.getCharPositionInLine()); }  #negacion
    | NUMERO                      { $value = Integer.parseInt($NUMERO.text); }      #entero
    | NUMERO_DEC                  { $value = Double.parseDouble($NUMERO_DEC.text); }  #decimal
    | CADENA                      { $value = $CADENA.text.substring(1, $CADENA.text.length()-1); } #cad
    | VERDADERO                   { $value = true; }                                   #bool_true
    | FALSO                       { $value = false; }                                  #bool_true
    | ID {
          Simbolo s = tablaSimbolos.get($ID.text);
          if (s == null) {
              listaErrores.add(
                  ErrorText($ID.getLine(), $ID.getCharPositionInLine(), 
                                         "la variable '" + $ID.text + "' no ha sido declarada.")
              );
              $value = null;
          } else {
              $value = s.getValor();
          }
      } #ide
    ;


// --------- REGLAS DEL LÉXICO (tokens básicos) ---------
// (El resto de tu archivo es correcto, lo incluyo para que tengas todo completo)
INICIO      : 'INICIO' | 'COMIENZO' | 'PROLOGO' | 'APERTURA' ;
FINAL       : 'FINAL'  | 'EPILOGO' | 'CIERRE' ;

IF          : 'SI'     | 'CONDICION' | 'CUMPLE' | 'REQUISITO' ;
ELSE        : 'SINO'   | 'CAMBIO' | 'FALLA' ;
WHILE       : 'MIENTRAS' | 'HASTA' ;
THEN        : '(' | 'HACER' | 'ENTONCES' ;
FOR         : 'REPETIR' | 'CICLO' | 'BUCLE' ;
FIN         : ')' | 'FIN' ;

PRINT       : 'MOSTRAR' | 'MUESTRA' | 'ENSEÑA' | 'DICE' | 'DECIR' | 'IMPRIME' | 'IMPRIMIR' ;
ASIGNA      : 'IGUAL' | 'VALOR' | 'ASIGNA' | 'ASIGNAR' | 'DE' | 'COMO' | 'OBTIENE' | 'TOMA' | 'ADOPTA' | 'VUELVE' | 'TRANSFORMA' | 'ES' | '=' ;
DECLARA     : 'DECLARA' | 'DECLARAR' | 'CREA' | 'CREAR' | 'EXISTE' | 'NACE' | 'SURGE' | 'INTRODUCE' | 'PRESENTA' ;

SUMA        : 'SUMA'| 'MAS' | 'AÑADE' | 'JUNTA' | '+';
RESTA       : 'RESTA' | 'QUITA' | 'REDUCE' | 'MENOS' | '-';
MULT        : 'MULTIPLICA' | 'POR' | 'CRECE' | '*' ;
DIV         : 'ENTRE' | 'REPARTE' | 'SEPARA' | '/';

AND         : 'Y' | 'ADEMAS' | 'TAMBIEN' | '$' ;
OR          : 'O' | ',' | '|';
NOT         : 'NO' | 'NEGAR' | '!' ;

IGUAL_QUE   : 'COINCIDE' | 'EQUIVALE' | 'MISMO' | 'IGUAL_QUE' | '==' ;
MAYOR       : 'MAYOR' | 'SOBREPASA' | 'ARRIBA' | 'SUPERIOR' | '>';
MENOR       : 'MENOR' | 'INFERIOR' | 'DEBAJO' | '<';

VERDADERO   : 'VERDADERO' | 'CIERTO' | 'REAL' | 'POSIBLE' ;
FALSO       : 'FALSO' | 'IMPOSIBLE' | 'IRREAL' ;

CADENA : '"' (~["\r\n])* '"' ;
NUMERO_DEC : [0-9]+ '.' [0-9]+ ;
NUMERO : [0-9]+ ;
ID : [A-ZÁÉÍÓÚÑ][a-záéíóúñA-Z0-9ÁÉÍÓÚÑ]* ;

FINSENTENCIA : '.';

COMPLEMENTO : [a-z]+ -> skip;
WS  : [ \t\r\n]+ -> skip ;
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
PALABRA_VACIA : ('un' | 'el' | 'la' | 'los' | 'las' | 'de' | 'a' | 'en' | 'con' | 'por' | 'que' | 'es' | 'llamado' | 'numero' | 'heroe' | 'valiente' | 'llamada') -> skip ;

ERROR : . {
    listaErrores.add("Error lexico: caracter inválido '" + getText() + "' en linea " + getLine() + ":" + getCharPositionInLine());
};
