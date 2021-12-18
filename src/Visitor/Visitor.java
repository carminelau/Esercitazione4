package Visitor;

import Operation.*;
import Statement.*;
import Node.*;

public interface Visitor {

    Object visit(ProgramOp programOp);

    Object visit(ProcListOp procListOp);

    Object visit(ParamDeclListOp paramDeclListOp);

    Object visit(IdListOp idListOp);

    Object visit(AssignStatOp assignStatOp);

    Object visit(CallProcOp callProcOp);

    Object visit(ElifOp elifOp);

    Object visit(StatListOp statListOp);

    Object visit(ResultTypeListOp resultTypeListOp);

    Object visit(ElseOp elseOp);

    Object visit(Operation operationp);

    Object visit(ExprOp exprOp);

    Object visit(IdListInitOp idListInitOp);

    Object visit(IfStatOp ifStatOp);

    Object visit(ParDeclOp parDeclOp);

    Object visit(ProcOp procOp);

    Object visit(ReadlnStatOp readlnStatOp);

    Object visit(ReturnExprsOp returnExprsOp);

    Object visit(StatOp statOp);

    Object visit(ExprListOp exprListOp);

    Object visit(VarDeclOp varDecl);

    Object visit(VarDeclListOp varDeclList);

    Object visit(TypeOp typeOp);

    Object visit(WhileStatOp whileStatOp);

    Object visit(WriteStatOp writeStatOp);

    Object visit(ElifListOp elifListOp);
}
