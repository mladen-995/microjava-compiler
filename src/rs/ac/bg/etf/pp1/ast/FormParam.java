// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class FormParam extends Form_Param {

    private Type Type;
    private Var_Decl Var_Decl;

    public FormParam (Type Type, Var_Decl Var_Decl) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Var_Decl=Var_Decl;
        if(Var_Decl!=null) Var_Decl.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(Var_Decl!=null) Var_Decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Var_Decl!=null) Var_Decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Var_Decl!=null) Var_Decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParam(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Var_Decl!=null)
            buffer.append(Var_Decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParam]");
        return buffer.toString();
    }
}
