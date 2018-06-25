// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListArray extends Var_Decl_List {

    private Var_Decl_List Var_Decl_List;
    private Var_Decl Var_Decl;

    public VarDeclListArray (Var_Decl_List Var_Decl_List, Var_Decl Var_Decl) {
        this.Var_Decl_List=Var_Decl_List;
        if(Var_Decl_List!=null) Var_Decl_List.setParent(this);
        this.Var_Decl=Var_Decl;
        if(Var_Decl!=null) Var_Decl.setParent(this);
    }

    public Var_Decl_List getVar_Decl_List() {
        return Var_Decl_List;
    }

    public void setVar_Decl_List(Var_Decl_List Var_Decl_List) {
        this.Var_Decl_List=Var_Decl_List;
    }

    public Var_Decl getVar_Decl() {
        return Var_Decl;
    }

    public void setVar_Decl(Var_Decl Var_Decl) {
        this.Var_Decl=Var_Decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Var_Decl_List!=null) Var_Decl_List.accept(visitor);
        if(Var_Decl!=null) Var_Decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Var_Decl_List!=null) Var_Decl_List.traverseTopDown(visitor);
        if(Var_Decl!=null) Var_Decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Var_Decl_List!=null) Var_Decl_List.traverseBottomUp(visitor);
        if(Var_Decl!=null) Var_Decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListArray(\n");

        if(Var_Decl_List!=null)
            buffer.append(Var_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Var_Decl!=null)
            buffer.append(Var_Decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclListArray]");
        return buffer.toString();
    }
}
