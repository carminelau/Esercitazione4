package generated;
import java.io.*;import java.util.HashMap;
import java_cup.runtime.Symbol;
%%
%class Lexer
%cupsym ParserSym
%public
%cup
%line
%column
%unicode
%state STRING
%state STRINGSINGLE

%init{
// inserimento delle parole chiavi nella stringTable per evitare di scrivere un diagramma di transizione per ciascuna di esse (le parole chiavi verranno "catturate" dal diagramma di transizione e gestite e di conseguenza).
    stringTable.put("IF", new Symbol(ParserSym.IF,"IF"));
    stringTable.put("THEN", new Symbol(ParserSym.THEN,"THEN"));
    stringTable.put("ELSE", new Symbol(ParserSym.ELSE,"ELSE"));
    stringTable.put("WHILE", new Symbol(ParserSym.WHILE,"WHILE"));
    stringTable.put("INTEGER", new Symbol(ParserSym.INTEGER,"INTEGER"));
    stringTable.put("REAL", new Symbol(ParserSym.REAL,"REAL"));
    stringTable.put("BOOL", new Symbol(ParserSym.BOOL,"BOOL"));
    stringTable.put("FUN", new Symbol(ParserSym.FUN,"FUN"));
    stringTable.put("LOOP", new Symbol(ParserSym.LOOP,"LOOP"));
    stringTable.put("AND", new Symbol(ParserSym.AND,"AND"));
    stringTable.put("OR", new Symbol(ParserSym.OR,"OR"));
    stringTable.put("NOT", new Symbol(ParserSym.NOT,"NOT"));
    stringTable.put("TRUE", new Symbol(ParserSym.TRUE,"TRUE"));
    stringTable.put("FALSE", new Symbol(ParserSym.FALSE,"FALSE"));
    stringTable.put("NULL", new Symbol(ParserSym.NULL,"NULL"));
    stringTable.put("RETURN", new Symbol(ParserSym.RETURN,"RETURN"));
    stringTable.put("END", new Symbol(ParserSym.END,"END"));
    stringTable.put("MAIN", new Symbol(ParserSym.MAIN,"MAIN"));
    stringTable.put("STRING", new Symbol(ParserSym.STRING,"STRING"));
    stringTable.put("OUTPAR", new Symbol(ParserSym.OUTPAR,"OUTPAR"));
    stringTable.put("VAR", new Symbol(ParserSym.VAR,"VAR"));
    stringTable.put("OUT", new Symbol(ParserSym.OUT,"OUT"));
%init}

