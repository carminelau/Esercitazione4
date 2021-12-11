package visitor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import syntax.*;
import syntax.expression.CallingFun;
import syntax.expression.FunctionParam;
import syntax.expression.Id;
import syntax.expression.binary.arithmetic.*;
import syntax.expression.binary.relation.*;
import syntax.expression.constant.*;
import syntax.expression.unary.NotExpression;
import syntax.expression.unary.UminusExpression;
import syntax.statement.*;
import syntax.types.PrimitiveType;
import java.util.function.Consumer;

public class ConcreteVisitor implements Visitor<Element, Document> {

    /* <? super ASTNode> means everything that is a superclass of AstNode */
    private Consumer<? super ASTNode> appendLamda(Element parent, Document arg){
        return (ASTNode node) -> parent.appendChild(node.accept(this, arg));
    }

    @Override
    public Element visit(Program program, Document arg) {
        Element element = arg.createElement(program.getClass().getSimpleName());
        element.appendChild(program.getMain().accept(this, arg));
        program.getFunlist().forEach(appendLamda(element, arg));
        program.getVardecllist().forEach(appendLamda(element, arg));
        arg.appendChild(element);
        return element;
    }

    @Override
    public Element visit(Fun function, Document arg) {
        Element element = arg.createElement(function.getClass().getSimpleName());
        element.appendChild(function.getId().accept(this, arg));
        function.getParDeclList().forEach(appendLamda(element, arg));
        element.appendChild(function.getType().accept(this, arg));
        function.getStatements().forEach(appendLamda(element, arg));
        return element;
    }

    @Override
    public Element visit(ParDecl parDecl, Document arg) {
        Element element = arg.createElement(parDecl.getClass().getSimpleName());
        element.appendChild(parDecl.getId().accept(this, arg));
        element.appendChild((parDecl.getType().accept(this, arg)));
        return element;
    }

    @Override
    public Element visit(Main program, Document arg) {
        return null;
    }

