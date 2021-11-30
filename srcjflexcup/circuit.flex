import java.io.*;import java.util.HashMap;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;import jdk.incubator.foreign.SymbolLookup;
%%
%class Lexer
%cup
%standalone
%line
%column
%unicode
%init{
// inserimento delle parole chiavi nella stringTable per evitare di scrivere un diagramma di transizione per ciascuna di esse (le parole chiavi verranno "catturate" dal diagramma di transizione e gestite e di conseguenza).
    stringTable.put("if", new Symbol(Token.IF,"IF"));
    stringTable.put("then", new Symbol(Token.THEN,"THEN"));
    stringTable.put("else", new Symbol(Token.ELSE,"ELSE"));
    stringTable.put("while", new Symbol(Token.WHILE,"WHILE"));
    stringTable.put("integer", new Symbol(Token.INTEGER,"INTEGER"));
    stringTable.put("real", new Symbol(Token.REAL,"REAL"));
    stringTable.put("bool", new Symbol(Token.BOOL,"BOOL"));
    stringTable.put("fun", new Symbol(Token.FUN,"FUN"));
    stringTable.put("do", new Symbol(Token.LOOP,"LOOP"));
    stringTable.put("and", new Symbol(Token.AND,"AND"));
    stringTable.put("or", new Symbol(Token.OR,"OR"));
    stringTable.put("not", new Symbol(Token.NOT,"NOT"));
    stringTable.put("true", new Symbol(Token.TRUE,"TRUE"));
    stringTable.put("false", new Symbol(Token.FALSE,"FALSE"));
    stringTable.put("null", new Symbol(Token.NULL,"NULL"));
    stringTable.put("return", new Symbol(Token.RETURN,"RETURN"));
    stringTable.put("div", new Symbol(Token.DIVINT,"DIVINT"));
    stringTable.put("end", new Symbol(Token.END,"END"));
    stringTable.put("main", new Symbol(Token.MAIN,"MAIN"));
    stringTable.put("string", new Symbol(Token.STRING,"STRING"));
%init}

%{
StringBuffer string = new StringBuffer();
  public Symbol Symbol( int tokenType ) {
      System.err.println( "Obtain token " + Token.terminal_name( tokenType ) );
      return new Symbol( tokenType, yyline, yycolumn);
  }

  public Symbol Symbol( int tokenType, Object value ) {
      System.err.println( "Obtain token " +value + " \"" + yytext() + "\"" );
        return new Symbol( tokenType, yyline, yycolumn, value);
    }
    private static HashMap<String, Symbol> stringTable= new HashMap<>();

    private Symbol installID(String lex){
        Symbol sym;

        if(stringTable.containsKey(lex)){
            System.out.println( "Obtain token " + Token.terminal_name( stringTable.get(lex).sym ) + " \"" + lex + "\"" );
            return stringTable.get(lex);
        }
        else{
            sym = new Symbol(Token.ID,lex);
            System.out.println( "Obtain token " + "ID" + " \"" + lex + "\"" );
            stringTable.put(lex,sym);
            return sym;
        }
    }
%}

//WhiteSpaces
InputChar = [^\n\r]
LineTerminator = \n|\r|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

//Comment
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment   = "#" [^*] ~{LineTerminator}
EndOfLineComment     = "//" {InputChar} * {LineTerminator}?
DocumentationComment = "#" {CommentContent}
CommentContent       = ( [^*] | \*+ [^#] )*

//Numbers
Zero = 0
DecInt = [1-9][0-9]*
INTEGER_CONST = ( {Zero} | {DecInt} )
Exponent = [E] [\+\-]? [0-9]+
Float1 = [\+\-]? [0-9]+ \. [0-9]+ {Exponent}?
Float2 = [\+\-]? [0-9]+ {Exponent}
REAL_CONST = ( {Float1} | {Float2} )

//Identifiers
Ident = [$_@A-Za-z] [$_@A-Za-z0-9]*

//String
String = {StringWithDoubleApex} | {StringWithApex}
StringWithDoubleApex = [^".*"$]
StringWithApex = [^'.*'$]
%%

    //KEYWORDS
    if { return installID(yytext()); }
    then { return installID(yytext()); }
    else { return installID(yytext()); }
    while { return installID(yytext()); }
    integer {return installID(yytext());}
    real {return installID(yytext());}
    bool {return installID(yytext());}
    fun {return installID(yytext());}
    do {return installID(yytext());}
    and {return installID(yytext());}
    or {return installID(yytext());}
    not {return installID(yytext());}
    true {return installID(yytext());}
    false {return installID(yytext());}
    null {return installID(yytext());}
    return {return installID(yytext());}
    div {return installID(yytext());}
    end {return installID(yytext());}
    main {return installID(yytext());}
    string {return installID(yytest());}

    //NUMBER
    {INTEGER_CONST} { return Symbol(Token.INTEGER_CONST, yytext()); }
    {REAL_CONST} { return Symbol(Token.REAL_CONST, yytext()); }

    //SYMBOL
    "(" { return Symbol(Token.LPAR, "LPAR"); }
    ")" { return Symbol(Token.RPAR, "RPAR"); }
    "," { return Symbol(Token.COMMA, "COMMA"); }
    ";" { return Symbol(Token.SEMI, "SEMI"); }
    ":" { return Symbol(Token.COLON, "COLON"); }
    "%" { return Symbol(Token.READ, "READ"); }
    "?" { return Symbol(Token.WRITE, "WRITE"); }
    "?." { return Symbol(Token.WRITELN, "WRITELN"); }
    "?," { return Symbol(Token.WRITEB, "WRITEB"); }
    "?:" { return Symbol(Token.WRITET, "WRITET"); }

    //RELOP
    "<" { return Symbol(Token.LT, "LT"); }
    "=" { return Symbol(Token.EQ, "EQ"); }
    ">" { return Symbol(Token.GT, "GT"); }
    "<=" { return Symbol(Token.LE, "LE"); }
    "<>" { return Symbol(Token.NE, "NE"); }
    "!=" { return Symbol(Token.NE, "NE"); }
    "<-" { return Symbol(Token.ASSIGN, "ASSIGN"); }
    ">=" { return Symbol(Token.GE, "GE"); }

    //OPERATIONS
    "+" { return Symbol(Token.PLUS, "PLUS"); }
    "-" { return Symbol(Token.MINUS, "MINUS"); }
    "*" { return Symbol(Token.TIMES, "TIMES"); }
    "/" { return Symbol(Token.DIV, "DIV"); }
    "^" { return Symbol(Token.POW,"POW"); }
    "&" { return Symbol(Token.STR_CONCAT,"STR_CONCAT"); }

    //IDENTIFIERS
    {Ident} { return installID(yytext()); }

    //WHITESPACE
    "//"{InputChar}* { }
    {WhiteSpace} { }

    //ERRORS
    <<EOF>> { return Symbol(Token.EOF); }
    . { return Symbol(Token.ERROR, "ERROR"); }