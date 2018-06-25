// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class DesignatorAdd extends Designator {

    private String I1;
    private Ar_Array Ar_Array;

    public DesignatorAdd (String I1, Ar_Array Ar_Array) {
        this.I1=I1;
        this.Ar_Array=Ar_Array;
        if(Ar_Array!=null) Ar_Array.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Ar_Array getAr_Array() {
        return Ar_Array;
    }

    public void setAr_Array(Ar_Array Ar_Array) {
        this.Ar_Array=Ar_Array;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Ar_Array!=null) Ar_Array.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Ar_Array!=null) Ar_Array.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Ar_Array!=null) Ar_Array.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAdd(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Ar_Array!=null)
            buffer.append(Ar_Array.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAdd]");
        return buffer.toString();
    }
}