%{
StringBuffer string = new StringBuffer();
  public Symbol Symbol( int tokenType ) {
      System.err.println( "Obtain token " + ParserSym.terminalNames[tokenType] );
      return new Symbol( tokenType, yyline, yycolumn);
  }

  public Symbol Symbol( int tokenType, Object value ) {
      System.err.println( "Obtain token " +ParserSym.terminalNames[tokenType] + " \"" + value + "\"" );
        return new Symbol( tokenType, yyline, yycolumn, value);
    }
    private static HashMap<String, Symbol> stringTable= new HashMap<>();

    private Symbol installID(String lex){
        Symbol sym;

        if(stringTable.containsKey(lex)){
            System.err.println( "Obtain token " + ParserSym.terminalNames[stringTable.get(lex).sym] + " \"" + lex + "\"" );
            return stringTable.get(lex);
        }
        else{
            sym = new Symbol(ParserSym.ID,lex);
            System.err.println( "Obtain token " + "ID" + " \"" + lex + "\"" );
            stringTable.put(lex,sym);
            return sym;
        }
    }

    public boolean initialize(String filePath) {
            try {
                /* the input device */
                this.zzReader = new java.io.FileReader(filePath);
                return true;
            } catch (java.io.FileNotFoundException e) {
                return false;
            }
        }
    public  Lexer() {
        stringTable.put("IF", new Symbol(ParserSym.IF,"IF"));
        stringTable.put("THEN", new Symbol(ParserSym.THEN,"THEN"));
        stringTable.put("ELSE", new Symbol(ParserSym.ELSE,"ELSE"));
        stringTable.put("WHILE", new Symbol(ParserSym.WHILE,"WHILE"));
        stringTable.put("INTEGER", new Symbol(ParserSym.INTEGER,"INTEGER"));
        stringTable.put("REAL", new Symbol(ParserSym.REAL,"REAL"));
        stringTable.put("BOOL", new Symbol(ParserSym.BOOL,"BOOL"));
        stringTable.put("FUN", new Symbol(ParserSym.FUN,"FUN"));
        stringTable.put("LOOP", new Symbol(ParserSym.LOOP,"LOOP"));
        stringTable.put("AND", new Symbol(ParserSym.AND,"AND"));
        stringTable.put("OR", new Symbol(ParserSym.OR,"OR"));
        stringTable.put("NOT", new Symbol(ParserSym.NOT,"NOT"));
        stringTable.put("TRUE", new Symbol(ParserSym.TRUE,"TRUE"));
        stringTable.put("FALSE", new Symbol(ParserSym.FALSE,"FALSE"));
        stringTable.put("NULL", new Symbol(ParserSym.NULL,"NULL"));
        stringTable.put("RETURN", new Symbol(ParserSym.RETURN,"RETURN"));
        stringTable.put("END", new Symbol(ParserSym.END,"END"));
        stringTable.put("MAIN", new Symbol(ParserSym.MAIN,"MAIN"));
        stringTable.put("STRING", new Symbol(ParserSym.STRING,"STRING"));
        stringTable.put("OUTPAR", new Symbol(ParserSym.OUTPAR,"OUTPAR"));
        stringTable.put("VAR", new Symbol(ParserSym.VAR,"VAR"));
        stringTable.put("OUT", new Symbol(ParserSym.OUT,"OUT"));
    }
%}

%eofval{
	return Symbol(ParserSym.EOF);
%eofval}

//WhiteSpaces
InputChar = [^\n\r]
LineTerminator = \n|\r|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

//Comment
//Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
//TraditionalComment   = "#" [^*] ~{LineTerminator}
//EndOfLineComment     = "//" {InputChar} * {LineTerminator}?
//DocumentationComment = "#" {CommentContent}
//CommentContent       = ( [^*] | \*+ [^#] )*

//Numbers
Zero = 0
DecInt = [1-9][0-9]*
INTEGER_CONST = ( {Zero} | {DecInt} )
Exponent = [E] [\+\-]? [0-9]+
Float1 = [\+\-]? [0-9]+ \. [0-9]+ {Exponent}?
Float2 = [\+\-]? [0-9]+ {Exponent}
REAL_CONST = ( {Float1} | {Float2} )

//Identifiers
Ident = [$_A-Za-z][$_A-Za-z0-9]*

//String
//String = {StringWithDoubleApex} | {StringWithApex}
//StringWithDoubleApex = [\\\^\\\".*\\\"\\\$]
//StringWithApex = [^\\\'.*'\$]

/*Declares a lexical state STRING */

%%

/*If the scanner is in lexical state STRING, only
  expressions that are preceded by the start condition <STRING> can be matched*/
<STRING> {
  \" {
    yybegin(YYINITIAL);
    return Symbol(ParserSym.STRING_CONST, string.toString());
  }
  [^\n\r\"\\] + { string.append( yytext() ); }
  \\t { string.append('\t'); }
  \\n { string.append('\n'); }
  \\r { string.append('\r'); }
  \\\" { string.append('\"'); }
  \\  { string.append('\\'); }
}

<STRINGSINGLE> {
  \' {
    yybegin(YYINITIAL);
    return Symbol(ParserSym.STRING_CONST, string.toString());
  }
  [^\n\r\'\\] + { string.append( yytext() ); }
  \\t { string.append('\t'); }
  \\n { string.append('\n'); }
  \\r { string.append('\r'); }
  \\\' { string.append('\''); }
  \\  { string.append('\\'); }
}

