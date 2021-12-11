package syntax.statement;

import syntax.VarDecl;
import visitor.Visitor;

import java.util.ArrayList;

public class ElseStatement extends Statement {

    private ArrayList<VarDecl> varDecllist;
    private ArrayList<Statement> statementList;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param varDecllist
     * @param statementList
     */
    public ElseStatement(int leftPosition, int rightPosition, ArrayList<VarDecl> varDecllist, ArrayList<Statement> statementList){
        super(leftPosition, rightPosition);
        this.statementList = statementList;
        this.varDecllist = varDecllist;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }

    public ArrayList<VarDecl> getVarDecllist() {
        return varDecllist;
    }

    public ArrayList<Statement> getStatementList() {
        return statementList;
    }
}
