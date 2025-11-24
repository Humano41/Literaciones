
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
    import com.ittepic.literaciones.Custom.Instruction3DC;
    import com.ittepic.literaciones.Custom.CodeGenerator;
}

// Insertar codigo en la parte de atributos del lexer
@lexer::members {
    public List<String> listaErrores = new ArrayList<>();
}
    
    // Insertar codigo en la parte de atributos del parser
@parser::members {
    public Map<String, Simbolo> tablaSimbolos = new HashMap<>();
    public List<String> listaErrores = new ArrayList<>();
    public CodeGenerator codeGen = CodeGenerator.getInstance(); // Instancia del gestor
    }
    
    
    // --------- REGLAS DEL PARSER (estructura) ---------
    programa : INICIO sentencias FINAL EOF ;

sentencias : (sentencia FINSENTENCIA)*;

sentencia :     
        declaracion         #declara
    |   asignacion          #asig
    |   imprimir            #show
    |   condicion           #cond
    |   ciclo               #cic
    |   repeat              #rep
    ;

// REGLAS CON GENERACIÓN DE CÓDIGO INTERMEDIO (3DC)
declaracion : 
         DECLARA ID { 
                 if (tablaSimbolos.containsKey($ID.text)) {
                     listaErrores.add(ErrorText($ID.getLine(), $ID.getCharPositionInLine(), "la variable '" + $ID.text + "' ya fue declarada."));
                 } else {
                     // Solo registrar la declaración
                     tablaSimbolos.put($ID.text, null); 
                 }
         }#crear 
    | DECLARA ID ASIGNA expr   { 
        if (tablaSimbolos.containsKey($ID.text)) {
            listaErrores.add(ErrorText($ID.getLine(), $ID.getCharPositionInLine(), "la variable '" + $ID.text + "' ya fue declarada."));
        } else {
            // Generar la instrucción 3DC de ASIGNACIÓN
            // ID = Temporal_de_la_expresion
            codeGen.emit(new Instruction3DC(
                "ASSIGN", 
                $ID.text,         // Resultado: ID
                $expr.tempName    // Operando1: Temporal/ID del valor
            ));
            Simbolo S = new Simbolo($expr.value);
            tablaSimbolos.put($ID.text, S);
        }
    } #crea_asigna
    ;

asignacion : ID ASIGNA expr { 
    if (!tablaSimbolos.containsKey($ID.text)) {
        listaErrores.add(ErrorText($ID.getLine(), $ID.getCharPositionInLine(), "la variable '" + $ID.text + "' no ha sido declarada."));
    } else {
        // Generar la instrucción 3DC de ASIGNACIÓN
        codeGen.emit(new Instruction3DC(
            "ASSIGN", 
            $ID.text,         
            $expr.tempName    
        ));
        // La actualización de la Tabla de Símbolos es opcional.
        Simbolo S = new Simbolo($expr.value);
        tablaSimbolos.put($ID.text, S);
    }
} #asignar
    ;

imprimir : PRINT e=expr {
    // Generar la instrucción 3DC de IMPRIMIR
    codeGen.emit(new Instruction3DC(
        "PRINT", 
        $e.tempName // Lo que se imprime es el valor del temporal/ID
    ));
} #imp
;

/**
 * Regla para la estructura de control IF-THEN [ELSE-THEN].
 * Genera código 3DC utilizando etiquetas (LABEL) y saltos condicionales (IF_GOTO).
 */
// Declarar los atributos/variables locales L_cuerpo_then, L_fin, y L_target_if_false
condicion
    :   IF e=expr THEN 
        {
            CodeGenerator cg = CodeGenerator.getInstance();

            // Etiquetas para IF sin ELSE
            String L_then = cg.newLabel();
            String L_end = cg.newLabel();

            // IF cond GOTO THEN
            cg.emit(new Instruction3DC("IF_GOTO", null, $e.tempName, L_then));

            // Falso → salta a FIN
            cg.emit(new Instruction3DC("GOTO", L_end));

            // THEN
            cg.emit(new Instruction3DC("LABEL", L_then, null));
        }
        sentencias
        FIN
        {
            cg.emit(new Instruction3DC("LABEL", L_end, null));
        }
        #if_sin_else
    |

        // ------------------------------------------
        // IF con ELSE
        // ------------------------------------------
        IF e=expr THEN 
        {
            CodeGenerator cg = CodeGenerator.getInstance();

            String L_then = cg.newLabel();
            String L_else = cg.newLabel();
            String L_end  = cg.newLabel();

            // IF cond GOTO THEN
            cg.emit(new Instruction3DC("IF_GOTO", null, $e.tempName, L_then));

            // FALSO → ELSE
            cg.emit(new Instruction3DC("GOTO", L_else));

            // THEN
            cg.emit(new Instruction3DC("LABEL", L_then, null));
        }
        sentencias
        FIN{
            cg.emit(new Instruction3DC("GOTO", L_end));
        }
        ELSE THEN
        {
            cg.emit(new Instruction3DC("LABEL", L_else, null));
        }
        sentencias
        FIN
        {
            cg.emit(new Instruction3DC("LABEL", L_end, null));
        }
        #if_con_else
    ;

