package syntax;

import syntax.expression.Id;
import syntax.statement.AssignStatement;
import syntax.types.Type;
import visitor.Visitor;

import java.util.ArrayList;

public class VarDecl extends ASTNode{
    private ArrayList<AssignStatement> idlistinit;
    private Type type;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param idlistinit idlistinit
     * @param type type
     * */
    public VarDecl(int leftPosition, int rightPosition, Type type, ArrayList<AssignStatement> idlistinit) {
        super(leftPosition, rightPosition);
        this.idlistinit = idlistinit;
        this.type = type;
    }

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param idlistinit idlistinit
     * */
    public VarDecl(int leftPosition, int rightPosition, ArrayList<AssignStatement> idlistinit) {
        super(leftPosition, rightPosition);
        this.idlistinit = idlistinit;
    }

    /**
     * @return the id
     */
    public ArrayList<AssignStatement> getIdlistinit() {
        return idlistinit;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
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
