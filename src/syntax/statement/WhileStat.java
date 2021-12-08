package syntax.statement;

import syntax.expression.Expr;

import java.util.ArrayList;

public class WhileStat extends Stat{

        private Expr conditionExpression;
        private ArrayList<Stat> statements;


        /**
         * @param leftPosition  the left position
         * @param rightPosition the right position
         * @param conditionExpression
         * @param statements
         */
        public WhileStat(int leftPosition, int rightPosition, Expr conditionExpression, ArrayList<Stat> statements) {
            super(leftPosition, rightPosition);
            this.conditionExpression = conditionExpression;
            this.statements = statements;
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
