public class Token {

    public static final int IF = 0;
    public static final int THEN = 1;
    public static final int ELSE = 2;
    public static final int WHILE = 3;
    public static final int INTEGER = 4;
    public static final int REAL = 5;
    public static final int BOOL = 6;
    public static final int FUN = 7;
    public static final int LOOP = 8;
    public static final int AND = 9;
    public static final int OR = 10;
    public static final int NOT = 11;
    public static final int TRUE = 12;
    public static final int FALSE = 13;
    public static final int NULL = 14;
    public static final int RETURN = 15;
    public static final int DIVINT = 16;
    public static final int END = 17;
    public static final int MAIN = 18;
    public static final int STRING = 19;
    public static final int INTEGER_CONST = 20;
    public static final int REAL_CONST = 21;
    public static final int LPAR = 22;
    public static final int RPAR = 23;
    public static final int COMMA = 24;
    public static final int SEMI = 25;
    public static final int COLON = 26;
    public static final int READ = 27;
    public static final int WRITE = 28;
    public static final int WRITELN = 29;
    public static final int WRITEB = 30;
    public static final int WRITET = 31;
    public static final int LT = 32;
    public static final int EQ = 33;
    public static final int GT = 34;
    public static final int LE = 35;
    public static final int GE = 36;
    public static final int NE = 37;
    public static final int ASSIGN = 38;
    public static final int PLUS = 39;
    public static final int MINUS = 40;
    public static final int TIMES = 41;
    public static final int DIV = 42;
    public static final int POW = 43;
    public static final int STR_CONCAT = 44;
    public static final int ID = 45;
    public static final int EOF = 46;
    public static final int ERROR = 47;

    public static String terminal_name(int tok_type) {
        switch (tok_type) {
            case 0:
                return "IF";
            case 1:
                return "THEN";
            case 2:
                return "ELSE";
            case 3:
                return "WHILE";
            case 4:
                return "INTEGER";
            case 5:
                return "REAL";
            case 6:
                return "BOOL";
            case 7:
                return "FUN";
            case 8:
                return "LOOP";
            case 9:
                return "AND";
            case 10:
                return "OR";
            case 11:
                return "NOT";
            case 12:
                return "TRUE";
            case 13:
                return "FALSE";
            case 14:
                return "NULL";
            case 15:
                return "RETURN";
            case 16:
                return "DIVINT";
            case 17:
                return "END";
            case 18:
                return "MAIN";
            case 19:
                return "STRING";
            case 20:
                return "INTEGER_CONST";
            case 21:
                return "REAL_CONST";
            case 22:
                return "LPAR";
            case 23:
                return "RPAR";
            case 24:
                return "COMMA";
            case 25:
                return "SEMI";
            case 26:
                return "COLON";
            case 27:
                return "READ";
            case 28:
                return "WRITE";
            case 29:
                return "WRITELN";
            case 30:
                return "WRITEB";
            case 31:
                return "WRITET";
            case 32:
                return "LT";
            case 33:
                return "EQ";
            case 34:
                return "GT";
            case 35:
                return "LE";
            case 36:
                return "GE";
            case 37:
                return "NE";
            case 38:
                return "ASSIGN";
            case 39:
                return "PLUS";
            case 40:
                return "MINUS";
            case 41:
                return "TIMES";
            case 42:
                return "DIV";
            case 43:
                return "POW";
            case 44:
                return "STR_CONCAT";
            case 45:
                return "ID";
            case 46:
                return "EOF";
            case 47:
                return "ERROR";
            default:
                throw new java.lang.IllegalStateException("Unexpected value: " + tok_type);
        }
    }

}
