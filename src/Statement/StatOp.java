package Statement;

import Visitor.Visitor;
import Visitor.XmlGenerator;

public class StatOp {
    private Statement statement;

    public StatOp(Statement statement) {
        this.statement = statement;
    }

    public Statement getStatement() {
        return statement;
    }

    @Override
    public String toString() {
        return statement.toString();
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
