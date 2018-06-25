// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignatorMeth extends Factor {

    private Designator_Call_Method Designator_Call_Method;

    public FactorDesignatorMeth (Designator_Call_Method Designator_Call_Method) {
        this.Designator_Call_Method=Designator_Call_Method;
        if(Designator_Call_Method!=null) Designator_Call_Method.setParent(this);
    }

    public Designator_Call_Method getDesignator_Call_Method() {
        return Designator_Call_Method;
    }

    public void setDesignator_Call_Method(Designator_Call_Method Designator_Call_Method) {
        this.Designator_Call_Method=Designator_Call_Method;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator_Call_Method!=null) Designator_Call_Method.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator_Call_Method!=null) Designator_Call_Method.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator_Call_Method!=null) Designator_Call_Method.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignatorMeth(\n");

        if(Designator_Call_Method!=null)
            buffer.append(Designator_Call_Method.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignatorMeth]");
        return buffer.toString();
    }
}
