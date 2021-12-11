package visitor;

import syntax.*;
import syntax.expression.binary.arithmetic.*;
import syntax.expression.binary.relation.*;
import syntax.expression.*;
import syntax.expression.constant.*;
import syntax.expression.unary.*;
import syntax.statement.*;
import syntax.types.PrimitiveType;


public interface Visitor<T,P> {
    T visit(Fun function, P arg);

    T visit(Id id, P arg);

    T visit(DivOperation divOperation, P arg);

    T visit(DivIntOperation divIntOperation, P arg);

    T visit(MinusOperation minusOperation, P arg);

    T visit(PlusOperation plusOperation, P arg);

    T visit(PowOperation powOperation, P arg);

    T visit(Str_ConcatOperation str_concatOperation, P arg);

    T visit(TimesOperation timesOperation, P arg);

    T visit(AndRelOperation andRelOperation, P arg);

    T visit(EqualsRelOperation equalsRelOperation, P arg);

    T visit(GreatThanEqualsRelOperation greatThanEqualsRelOperation, P arg);

    T visit(GreatThanRelOperation greatThanRelOperation, P arg);

    T visit(LessThanEqualsRelOperation lessThanEqualsRelOperation, P arg);

    T visit(LessThanRelOperation lessThanRelOperation, P arg);

    T visit(NotEqualsRelOperation notEqualsRelOperation, P arg);

    T visit(OrRelOperation orRelOperation, P arg);

    T visit(BooleanConst booleanConst, P arg);

    T visit(RealConst floatConst, P arg);

    T visit(IntegerConst integerConst, P arg);

    T visit(StringConst stringConst, P arg);

    T visit(CallingFun functionCall, P arg);

    T visit(CallingFunStatement functionCall, P arg);

    T visit(FunctionParam functionParam, P arg);

    T visit(AssignStatement assignStatement, P arg);

    T visit(IfStatement ifStatement, P arg);

    T visit(ReadStatement readStatement, P arg);

    T visit(ReturnStatement returnStatement, P arg);

    T visit(WhileStatement whileStatement, P arg);

    T visit(WriteStatement writeStatement, P arg);

    T visit(ElseStatement global, P arg);

    T visit(ParDecl parDecl, P arg);

    T visit(Main program, P arg);

    T visit(VarDecl varDecl, P arg);

    T visit(Program varInitValue, P arg);

    T visit(PrimitiveType primitiveType, P arg);

    T visit(NotExpression notExpression, P arg);

    T visit(UminusExpression uminusExpression, P arg);
}
