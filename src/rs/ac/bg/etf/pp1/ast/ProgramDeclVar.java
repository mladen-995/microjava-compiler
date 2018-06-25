// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclVar extends Program_Decl {

    private Var_Decl_Globl_Wrapper Var_Decl_Globl_Wrapper;

    public ProgramDeclVar (Var_Decl_Globl_Wrapper Var_Decl_Globl_Wrapper) {
        this.Var_Decl_Globl_Wrapper=Var_Decl_Globl_Wrapper;
        if(Var_Decl_Globl_Wrapper!=null) Var_Decl_Globl_Wrapper.setParent(this);
    }

    public Var_Decl_Globl_Wrapper getVar_Decl_Globl_Wrapper() {
        return Var_Decl_Globl_Wrapper;
    }

    public void setVar_Decl_Globl_Wrapper(Var_Decl_Globl_Wrapper Var_Decl_Globl_Wrapper) {
        this.Var_Decl_Globl_Wrapper=Var_Decl_Globl_Wrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Var_Decl_Globl_Wrapper!=null) Var_Decl_Globl_Wrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Var_Decl_Globl_Wrapper!=null) Var_Decl_Globl_Wrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Var_Decl_Globl_Wrapper!=null) Var_Decl_Globl_Wrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclVar(\n");

        if(Var_Decl_Globl_Wrapper!=null)
            buffer.append(Var_Decl_Globl_Wrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclVar]");
        return buffer.toString();
    }
}
