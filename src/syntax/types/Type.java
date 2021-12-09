package syntax.types;

import syntax.ASTNode;
import visitor.Visitor;

public abstract class Type extends ASTNode {
    /**
     * Initialize a new generic Type node.
     *
     * @param leftPosition  the left position
     * @param rightPosition the right position
     */
    public Type(int leftPosition, int rightPosition) {
        super(leftPosition, rightPosition);
    }
}
