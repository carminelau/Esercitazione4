package syntax.expression.constant;

import syntax.Leaf;
import syntax.expression.Expr;
import visitor.Visitor;

public class RealConst extends Expr implements Leaf<Float> {
    private float value;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param value the value
     */
    public RealConst(int leftPosition, int rightPosition, String value) {
        super(leftPosition, rightPosition);
        this.value = Float.parseFloat(value);
    }


    /**
     * @return the value
     */
    @Override
    public Float getValue() {
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