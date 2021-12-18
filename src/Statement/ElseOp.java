package Statement;

import Visitor.Visitor;
import Visitor.XmlGenerator;

public class ElseOp {
    private StatListOp statList;

    public ElseOp(StatListOp list) {
        this.statList = list;
    }

    @Override
    public String toString() {
        return "ElseOp{" +
                "statList=" + statList +
                '}';
    }

    public StatListOp getStatList() {
        return statList;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
