package Statement;

import Operation.ExprOp;
import Visitor.Visitor;
import Visitor.XmlGenerator;

public class ElifOp  {
    private ExprOp e;
    private StatListOp list;
    public ElifOp(ExprOp e, StatListOp list) {
        this.e = e;
        this.list = list;
    }

    public ExprOp getE() {
        return e;
    }

    public StatListOp getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ElifOp{" +
                e +
                "," + list +
                '}';
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
