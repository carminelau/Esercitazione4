package Node;

public class ResultTypeOp {
    private TypeOp t;
    public ResultTypeOp(TypeOp t) {
        this.t = t;
    }

    public TypeOp getT() {
        return t;
    }

    @Override
    public String toString() {
        return "ResultTypeOp{" +
                "t=" + t +
                '}';
    }
}
