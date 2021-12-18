package Statement;

import Operation.ExprOp;
import Visitor.Visitor;
import Visitor.XmlGenerator;

public class WhileStatOp extends Statement {
    private StatListOp statListOp;
    private StatListOp statListOp1;
    private ExprOp e;

    public WhileStatOp(ExprOp e,StatListOp statListOp) {
        this.statListOp = statListOp;
        this.e = e;
    }
    
    public WhileStatOp(ExprOp e,StatListOp statListOp1,StatListOp statListOp) {
        this.statListOp = statListOp;
        this.statListOp1 = statListOp1;
        this.e = e;
    }

    @Override
    public String toString() {
        return "WhileStatOp{" +
                "statListOp=" + statListOp +
                ", e=" + e +
                '}';
    }

    public StatListOp getStatListOp() {
        return statListOp;
    }
    
    public StatListOp getStatListOp1() {
        return statListOp1;
    }
    
    public ExprOp getE() {
        return e;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
