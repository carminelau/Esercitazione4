package Statement;

import Visitor.Visitor;
import Visitor.XmlGenerator;

public class ReadlnStatOp extends Statement{

    private IdListOp idList;

    public ReadlnStatOp(IdListOp list) {
        this.idList = list;
    }

    @Override
    public String toString() {
        return "ReadlnStatOp{" +
                "idList=" + idList +
                '}';
    }

    public IdListOp getIdList() {
        return idList;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
