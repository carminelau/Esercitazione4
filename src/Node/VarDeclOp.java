package Node;

import Visitor.Visitor;

public class VarDeclOp {

    private TypeOp tipo;
    private IdListInitOp list;

    public VarDeclOp(TypeOp t, IdListInitOp list) {
        this.tipo = t;
        this.list = list;
    }

    public VarDeclOp(IdListInitOp list) {
        this.list = list;
    }

    public TypeOp getTipo() {
        return tipo;
    }

    public IdListInitOp getList() {
        return list;
    }

    @Override
    public String toString() {
        return tipo + "" +list;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}