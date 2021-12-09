package syntax.statement;

import syntax.expression.Expr;
import visitor.Visitor;

import java.util.ArrayList;

public class IfStat extends Stat{

    private Expr condition;
    private ArrayList<VarDecl> varDecllist;
    private ArrayList<Stat> StatList;
    private ElseStat else_Stat_;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param condition
     * @param varDecllist
     * @param StatList
     * @param else_Stat_
     */
    public IfStat(int leftPosition, int rightPosition, Expr condition,ArrayList<VarDecl> varDecllist,ArrayList<Stat> StatList, ElseStat else_Stat_) {
        super(leftPosition, rightPosition);
        this.condition = condition;
        this.varDecllist = varDecllist;
        this.StatList = StatList;
        this.else_Stat_ = else_Stat_;
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
    public ArrayList<Stat> getThenStatement() {
        return StatList;
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
    public ElseStat getElse_() {
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
