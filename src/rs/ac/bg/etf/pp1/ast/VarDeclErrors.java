// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class VarDeclErrors extends Var_Decl_Globl_Wrapper {

    private Glob_Decl_Errors Glob_Decl_Errors;

    public VarDeclErrors (Glob_Decl_Errors Glob_Decl_Errors) {
        this.Glob_Decl_Errors=Glob_Decl_Errors;
        if(Glob_Decl_Errors!=null) Glob_Decl_Errors.setParent(this);
    }

    public Glob_Decl_Errors getGlob_Decl_Errors() {
        return Glob_Decl_Errors;
    }

    public void setGlob_Decl_Errors(Glob_Decl_Errors Glob_Decl_Errors) {
        this.Glob_Decl_Errors=Glob_Decl_Errors;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Glob_Decl_Errors!=null) Glob_Decl_Errors.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Glob_Decl_Errors!=null) Glob_Decl_Errors.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Glob_Decl_Errors!=null) Glob_Decl_Errors.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclErrors(\n");

        if(Glob_Decl_Errors!=null)
            buffer.append(Glob_Decl_Errors.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclErrors]");
        return buffer.toString();
    }
}
