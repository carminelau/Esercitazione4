package syntax.expression.constant;

import syntax.Leaf;
import syntax.expression.Expr;
import visitor.Visitor;

public class IntegerConst extends Expr implements Leaf<Integer> {
    private int value;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param value the value
     */
    public IntegerConst(int leftPosition, int rightPosition, String value) {
        super(leftPosition, rightPosition);
        this.value = Integer.parseInt(value);
    }


    /**
     * @return the value
     */
    @Override
    public Integer getValue() {
        return value;
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
