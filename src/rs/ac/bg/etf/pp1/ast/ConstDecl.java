// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl extends Const_Decl {

    private Const_Name Const_Name;
    private Const_Type Const_Type;

    public ConstDecl (Const_Name Const_Name, Const_Type Const_Type) {
        this.Const_Name=Const_Name;
        if(Const_Name!=null) Const_Name.setParent(this);
        this.Const_Type=Const_Type;
        if(Const_Type!=null) Const_Type.setParent(this);
    }

    public Const_Name getConst_Name() {
        return Const_Name;
    }

    public void setConst_Name(Const_Name Const_Name) {
        this.Const_Name=Const_Name;
    }

    public Const_Type getConst_Type() {
        return Const_Type;
    }

    public void setConst_Type(Const_Type Const_Type) {
        this.Const_Type=Const_Type;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Const_Name!=null) Const_Name.accept(visitor);
        if(Const_Type!=null) Const_Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Const_Name!=null) Const_Name.traverseTopDown(visitor);
        if(Const_Type!=null) Const_Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Const_Name!=null) Const_Name.traverseBottomUp(visitor);
        if(Const_Type!=null) Const_Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(Const_Name!=null)
            buffer.append(Const_Name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Const_Type!=null)
            buffer.append(Const_Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
