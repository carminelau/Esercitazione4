package Node;

import Statement.StatListOp;
import Visitor.Visitor;
import Visitor.XmlGenerator;

public class ProcOp {
    private String id;
    private ParamDeclListOp paramList;
    private ResultTypeListOp resultTypeList;
    private VarDeclListOp varList;
    private StatListOp statList;
    private ReturnExprsOp returnList;

    public ProcOp(String id, ParamDeclListOp paramList, ResultTypeListOp resultTypeList, VarDeclListOp varList, StatListOp statList, ReturnExprsOp returnList) {
        this.id = id;
        this.paramList = paramList;
        this.resultTypeList = resultTypeList;
        this.varList = varList;
        this.statList = statList;
        this.returnList = returnList;
    }

    public ProcOp(String id, ParamDeclListOp paramList, ResultTypeListOp resultTypeList, VarDeclListOp varList, ReturnExprsOp returnList) {
        this.id = id;
        this.paramList = paramList;
        this.resultTypeList = resultTypeList;
        this.varList = varList;
        this.returnList = returnList;
    }

    public String getId() {
        return id;
    }

    public ParamDeclListOp getParamList() {
        return paramList;
    }

    public ResultTypeListOp getResultTypeList() {
        return resultTypeList;
    }

    public VarDeclListOp getVarList() {
        return varList;
    }

    public StatListOp getStatList() {
        return statList;
    }

    public ReturnExprsOp getReturnExprs() {
        return returnList;
    }

    @Override
    public String toString() {
        return "ProcOp{" +
                "id='" + id + '\'' +
                ", paramList=" + paramList +
                ", resultTypeList=" + resultTypeList +
                ", varList=" + varList +
                ", statList=" + statList +
                ", returnExprs=" + returnList +
                '}';
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
