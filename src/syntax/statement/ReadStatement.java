package syntax.statement;

import syntax.expression.Expr;
import syntax.expression.Id;
import visitor.Visitor;

import java.util.ArrayList;

public class ReadStatement extends Statement {

    private ArrayList<Id> variables;
    private Expr expr;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param variables
     * @param expr
     */
    public ReadStatement(int leftPosition, int rightPosition, ArrayList<Id> variables, Expr expr) {
        super(leftPosition, rightPosition);
        this.variables = variables;
        this.expr=expr;
    }

    public ReadStatement (int leftPosition, int rightPosition){
        super(leftPosition, rightPosition);
    }

    /**
     * @return the variables
     */
    public ArrayList<Id> getVariables() {
        return variables;
    }

    /**
     * @return Expr
     */
    public Expr getExpr() {
        return expr;
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
