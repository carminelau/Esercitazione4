package syntax.types;

import visitor.Visitor;

public class PrimitiveType extends Type{
    private String nameType;

    /**
     * @param leftPosition  the left position
     * @param rightPosition the right position
     * @param nameType the name of type
     */
    public PrimitiveType(int leftPosition, int rightPosition, String nameType) {
        super(leftPosition, rightPosition);
        this.nameType = nameType;
    }


    /**
     * @return the name of type eg String, int, boolean,...
     */
    public String getNameType() {
        return nameType;
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
