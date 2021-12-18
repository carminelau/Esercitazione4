package Statement;
import Operation.*;
import Visitor.Visitor;

public class AssignStatOp extends Statement {
    private IdListOp idList;
    private ExprListOp exprList;
    private static final String operation = ":=";

    public AssignStatOp(IdListOp idList, ExprListOp exprList) {
        this.idList = idList;
        this.exprList = exprList;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }


    public IdListOp getIdList() {
        return idList;
    }

    public ExprListOp getExprList() {
        return exprList;
    }

    public static String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "Assign{" +
                "idList=" + idList +
                ", exprList=" + exprList +
                '}';
    }
}
