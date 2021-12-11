package syntax.statement;

import syntax.VarDecl;
import syntax.expression.Expr;
import visitor.Visitor;

import java.util.ArrayList;

public class WhileStatement extends Statement {

        private Expr conditionExpression;
        private ArrayList<Statement> statements;
        private ArrayList<VarDecl> varDeclList;


        /**
         * @param leftPosition  the left position
         * @param rightPosition the right position
         * @param conditionExpression
         * @param varDeclList
         * @param statements
         */
        public WhileStatement(int leftPosition, int rightPosition, Expr conditionExpression, ArrayList<VarDecl> varDeclList, ArrayList<Statement> statements) {
            super(leftPosition, rightPosition);
            this.conditionExpression = conditionExpression;
            this.varDeclList=varDeclList;
            this.statements = statements;
        }

    public WhileStatement (int leftPosition, int rightPosition){
        super(leftPosition, rightPosition);
    }


    /**
         * @return the condition
         */
        public Expr getConditionExpression() {
            return conditionExpression;
        }

        /**
         * @return the statements list
         */
        public ArrayList<Statement> getStatements() {
            return statements;
        }

        /**
         * Implement interface method
         * @param visitor the visitor
         * @param arg argoment
         * @param <T> Visitor param T
         * @param <P> Visitor param P
         * @return the visited element
         */
        @Override
        public <T, P> T accept(Visitor<T, P> visitor, P arg) {
            return visitor.visit(this, arg);
        }
}
