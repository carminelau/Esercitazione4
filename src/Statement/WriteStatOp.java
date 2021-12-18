package Statement;

import Operation.ExprListOp;
import Visitor.Visitor;
import Visitor.XmlGenerator;

public class WriteStatOp extends Statement{
    private ExprListOp exprList;
    public WriteStatOp(ExprListOp exprList) {
        this.exprList = exprList;
    }

    @Override
    public String toString() {
        return "WriteStatOp{" +
                "exprList=" + exprList +
                '}';
    }

    public ExprListOp getExprList() {
        return exprList;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
