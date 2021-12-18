package Operation;

public class UminusOp extends Operation.Operations {

    private static final String operation = "-";

    public UminusOp(ExprOp e) {
        super(e);
    }

    @Override
    public String toString() {
        return "UminusOp{" +
                "e=" + super.getE1() +
                '}';
    }
}
