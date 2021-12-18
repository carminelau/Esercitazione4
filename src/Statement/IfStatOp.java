package Statement;

import Operation.ExprOp;
import Visitor.Visitor;
import Visitor.XmlGenerator;

public class IfStatOp extends Statement{

    private ExprOp e;
    private StatListOp statList;
    private ElifListOp elifList;
    private ElseOp elseStat;

    public IfStatOp(ExprOp e, StatListOp statList,ElifListOp elifList,ElseOp elseStat) {
        this.e = e;
        this.statList = statList;
        this.elifList = elifList;
        this.elseStat = elseStat;
    }

    public ExprOp getE() {
        return e;
    }

    public StatListOp getStatList() {
        return statList;
    }

    public ElifListOp getElifList() {
        return elifList;
    }

    public ElseOp getElseStat() {
        return elseStat;
    }

    @Override
    public String toString() {
        return "IfStatOp{" +
                 e +
                "," + statList +
                "," + elifList +
                "," + elseStat +
                '}';
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
