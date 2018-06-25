// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private Prog_Name Prog_Name;
    private Program_Decl_List Program_Decl_List;
    private Method_Decl_List Method_Decl_List;

    public Program (Prog_Name Prog_Name, Program_Decl_List Program_Decl_List, Method_Decl_List Method_Decl_List) {
        this.Prog_Name=Prog_Name;
        if(Prog_Name!=null) Prog_Name.setParent(this);
        this.Program_Decl_List=Program_Decl_List;
        if(Program_Decl_List!=null) Program_Decl_List.setParent(this);
        this.Method_Decl_List=Method_Decl_List;
        if(Method_Decl_List!=null) Method_Decl_List.setParent(this);
    }

    public Prog_Name getProg_Name() {
        return Prog_Name;
    }

    public void setProg_Name(Prog_Name Prog_Name) {
        this.Prog_Name=Prog_Name;
    }

    public Program_Decl_List getProgram_Decl_List() {
        return Program_Decl_List;
    }

    public void setProgram_Decl_List(Program_Decl_List Program_Decl_List) {
        this.Program_Decl_List=Program_Decl_List;
    }

    public Method_Decl_List getMethod_Decl_List() {
        return Method_Decl_List;
    }

    public void setMethod_Decl_List(Method_Decl_List Method_Decl_List) {
        this.Method_Decl_List=Method_Decl_List;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Prog_Name!=null) Prog_Name.accept(visitor);
        if(Program_Decl_List!=null) Program_Decl_List.accept(visitor);
        if(Method_Decl_List!=null) Method_Decl_List.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Prog_Name!=null) Prog_Name.traverseTopDown(visitor);
        if(Program_Decl_List!=null) Program_Decl_List.traverseTopDown(visitor);
        if(Method_Decl_List!=null) Method_Decl_List.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Prog_Name!=null) Prog_Name.traverseBottomUp(visitor);
        if(Program_Decl_List!=null) Program_Decl_List.traverseBottomUp(visitor);
        if(Method_Decl_List!=null) Method_Decl_List.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(Prog_Name!=null)
            buffer.append(Prog_Name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Program_Decl_List!=null)
            buffer.append(Program_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Method_Decl_List!=null)
            buffer.append(Method_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
