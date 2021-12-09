package syntax.statement;

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
}