/**
 * Regla para el ciclo WHILE.
 * Genera código 3DC para lazo utilizando etiquetas y saltos para la reevaluación.
 */
ciclo returns [String L_inicio, String L_fin]
    : WHILE e=expr THEN
        {
            // 1. DECLARACIÓN E INICIALIZACIÓN ÚNICA de cg (CodeGenerator cg = ...)
            CodeGenerator cg = CodeGenerator.getInstance();
            
            // 2. Crear etiquetas. (Ahora son atributos de retorno $L_inicio y $L_fin)
            $L_inicio = cg.newLabel();
            String L_cuerpo = cg.newLabel(); 
            $L_fin = cg.newLabel();
            
            // 3. 1️⃣ Etiqueta de inicio del bucle (L0:)
            cg.emit(new Instruction3DC("LABEL", $L_inicio, null));
            
            // 4. 2️⃣ IF $e.tempName GOTO L_cuerpo (L1)
            cg.emit(new Instruction3DC("IF_GOTO", null, $e.tempName, L_cuerpo));

            // 5. 3️⃣ Salto al fin si es FALSO (GOTO L2)
            cg.emit(new Instruction3DC("GOTO", $L_fin));

            // 6. 4️⃣ Etiqueta de inicio del cuerpo (L1:)
            cg.emit(new Instruction3DC("LABEL", L_cuerpo, null));
        }
        sentencias // <-- Cuerpo del ciclo
        FIN
        {
            
            // --- [B] DESPUÉS DEL CUERPO ---
            // 8. 6️⃣ GOTO L_inicio (Volver a evaluar la condición)
            cg.emit(new Instruction3DC("GOTO", $L_inicio)); 
            
            // 9. 7️⃣ Etiqueta de fin del bucle (L2:)
            cg.emit(new Instruction3DC("LABEL", $L_fin, null));
        }
    #while
;

      
repeat : FOR valor THEN sentencias FIN    #for_simple
    ;

valor returns [String tempName, Object value]: // Devuelve el nombre del temporal/ID
    // Caso de valor numérico
    NUMERO     { 
         $tempName = codeGen.newTemp();
         // Asigna el valor del número a un nuevo temporal
         codeGen.emit(new Instruction3DC("ASSIGN", $tempName, $NUMERO.text));
    }  #num
    // Caso de ID
    | ID {
          Simbolo s = tablaSimbolos.get($ID.text);
          if (s == null) {
              // Error semántico: ID no declarado
              listaErrores.add(
                  ErrorText($ID.getLine(), $ID.getCharPositionInLine(), 
                            "la variable '" + $ID.text + "' no ha sido declarada.")
              );
              $tempName = $ID.text; // Usar ID para no romper el 3DC
          }  else if (!s.getTipo().equals("Entero")) {
              // La variable existe pero no es un entero
              listaErrores.add(
                  ErrorText($ID.getLine(), $ID.getCharPositionInLine(),
                            "La variable '" + $ID.text + "' debe ser un número entero.")
              );
              $value = null;
          } else {
              // El temporal es el nombre del ID (acceso directo a la variable)
              $value = s.getValor(); // seguro que es Integer
              $tempName = $ID.text; 
          }
      } #ident
    ;

// ===========================================
//  EXPRESIONES PRINCIPALES
// ===========================================
// Retornamos DOS cosas: el nombre temporal (String) y el valor real (Object)
expr returns [String tempName, Object value] 
    : expr_or { 
        $tempName = $expr_or.tempName; 
        $value = $expr_or.value; 
    } #expresion
    ;

expr_or returns [String tempName, Object value] 
    : a=expr_and { $tempName = $a.tempName; $value = $a.value; }
    ( OR b=expr_and {
        // 1. Lógica 3DC
        String nextTemp = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("OR", nextTemp, $tempName, $b.tempName));
        $tempName = nextTemp;

        // 2. Lógica de Valor (Semántica)
        $value = evalOr(wrap($value), wrap($b.value), listaErrores, $OR.getLine(), $OR.getCharPositionInLine());
    })*
    #exprOr
    ;