<YYINITIAL> {

    //KEYWORDS
    IF { return installID(yytext()); }
    THEN { return installID(yytext()); }
    ELSE { return installID(yytext()); }
    WHILE { return installID(yytext()); }
    INTEGER {return installID(yytext());}
    REAL {return installID(yytext());}
    BOOL {return installID(yytext());}
    FUN {return installID(yytext());}
    LOOP {return installID(yytext());}
    AND {return installID(yytext());}
    OR {return installID(yytext());}
    NOT {return installID(yytext());}
    TRUE {return installID(yytext());}
    FALSE {return installID(yytext());}
    NULL {return installID(yytext());}
    RETURN {return installID(yytext());}
    END {return installID(yytext());}
    MAIN {return installID(yytext());}
    STRING {return installID(yytext());}
    VAR {return installID(yytext());}
    OUT {return installID(yytext());}
    OUTPAR {return installID(yytext());}

    //NUMBER
    {INTEGER_CONST} { return Symbol(ParserSym.INTEGER_CONST, yytext()); }
    {REAL_CONST} { return Symbol(ParserSym.REAL_CONST, yytext()); }

    \" { string.setLength(0); yybegin(STRING); }

    \' { string.setLength(0); yybegin(STRINGSINGLE); }
    //SYMBOL
    "(" { return Symbol(ParserSym.LPAR, "LPAR"); }
    ")" { return Symbol(ParserSym.RPAR, "RPAR"); }
    "," { return Symbol(ParserSym.COMMA, "COMMA"); }
    ";" { return Symbol(ParserSym.SEMI, "SEMI"); }
    ":" { return Symbol(ParserSym.COLON, "COLON"); }
    "%" { return Symbol(ParserSym.READ, "READ"); }
    "?" { return Symbol(ParserSym.WRITE, "WRITE"); }
    "?." { return Symbol(ParserSym.WRITELN, "WRITELN"); }
    "?," { return Symbol(ParserSym.WRITEB, "WRITEB"); }
    "?:" { return Symbol(ParserSym.WRITET, "WRITET"); }

    //RELOP
    "<" { return Symbol(ParserSym.LT, "LT"); }
    "=" { return Symbol(ParserSym.EQ, "EQ"); }
    ">" { return Symbol(ParserSym.GT, "GT"); }
    "<=" { return Symbol(ParserSym.LE, "LE"); }
    "<>" { return Symbol(ParserSym.NE, "NE"); }
    "!=" { return Symbol(ParserSym.NE, "NE"); }
    ":=" { return Symbol(ParserSym.ASSIGN, "ASSIGN"); }
    ">=" { return Symbol(ParserSym.GE, "GE"); }

    //OPERATIONS
    "+" { return Symbol(ParserSym.PLUS, "PLUS"); }
    "-" { return Symbol(ParserSym.MINUS, "MINUS"); }
    "*" { return Symbol(ParserSym.TIMES, "TIMES"); }
    "/" { return Symbol(ParserSym.DIV, "DIV"); }
    "^" { return Symbol(ParserSym.POW,"POW"); }
    "&" { return Symbol(ParserSym.STR_CONCAT,"STR_CONCAT"); }
    "@" { return Symbol(ParserSym.OUTPAR,"OUTPAR"); }
    "div" {return Symbol(ParserSym.DIVINT,"DIVINT");}

    //WHITESPACE
    "//"{InputChar}* { }
    {WhiteSpace} { }

    //{String} {return installID(yytext()); }

    //IDENTIFIERS
    {Ident} { return installID(yytext()); }

    //ERRORS
    <<EOF>> { return Symbol(ParserSym.EOF); }
    . { return Symbol(ParserSym.ERROR, "ERROR"); }

    }

