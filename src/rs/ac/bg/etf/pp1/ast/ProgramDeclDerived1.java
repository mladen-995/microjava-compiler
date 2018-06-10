// generated with ast extension for cup
// version 0.8
// 10/5/2018 12:50:18


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclDerived1 extends ProgramDecl {

    private ConstDeclWrapper ConstDeclWrapper;

    public ProgramDeclDerived1 (ConstDeclWrapper ConstDeclWrapper) {
        this.ConstDeclWrapper=ConstDeclWrapper;
        if(ConstDeclWrapper!=null) ConstDeclWrapper.setParent(this);
    }

    public ConstDeclWrapper getConstDeclWrapper() {
        return ConstDeclWrapper;
    }

    public void setConstDeclWrapper(ConstDeclWrapper ConstDeclWrapper) {
        this.ConstDeclWrapper=ConstDeclWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclWrapper!=null) ConstDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclWrapper!=null) ConstDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclWrapper!=null) ConstDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclDerived1(\n");

        if(ConstDeclWrapper!=null)
            buffer.append(ConstDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclDerived1]");
        return buffer.toString();
    }
}
