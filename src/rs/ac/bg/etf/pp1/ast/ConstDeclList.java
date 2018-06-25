// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclList extends Const_Decl_List {

    private Const_Decl Const_Decl;

    public ConstDeclList (Const_Decl Const_Decl) {
        this.Const_Decl=Const_Decl;
        if(Const_Decl!=null) Const_Decl.setParent(this);
    }

    public Const_Decl getConst_Decl() {
        return Const_Decl;
    }

    public void setConst_Decl(Const_Decl Const_Decl) {
        this.Const_Decl=Const_Decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Const_Decl!=null) Const_Decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Const_Decl!=null) Const_Decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Const_Decl!=null) Const_Decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclList(\n");

        if(Const_Decl!=null)
            buffer.append(Const_Decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclList]");
        return buffer.toString();
    }
}
