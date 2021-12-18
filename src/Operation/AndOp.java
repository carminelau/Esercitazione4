package Operation;

import Visitor.Visitor;

public class AndOp extends Operation {

    private static final String operation = "&&";

    public AndOp(ExprOp e1, ExprOp e2) {
        super(e1,e2);
    }



    @Override
    public String toString() {
        return "AndOp{" +
                "e1=" + super.getE1() +
                ", e2=" + super.getE2() +
                '}';
    }
}
