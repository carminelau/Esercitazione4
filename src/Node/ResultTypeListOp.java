package Node;

import Visitor.Visitor;
import Visitor.XmlGenerator;

import java.util.ArrayList;

public class ResultTypeListOp {
    private ArrayList<ResultTypeOp> list;

    public ResultTypeListOp(ArrayList<ResultTypeOp> list) {
        this.list = list;
    }

    public ResultTypeListOp add(ResultTypeOp resultType){
        list.add(0,resultType);
        return this;
    }

    public ArrayList<ResultTypeOp> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ResultTypeListOp{" +
                "list=" + list +
                '}';
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
