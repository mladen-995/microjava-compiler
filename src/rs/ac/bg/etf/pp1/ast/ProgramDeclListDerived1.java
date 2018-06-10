// generated with ast extension for cup
// version 0.8
// 10/5/2018 12:50:18


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclListDerived1 extends ProgramDeclList {

    private ProgramDeclList ProgramDeclList;
    private ProgramDecl ProgramDecl;

    public ProgramDeclListDerived1 (ProgramDeclList ProgramDeclList, ProgramDecl ProgramDecl) {
        this.ProgramDeclList=ProgramDeclList;
        if(ProgramDeclList!=null) ProgramDeclList.setParent(this);
        this.ProgramDecl=ProgramDecl;
        if(ProgramDecl!=null) ProgramDecl.setParent(this);
    }

    public ProgramDeclList getProgramDeclList() {
        return ProgramDeclList;
    }

    public void setProgramDeclList(ProgramDeclList ProgramDeclList) {
        this.ProgramDeclList=ProgramDeclList;
    }

    public ProgramDecl getProgramDecl() {
        return ProgramDecl;
    }

    public void setProgramDecl(ProgramDecl ProgramDecl) {
        this.ProgramDecl=ProgramDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclList!=null) ProgramDeclList.accept(visitor);
        if(ProgramDecl!=null) ProgramDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclList!=null) ProgramDeclList.traverseTopDown(visitor);
        if(ProgramDecl!=null) ProgramDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclList!=null) ProgramDeclList.traverseBottomUp(visitor);
        if(ProgramDecl!=null) ProgramDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclListDerived1(\n");

        if(ProgramDeclList!=null)
            buffer.append(ProgramDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgramDecl!=null)
            buffer.append(ProgramDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclListDerived1]");
        return buffer.toString();
    }
}