expr_and returns [String tempName, Object value] 
    : a=expr_comp { $tempName = $a.tempName; $value = $a.value; }
    (AND b=expr_comp {
        // 1. Lógica 3DC
        String nextTemp = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("AND", nextTemp, $tempName, $b.tempName));
        $tempName = nextTemp;

        // 2. Lógica de Valor
        $value = evalAnd(wrap($value), wrap($b.value), listaErrores, $AND.getLine(), $AND.getCharPositionInLine());
    })*
    #exprLogicaAnd
    ;

expr_comp returns [String tempName, Object value] 
    : a=expr_arit { $tempName = $a.tempName; $value = $a.value; }
    (op=(IGUAL_QUE | MAYOR | MENOR) b=expr_arit {
        // 1. Lógica 3DC
        String nextTemp = codeGen.newTemp();
        // Mapeo manual simple para el nombre de la op
        String opName = ($op.getType() == MAYOR) ? "MAYOR" : ($op.getType() == MENOR) ? "MENOR" : "IGUAL_QUE";
        codeGen.emit(new Instruction3DC(opName, nextTemp, $tempName, $b.tempName));
        $tempName = nextTemp;

        // 2. Lógica de Valor
        $value = evalComp(wrap($value), $op.text, wrap($b.value), listaErrores, $op.getLine(), $op.getCharPositionInLine());
    })*
    #exprComparacion
    ;

expr_arit returns [String tempName, Object value]
    : a=expr_term { $tempName = $a.tempName; $value = $a.value; }
    ( op=(SUMA | RESTA) b=expr_term {
        // 1. Lógica 3DC
        String nextTemp = codeGen.newTemp();
        String opName = ($op.getType() == SUMA) ? "SUMA" : "RESTA";
        codeGen.emit(new Instruction3DC(opName, nextTemp, $tempName, $b.tempName));
        $tempName = nextTemp;

        // 2. Lógica de Valor
        $value = evalArit(wrap($value), $op.text, wrap($b.value), listaErrores, $op.getLine(), $op.getCharPositionInLine());
    })*
    #exprArit
    ;

expr_term returns [String tempName, Object value] 
    : a=term { $tempName = $a.tempName; $value = $a.value; }
    (op=(MULT | DIV) b=term {
        // 1. Lógica 3DC
        String nextTemp = codeGen.newTemp();
        String opName = ($op.getType() == MULT) ? "MULT" : "DIV";
        codeGen.emit(new Instruction3DC(opName, nextTemp, $tempName, $b.tempName));
        $tempName = nextTemp;

        // 2. Lógica de Valor
        $value = evalArit(wrap($value), $op.text, wrap($b.value), listaErrores, $op.getLine(), $op.getCharPositionInLine());
    })*
    #exprTerm
    ;

// ===========================================
//  TERMINALES (HOJAS DEL ÁRBOL)
// ===========================================

term returns [String tempName, Object value] 
    // 1. Agrupación
    : '(' e=expr ')' { 
        $tempName = $e.tempName; 
        $value = $e.value; 
    } #agrup
    
    // 2. Negación Lógica
    | NOT e=expr { 
        // 3DC
        String nextTemp = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("NOT", nextTemp, $e.tempName));
        $tempName = nextTemp;
        
        // Valor
        $value = evalNot(wrap($e.value), listaErrores, $NOT.getLine(), $NOT.getCharPositionInLine());
    } #negacion
    
    // 3. Enteros
    | NUMERO { 
        // 3DC
        $tempName = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("ASSIGN", $tempName, $NUMERO.text));
        
        // Valor
        $value = Integer.parseInt($NUMERO.text);
    } #entero
    
    // 4. Decimales
    | NUMERO_DEC { 
        // 3DC
        $tempName = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("ASSIGN", $tempName, $NUMERO_DEC.text));
        
        // Valor
        $value = Double.parseDouble($NUMERO_DEC.text);
    } #decimal
    
    // 5. Cadenas
    | CADENA { 
        // 3DC
        $tempName = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("ASSIGN", $tempName, $CADENA.text));
        
        // Valor (Quitamos comillas)
        $value = $CADENA.text.substring(1, $CADENA.text.length()-1);
    } #cad
    
    // 6. Booleanos
    | VERDADERO { 
        $tempName = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("ASSIGN", $tempName, "true"));
        $value = true;
    } #bool_true
    | FALSO { 
        $tempName = codeGen.newTemp();
        codeGen.emit(new Instruction3DC("ASSIGN", $tempName, "false"));
        $value = false;
    } #bool_false
    
    // 7. Identificadores (VARIABLES)
    | ID {
          Simbolo s = tablaSimbolos.get($ID.text);
          if (s == null) {
              listaErrores.add(ErrorText($ID.getLine(), $ID.getCharPositionInLine(), "la variable '" + $ID.text + "' no ha sido declarada."));
              $value = null; // Error semántico
          } else {
              $value = s.getValor(); // Obtenemos el valor real para cálculos
          }
          
          // Para 3DC, usamos el nombre de la variable tal cual
          $tempName = $ID.text; 
      } #ide
    ;



