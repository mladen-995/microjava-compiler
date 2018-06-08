// generated with ast extension for cup
// version 0.8
// 22/3/2018 16:44:45


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclDerived2 extends ProgramDecl {

    private VarDeclWrapper VarDeclWrapper;

    public ProgramDeclDerived2 (VarDeclWrapper VarDeclWrapper) {
        this.VarDeclWrapper=VarDeclWrapper;
        if(VarDeclWrapper!=null) VarDeclWrapper.setParent(this);
    }

    public VarDeclWrapper getVarDeclWrapper() {
        return VarDeclWrapper;
    }

    public void setVarDeclWrapper(VarDeclWrapper VarDeclWrapper) {
        this.VarDeclWrapper=VarDeclWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclWrapper!=null) VarDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclDerived2(\n");

        if(VarDeclWrapper!=null)
            buffer.append(VarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclDerived2]");
        return buffer.toString();
    }
}
