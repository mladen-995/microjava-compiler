// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class VarDeclWrapper extends Var_Decl_Wrapper {

    private Type Type;
    private Var_Decl_List Var_Decl_List;

    public VarDeclWrapper (Type Type, Var_Decl_List Var_Decl_List) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Var_Decl_List=Var_Decl_List;
        if(Var_Decl_List!=null) Var_Decl_List.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Var_Decl_List getVar_Decl_List() {
        return Var_Decl_List;
    }

    public void setVar_Decl_List(Var_Decl_List Var_Decl_List) {
        this.Var_Decl_List=Var_Decl_List;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(Var_Decl_List!=null) Var_Decl_List.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Var_Decl_List!=null) Var_Decl_List.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Var_Decl_List!=null) Var_Decl_List.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclWrapper(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Var_Decl_List!=null)
            buffer.append(Var_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclWrapper]");
        return buffer.toString();
    }
}
