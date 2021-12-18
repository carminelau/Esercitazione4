package Node;

import Visitor.Visitor;

public class Id {
    private String id;

    public Id(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
