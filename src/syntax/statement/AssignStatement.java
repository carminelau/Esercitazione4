package syntax.statement;

import syntax.expression.Expr;
import syntax.expression.Id;
import visitor.Visitor;

public class AssignStatement extends Statement {
    private Id id;
    private Expr expression;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param id
     * @param expression
     */
    public AssignStatement(int leftPosition, int rightPosition, Id id, Expr expression) {
        super(leftPosition, rightPosition);
        this.id = id;
        this.expression = expression;
    }

    public AssignStatement (int leftPosition, int rightPosition){
        super(leftPosition, rightPosition);
    }

    /**
     * @return
     */
    public Id getId() {
        return id;
    }

    /**
     * @return
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
