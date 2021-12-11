package syntax.statement;

import syntax.expression.CallingFun;
import visitor.Visitor;

public class CallingFunStatement extends Statement{
    private CallingFun callfun;

    public CallingFunStatement(int left, int right, CallingFun callingFun){
        super(left, right);
        this.callfun=callingFun;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }

    public CallingFun getCallfun() {
        return callfun;
    }
}
