package syntax;

import syntax.expression.Id;
import syntax.statement.Statement;
import syntax.types.Type;
import visitor.Visitor;

import java.util.ArrayList;

public class Fun extends ASTNode {
    private Type type;
    private Id id;
    private ArrayList<Statement> statements;
    private ArrayList<VarDecl> vardecllist;
    private ArrayList<ParDecl> paramdecllist;

    /**
     * Initialize a new Function with params.
     *
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param id the id
     * @param type the type
     * @param paramdecllist the pardecl
     * @param vardecllist
     * @param statements list of statement
     */
    public Fun(int leftPosition, int rightPosition, Id id, ArrayList<ParDecl> paramdecllist, Type type, ArrayList<VarDecl> vardecllist, ArrayList<Statement> statements) {
        super(leftPosition, rightPosition);
        this.type = type;
        this.id = id;
        this.statements = statements;
        this.vardecllist=vardecllist;
        this.paramdecllist = paramdecllist;
    }

    /**
     * Initialize a new Function without params.
     *
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param id the id
     * @param paramdecllist the type
     * @param vardecllist
     * @param statements list of statement
     */
    public Fun(int leftPosition, int rightPosition,  Id id, ArrayList<ParDecl> paramdecllist, ArrayList<VarDecl> vardecllist, ArrayList<Statement> statements) {
        super(leftPosition, rightPosition);
        this.vardecllist=vardecllist;
        this.id = id;
        this.statements = statements;
        this.paramdecllist = paramdecllist;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @return the id
     */
    public Id getId() {
        return id;
    }

    /**
     * @return the statement list
     */
    public ArrayList<Statement> getStatements() {
        return statements;
    }

    /**
     * @return the parDecl
     */
    public ArrayList<ParDecl> getParDeclList() {
        return paramdecllist;
    }
    /**
     * @return the vardecllist
     */
    public ArrayList<VarDecl> getVarDeclList() {
        return vardecllist;
    }


    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }

}
