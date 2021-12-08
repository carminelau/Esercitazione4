package syntax.expression;

import visitor.Visitor;

import java.util.ArrayList;

public class FunctionParam extends Expr {
    private Expr expr;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param expr          the expression
     */
    public FunctionParam(int leftPosition, int rightPosition, Expr expr) {
        super(leftPosition, rightPosition);
        this.expr = expr;
    }

    /**
     * @return the expression list
     */
    public Expr getExpr() {
        return this.expr;
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
