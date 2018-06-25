// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class StatementDesignator extends Statement {

    private Designator_Statement Designator_Statement;

    public StatementDesignator (Designator_Statement Designator_Statement) {
        this.Designator_Statement=Designator_Statement;
        if(Designator_Statement!=null) Designator_Statement.setParent(this);
    }

    public Designator_Statement getDesignator_Statement() {
        return Designator_Statement;
    }

    public void setDesignator_Statement(Designator_Statement Designator_Statement) {
        this.Designator_Statement=Designator_Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator_Statement!=null) Designator_Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator_Statement!=null) Designator_Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator_Statement!=null) Designator_Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDesignator(\n");

        if(Designator_Statement!=null)
            buffer.append(Designator_Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDesignator]");
        return buffer.toString();
    }
}
