package Operation;

public class NotOp extends Operation.Operations {

    private static final String operation = "!";

    public NotOp(ExprOp e) {
        super(e);
    }

    @Override
    public String toString() {
        return "NotOp{" +
                "e=" + super.getE1() +
                '}';
    }
}
