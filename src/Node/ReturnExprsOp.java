package Node;

import Operation.ExprListOp;
import Visitor.Visitor;
import Visitor.XmlGenerator;

public class ReturnExprsOp {
    private ExprListOp list;

    public ReturnExprsOp(ExprListOp list) {
        this.list = list;
    }

    public ExprListOp getList() {
        return list;
    }

    @Override
    public String toString() {
        return  list.toString();
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
