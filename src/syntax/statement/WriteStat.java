package syntax.statement;

import syntax.expression.Expr;
import visitor.Visitor;

public class WriteStat extends Stat {

    private Expr expression;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param expression
     */
    public WriteStat(int leftPosition, int rightPosition, Expr expression) {
        super(leftPosition, rightPosition);
        this.expression = expression;
    }

    /**
     * @return the expressions list
     */
    public Expr getExpression() {
        return expression;
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
