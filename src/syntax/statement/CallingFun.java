package syntax.statement;

import syntax.expression.Expr;
import syntax.expression.Id;
import visitor.Visitor;

import java.util.ArrayList;

public class CallingFun extends Expr {
    private Id id;
    private ArrayList<Expr> exprs;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param id id
     * @param exprs  expressions list
     */
    public CallingFun(int leftPosition, int rightPosition, Id id, ArrayList<Expr> exprs) {
        super(leftPosition, rightPosition);
        this.id = id;
        this.exprs = exprs;
    }

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param id id
     */
    public CallingFun(int leftPosition, int rightPosition, Id id) {
        super(leftPosition, rightPosition);
        this.id = id;
    }

    /**
     * @return the id
     */
    public Id getId() {
        return id;
    }

    /**
     * @return the expression list
     */
    public ArrayList<Expr> getExprs() {
        return exprs;
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