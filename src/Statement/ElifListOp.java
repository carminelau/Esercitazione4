package Statement;

import Visitor.Visitor;
import Visitor.XmlGenerator;

import java.util.ArrayList;

public class ElifListOp {
    private  ArrayList<ElifOp> list;

    public ElifListOp(ArrayList<ElifOp> list) {
        this.list = list;
    }

    public ElifListOp add(ElifOp elifOp) {
        list.add(0,elifOp);
        return this;
    }

    public ArrayList<ElifOp> getList() {
        return list;
    }

    @Override
    public String toString() {
        return  "ElifList" + list.toString();
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
