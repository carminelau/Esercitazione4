package syntax.statement;

import syntax.expression.Expr;
import visitor.Visitor;

import java.util.ArrayList;

public class IfStatement extends Statement {

    private Expr condition;
    private ArrayList<VarDecl> varDecllist;
    private ArrayList<Statement> statementList;
    private ElseStatement else_Stat_;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param condition
     * @param varDecllist
     * @param statementList
     * @param else_Stat_
     */
    public IfStatement(int leftPosition, int rightPosition, Expr condition, ArrayList<VarDecl> varDecllist, ArrayList<Statement> statementList, ElseStatement else_Stat_) {
        super(leftPosition, rightPosition);
        this.condition = condition;
        this.varDecllist = varDecllist;
        this.statementList = statementList;
        this.else_Stat_ = else_Stat_;
    }

    public IfStatement (int leftPosition, int rightPosition){
        super(leftPosition, rightPosition);
    }

    /**
     * @return
     */
    public Expr getCondition() {
        return condition;
    }

    /**
     * @return
     */
    public ArrayList<Statement> getThenStatement() {
        return statementList;
    }

    /**
     * @return
     */
    public ArrayList<VarDecl> getVarDeclList() {
        return varDecllist;
    }

    /**
     * @return
     */
    public ElseStatement getElse_() {
        return else_Stat_;
    }

    /**
     * Implement interface method
     * @param visitor the visitor
     * @param arg argoment
     * @param <T> Visitor param T
     * @param <P> Visitor param P
     * @return the visited element
     */
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
