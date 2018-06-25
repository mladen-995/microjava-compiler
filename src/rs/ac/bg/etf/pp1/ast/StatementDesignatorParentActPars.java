// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class StatementDesignatorParentActPars extends Designator_Statement {

    private Designator_Call_Method Designator_Call_Method;
    private Act_Pars Act_Pars;

    public StatementDesignatorParentActPars (Designator_Call_Method Designator_Call_Method, Act_Pars Act_Pars) {
        this.Designator_Call_Method=Designator_Call_Method;
        if(Designator_Call_Method!=null) Designator_Call_Method.setParent(this);
        this.Act_Pars=Act_Pars;
        if(Act_Pars!=null) Act_Pars.setParent(this);
    }

    public Designator_Call_Method getDesignator_Call_Method() {
        return Designator_Call_Method;
    }

    public void setDesignator_Call_Method(Designator_Call_Method Designator_Call_Method) {
        this.Designator_Call_Method=Designator_Call_Method;
    }

    public Act_Pars getAct_Pars() {
        return Act_Pars;
    }

    public void setAct_Pars(Act_Pars Act_Pars) {
        this.Act_Pars=Act_Pars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator_Call_Method!=null) Designator_Call_Method.accept(visitor);
        if(Act_Pars!=null) Act_Pars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator_Call_Method!=null) Designator_Call_Method.traverseTopDown(visitor);
        if(Act_Pars!=null) Act_Pars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator_Call_Method!=null) Designator_Call_Method.traverseBottomUp(visitor);
        if(Act_Pars!=null) Act_Pars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDesignatorParentActPars(\n");

        if(Designator_Call_Method!=null)
            buffer.append(Designator_Call_Method.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Act_Pars!=null)
            buffer.append(Act_Pars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDesignatorParentActPars]");
        return buffer.toString();
    }
}