    @Override
    public Element visit(VarDecl varDecl, Document arg) {
        Element element = arg.createElement(varDecl.getClass().getSimpleName());
        varDecl.getIdlistinit().forEach(appendLamda(element, arg));
        element.appendChild(varDecl.getType().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(PrimitiveType primitiveType, Document arg) {
        Element element = arg.createElement(primitiveType.getClass().getSimpleName());
        element.setAttribute("kind", primitiveType.getNameType());
        return element;
    }

    @Override
    public Element visit(IfStatement ifStatement, Document arg) {
        Element element = arg.createElement(ifStatement.getClass().getSimpleName());
        element.appendChild(ifStatement.getCondition().accept(this, arg));
        ifStatement.getThenStatement().forEach(appendLamda(element, arg));
        return element;
    }

    @Override
    public Element visit(ElseStatement elseStatement, Document arg) {
        Element element = arg.createElement(elseStatement.getClass().getSimpleName());
        elseStatement.getVarDecllist().forEach(appendLamda(element, arg));
        elseStatement.getStatementList().forEach(appendLamda(element, arg));
        return element;
    }

    @Override
    public Element visit(AssignStatement assignStatement, Document arg) {
        Element element = arg.createElement(assignStatement.getClass().getSimpleName());
        element.appendChild(assignStatement.getExpression().accept(this, arg));
        element.appendChild(assignStatement.getId().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(CallingFunStatement callingFunStatement, Document arg) {
        Element element = arg.createElement(callingFunStatement.getClass().getSimpleName());
        element.appendChild(callingFunStatement.getCallfun().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(FunctionParam functionParam, Document arg) {
        Element element = arg.createElement(functionParam.getClass().getSimpleName());
        element.appendChild(functionParam.getExpr().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(ReadStatement readStatement, Document arg) {
        Element element = arg.createElement(readStatement.getClass().getSimpleName());
        readStatement.getVariables().forEach(appendLamda(element, arg));
        return element;
    }

    @Override
    public Element visit(WriteStatement writeStatements, Document arg) {
        Element element = arg.createElement(writeStatements.getClass().getSimpleName());
        element.appendChild(writeStatements.getExpression().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(ReturnStatement returnStatement, Document arg) {
        Element element = arg.createElement(returnStatement.getClass().getSimpleName());
        element.appendChild(returnStatement.getReturnExpression().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(WhileStatement whileStatement, Document arg) {
        Element element = arg.createElement(whileStatement.getClass().getSimpleName());
        element.appendChild(whileStatement.getConditionExpression().accept(this, arg));
        whileStatement.getStatements().forEach(appendLamda(element, arg));
        return element;
    }


    @Override
    public Element visit(BooleanConst booleanConst, Document arg) {
        Element element = arg.createElement(booleanConst.getClass().getSimpleName());
        element.setAttribute("value", booleanConst.getValue().toString());
        return element;
    }

    @Override
    public Element visit(IntegerConst integerConst, Document arg) {
        Element element = arg.createElement(integerConst.getClass().getSimpleName());
        element.setAttribute("value", String.valueOf(integerConst.getValue()));
        return element;
    }

    @Override
    public Element visit(RealConst floatConst, Document arg) {
        Element element = arg.createElement(floatConst.getClass().getSimpleName());
        element.setAttribute("value", String.valueOf(floatConst.getValue()));
        return element;
    }

    @Override
    public Element visit(StringConst stringConst, Document arg) {
        Element element = arg.createElement(stringConst.getClass().getSimpleName());
        element.setAttribute("value", stringConst.getValue());
        return element;
    }

    @Override
    public Element visit(CallingFun functionCall, Document arg) {
        Element element = arg.createElement(functionCall.getClass().getSimpleName());
        element.appendChild(functionCall.getId().accept(this, arg));
        functionCall.getExprs().forEach(appendLamda(element, arg));
        return element;
    }


    @Override
    public Element visit(MinusOperation minusOperation, Document arg) {
        Element element = arg.createElement(minusOperation.getClass().getSimpleName());
        element.appendChild(minusOperation.getLeftOperand().accept(this, arg));
        element.appendChild(minusOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(PlusOperation plusOperation, Document arg) {
        Element element = arg.createElement(plusOperation.getClass().getSimpleName());
        element.appendChild(plusOperation.getLeftOperand().accept(this, arg));
        element.appendChild(plusOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(Str_ConcatOperation str_concatOperationOperation, Document arg) {
        Element element = arg.createElement(str_concatOperationOperation.getClass().getSimpleName());
        element.appendChild(str_concatOperationOperation.getLeftOperand().accept(this, arg));
        element.appendChild(str_concatOperationOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(TimesOperation timesOperation, Document arg) {
        Element element = arg.createElement(timesOperation.getClass().getSimpleName());
        element.appendChild(timesOperation.getLeftOperand().accept(this, arg));
        element.appendChild(timesOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit (DivOperation divIntOperation, Document arg) {
        Element element = arg.createElement(divIntOperation.getClass().getSimpleName());
        element.appendChild(divIntOperation.getLeftOperand().accept(this, arg));
        element.appendChild(divIntOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(DivIntOperation divOperation, Document arg) {
        Element element = arg.createElement(divOperation.getClass().getSimpleName());
        element.appendChild(divOperation.getLeftOperand().accept(this, arg));
        element.appendChild(divOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(PowOperation powOperation, Document arg) {
        Element element = arg.createElement(powOperation.getClass().getSimpleName());
        element.appendChild(powOperation.getLeftOperand().accept(this, arg));
        element.appendChild(powOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(AndRelOperation andRelOperation, Document arg) {
        Element element = arg.createElement(andRelOperation.getClass().getSimpleName());
        element.appendChild(andRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(andRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(GreatThanRelOperation greatThanRelOperation, Document arg) {
        Element element = arg.createElement(greatThanRelOperation.getClass().getSimpleName());
        element.appendChild(greatThanRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(greatThanRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(OrRelOperation orRelOperation, Document arg) {
        Element element = arg.createElement(orRelOperation.getClass().getSimpleName());
        element.appendChild(orRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(orRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(GreatThanEqualsRelOperation greatThanEqualsRelOperation, Document arg) {
        Element element = arg.createElement(greatThanEqualsRelOperation.getClass().getSimpleName());
        element.appendChild(greatThanEqualsRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(greatThanEqualsRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(LessThanRelOperation lessThanRelOperation, Document arg) {
        Element element = arg.createElement(lessThanRelOperation.getClass().getSimpleName());
        element.appendChild(lessThanRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(lessThanRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(LessThanEqualsRelOperation lessThanEqualsRelOperation, Document arg) {
        Element element = arg.createElement(lessThanEqualsRelOperation.getClass().getSimpleName());
        element.appendChild(lessThanEqualsRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(lessThanEqualsRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(EqualsRelOperation equalsRelOperation, Document arg) {
        Element element = arg.createElement(equalsRelOperation.getClass().getSimpleName());
        element.appendChild(equalsRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(equalsRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(NotEqualsRelOperation notEqualsRelOperation, Document arg) {
        Element element = arg.createElement(notEqualsRelOperation.getClass().getSimpleName());
        element.appendChild(notEqualsRelOperation.getLeftOperand().accept(this, arg));
        element.appendChild(notEqualsRelOperation.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(UminusExpression uminusExpression, Document arg) {
        Element element = arg.createElement(uminusExpression.getClass().getSimpleName());
        element.appendChild(uminusExpression.getExpr().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(NotExpression notExpression, Document arg) {
        Element element = arg.createElement(notExpression.getClass().getSimpleName());
        element.appendChild(notExpression.getExpr().accept(this, arg));
        return element;
    }


    @Override
    public Element visit(Id id, Document arg) {
        Element element = arg.createElement(id.getClass().getSimpleName());
        element.setAttribute("lexeme", id.getValue());
        return element;
    }
}
