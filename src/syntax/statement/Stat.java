package syntax.statement;

import syntax.ASTNode;

public abstract class Stat extends ASTNode {
    /**
     * Initialize a new generic AST node.
     *
     * @param leftPosition  the left position
     * @param rightPosition the right position
     */
    public Stat(int leftPosition, int rightPosition) {
        super(leftPosition, rightPosition);
    }
}
