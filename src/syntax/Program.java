package syntax;

import visitor.Visitor;

import java.util.ArrayList;

public class Program extends ASTNode{
    private ArrayList<VarDecl> vardecllist;
    private ArrayList<Fun> funlist;
    private Main main;

    public Program (int left, int right, ArrayList<VarDecl> vardecllist, ArrayList<Fun> funlist, Main main){
        super(left,right);
        this.vardecllist=vardecllist;
        this.funlist=funlist;
        this.main=main;
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }

    public ArrayList<VarDecl> getVardecllist() {
        return vardecllist;
    }

    public ArrayList<Fun> getFunlist() {
        return funlist;
    }

    public Main getMain() {
        return main;
    }
}
