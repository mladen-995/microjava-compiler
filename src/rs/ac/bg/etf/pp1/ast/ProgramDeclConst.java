// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclConst extends Program_Decl {

    private Const_Decl_Wrapper Const_Decl_Wrapper;

    public ProgramDeclConst (Const_Decl_Wrapper Const_Decl_Wrapper) {
        this.Const_Decl_Wrapper=Const_Decl_Wrapper;
        if(Const_Decl_Wrapper!=null) Const_Decl_Wrapper.setParent(this);
    }

    public Const_Decl_Wrapper getConst_Decl_Wrapper() {
        return Const_Decl_Wrapper;
    }

    public void setConst_Decl_Wrapper(Const_Decl_Wrapper Const_Decl_Wrapper) {
        this.Const_Decl_Wrapper=Const_Decl_Wrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Const_Decl_Wrapper!=null) Const_Decl_Wrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Const_Decl_Wrapper!=null) Const_Decl_Wrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Const_Decl_Wrapper!=null) Const_Decl_Wrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclConst(\n");

        if(Const_Decl_Wrapper!=null)
            buffer.append(Const_Decl_Wrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclConst]");
        return buffer.toString();
    }
}
