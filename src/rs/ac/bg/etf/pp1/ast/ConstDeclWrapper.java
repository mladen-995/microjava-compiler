// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclWrapper extends Const_Decl_Wrapper {

    private Type Type;
    private Const_Decl_List Const_Decl_List;

    public ConstDeclWrapper (Type Type, Const_Decl_List Const_Decl_List) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Const_Decl_List=Const_Decl_List;
        if(Const_Decl_List!=null) Const_Decl_List.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Const_Decl_List getConst_Decl_List() {
        return Const_Decl_List;
    }

    public void setConst_Decl_List(Const_Decl_List Const_Decl_List) {
        this.Const_Decl_List=Const_Decl_List;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(Const_Decl_List!=null) Const_Decl_List.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Const_Decl_List!=null) Const_Decl_List.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Const_Decl_List!=null) Const_Decl_List.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclWrapper(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Const_Decl_List!=null)
            buffer.append(Const_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclWrapper]");
        return buffer.toString();
    }
}
