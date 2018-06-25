// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclList extends Program_Decl_List {

    private Program_Decl_List Program_Decl_List;
    private Program_Decl Program_Decl;

    public ProgramDeclList (Program_Decl_List Program_Decl_List, Program_Decl Program_Decl) {
        this.Program_Decl_List=Program_Decl_List;
        if(Program_Decl_List!=null) Program_Decl_List.setParent(this);
        this.Program_Decl=Program_Decl;
        if(Program_Decl!=null) Program_Decl.setParent(this);
    }

    public Program_Decl_List getProgram_Decl_List() {
        return Program_Decl_List;
    }

    public void setProgram_Decl_List(Program_Decl_List Program_Decl_List) {
        this.Program_Decl_List=Program_Decl_List;
    }

    public Program_Decl getProgram_Decl() {
        return Program_Decl;
    }

    public void setProgram_Decl(Program_Decl Program_Decl) {
        this.Program_Decl=Program_Decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Program_Decl_List!=null) Program_Decl_List.accept(visitor);
        if(Program_Decl!=null) Program_Decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Program_Decl_List!=null) Program_Decl_List.traverseTopDown(visitor);
        if(Program_Decl!=null) Program_Decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Program_Decl_List!=null) Program_Decl_List.traverseBottomUp(visitor);
        if(Program_Decl!=null) Program_Decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclList(\n");

        if(Program_Decl_List!=null)
            buffer.append(Program_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Program_Decl!=null)
            buffer.append(Program_Decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclList]");
        return buffer.toString();
    }
}
