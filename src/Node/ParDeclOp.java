package Node;

import Statement.IdListOp;
import Visitor.Visitor;
import Visitor.XmlGenerator;
import org.w3c.dom.Node;

public class ParDeclOp {
    private TypeOp t;
    private IdListOp list;
    public ParDeclOp(TypeOp t, IdListOp list) {
        this.list = list;
        this.t = t;
    }

    public ParDeclOp(TypeOp t) {
        this.t = t;
    }

    public TypeOp getT() {
        return t;
    }

    public IdListOp getList() {
        return list;
    }

    @Override
    public String toString() {
        return t + "" + list;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
