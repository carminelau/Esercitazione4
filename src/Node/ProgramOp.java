package Node;

import Visitor.Visitor;

public class ProgramOp {

    private VarDeclListOp varDeclOpList;
    private ProcListOp ProcOpList;

    public ProgramOp(VarDeclListOp varDeclOpList, ProcListOp procOpList) {
        this.varDeclOpList = varDeclOpList;
        this.ProcOpList = procOpList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public VarDeclListOp getVarDeclOpList() {
        return varDeclOpList;
    }

    public ProcListOp getProcOpList() {
        return ProcOpList;
    }

    @Override
    public String toString() {
        return "ProgramOp{" +
                varDeclOpList +
                ProcOpList +
                '}';
    }
}
