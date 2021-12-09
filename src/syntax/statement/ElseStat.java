package syntax.statement;

import syntax.expression.Expr;

import java.util.ArrayList;

public class ElseStat extends Stat{

    private ArrayList<VarDecl> varDecllist;
    private ArrayList<Stat> StatList;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param varDecllist
     * @param StatList
     */
    public ElseStat (int leftPosition, int rightPosition, ArrayList<VarDecl> varDecllist, ArrayList<Stat> StatList){
        super(leftPosition, rightPosition);
        this.StatList=StatList;
        this.varDecllist = varDecllist;
    }
}
