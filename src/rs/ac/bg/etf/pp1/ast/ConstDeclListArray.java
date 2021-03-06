// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListArray extends Const_Decl_List {

    private Const_Decl_List Const_Decl_List;
    private Const_Decl Const_Decl;

    public ConstDeclListArray (Const_Decl_List Const_Decl_List, Const_Decl Const_Decl) {
        this.Const_Decl_List=Const_Decl_List;
        if(Const_Decl_List!=null) Const_Decl_List.setParent(this);
        this.Const_Decl=Const_Decl;
        if(Const_Decl!=null) Const_Decl.setParent(this);
    }

    public Const_Decl_List getConst_Decl_List() {
        return Const_Decl_List;
    }

    public void setConst_Decl_List(Const_Decl_List Const_Decl_List) {
        this.Const_Decl_List=Const_Decl_List;
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
        if(Const_Decl_List!=null) Const_Decl_List.accept(visitor);
        if(Const_Decl!=null) Const_Decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Const_Decl_List!=null) Const_Decl_List.traverseTopDown(visitor);
        if(Const_Decl!=null) Const_Decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Const_Decl_List!=null) Const_Decl_List.traverseBottomUp(visitor);
        if(Const_Decl!=null) Const_Decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListArray(\n");

        if(Const_Decl_List!=null)
            buffer.append(Const_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Const_Decl!=null)
            buffer.append(Const_Decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListArray]");
        return buffer.toString();
    }
}
