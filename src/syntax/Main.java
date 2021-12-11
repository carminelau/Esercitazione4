package syntax;

import syntax.statement.Statement;
import visitor.Visitor;

import java.util.ArrayList;

public class Main extends ASTNode{
    private ArrayList<VarDecl> varDecllist;
    private ArrayList<Statement> statlist;

    public Main(int left, int right,ArrayList<VarDecl> varDecllist, ArrayList<Statement> statlist){
        super(left,right);
        this.statlist=statlist;
        this.varDecllist=varDecllist;
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }

    public ArrayList<VarDecl> getVarDecllist() {
        return varDecllist;
    }

    public ArrayList<Statement> getStatlist() {
        return statlist;
    }
}