// --------- TOKENS DEL LENGUAJE ---------

INICIO      : 'INICIO' | 'COMIENZO' | 'PROLOGO' | 'APERTURA' ;
FINAL       : 'FINAL'  | 'EPILOGO' | 'CIERRE' ;

IF          : 'SI' | 'CONDICION' | 'CUMPLE' | 'REQUISITO' ;
ELSE        : 'SINO' | 'CAMBIO' | 'FALLA' ;
WHILE       : 'MIENTRAS' | 'HASTA' ;
THEN        : 'ENTONCES' | 'HACER' ;     // ❗ YA NO SE MEZCLA CON '('
FOR         : 'REPETIR' | 'CICLO' | 'BUCLE' ;
FIN         : 'FIN' ;                    // ❗ YA NO SE MEZCLA CON ')'

// Paréntesis como tokens independientes
LPAREN      : '(' ;
RPAREN      : ')' ;

PRINT       : 'MOSTRAR' | 'MUESTRA' | 'ENSEÑA' | 'DICE' | 'DECIR' | 'IMPRIME' | 'IMPRIMIR' ;

ASIGNA      : 'IGUAL' | 'VALOR' | 'ASIGNA' | 'ASIGNAR' | 'DE' | 'COMO' | 'OBTIENE' 
              | 'TOMA' | 'ADOPTA' | 'VUELVE' | 'TRANSFORMA' | 'ES' | '=' ;

DECLARA     : 'DECLARA' | 'DECLARAR' | 'CREA' | 'CREAR' | 'EXISTE' | 'NACE' | 'SURGE' 
              | 'INTRODUCE' | 'PRESENTA' ;

SUMA        : 'SUMA'| 'MAS' | 'AÑADE' | 'JUNTA' | '+' ;
RESTA       : 'RESTA' | 'QUITA' | 'REDUCE' | 'MENOS' | '-' ;
MULT        : 'MULTIPLICA' | 'POR' | 'CRECE' | '*' ;
DIV         : 'ENTRE' | 'REPARTE' | 'SEPARA' | '/' ;

AND         : 'Y' | 'ADEMAS' | 'TAMBIEN' | '$' ;
OR          : 'O' | ',' | '|' ;
NOT         : 'NO' | 'NEGAR' | '!' ;

IGUAL_QUE   : 'COINCIDE' | 'EQUIVALE' | 'MISMO' | 'IGUAL_QUE' | '==' ;
MAYOR       : 'MAYOR' | 'SOBREPASA' | 'ARRIBA' | 'SUPERIOR' | '>' ;
MENOR       : 'MENOR' | 'INFERIOR' | 'DEBAJO' | '<' ;

VERDADERO   : 'VERDADERO' | 'CIERTO' | 'REAL' | 'POSIBLE' ;
FALSO       : 'FALSO' | 'IMPOSIBLE' | 'IRREAL' ;

CADENA      : '"' (~["\r\n])* '"' ;
NUMERO_DEC  : [0-9]+ '.' [0-9]+ ;
NUMERO      : [0-9]+ ;

ID : [A-ZÁÉÍÓÚÑ][a-záéíóúñA-Z0-9ÁÉÍÓÚÑ_]* ;

FINSENTENCIA : '.' ;

// ------------ IGNORAR ESPACIOS, COMENTARIOS Y PALABRAS VACÍAS ------------

WS              : [ \t\r\n]+ -> skip ;
COMPLEMENTO     : [a-z]+ -> skip;
LINE_COMMENT    : '//' ~[\r\n]* -> channel(HIDDEN);
BLOCK_COMMENT   : '/*' .*? '*/' -> channel(HIDDEN);

// Palabras que no aportan al lenguaje narrativo
PALABRA_VACIA : ('un' | 'el' | 'la' | 'los' | 'las' | 'de' | 'a' | 'en' | 'con'
               | 'por' | 'que' | 'es' | 'llamado' | 'numero' | 'heroe'
               | 'valiente' | 'llamada') -> skip ;

// Manejo de error léxico
ERROR : . {
    listaErrores.add("Error lexico: caracter inválido '" 
                     + getText() + "' en linea " + getLine() + ":" + getCharPositionInLine());
};
