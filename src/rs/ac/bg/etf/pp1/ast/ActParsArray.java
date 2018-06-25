// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ActParsArray extends Act_Pars {

    private Act_Pars Act_Pars;
    private Act_Par Act_Par;

    public ActParsArray (Act_Pars Act_Pars, Act_Par Act_Par) {
        this.Act_Pars=Act_Pars;
        if(Act_Pars!=null) Act_Pars.setParent(this);
        this.Act_Par=Act_Par;
        if(Act_Par!=null) Act_Par.setParent(this);
    }

    public Act_Pars getAct_Pars() {
        return Act_Pars;
    }

    public void setAct_Pars(Act_Pars Act_Pars) {
        this.Act_Pars=Act_Pars;
    }

    public Act_Par getAct_Par() {
        return Act_Par;
    }

    public void setAct_Par(Act_Par Act_Par) {
        this.Act_Par=Act_Par;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Act_Pars!=null) Act_Pars.accept(visitor);
        if(Act_Par!=null) Act_Par.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Act_Pars!=null) Act_Pars.traverseTopDown(visitor);
        if(Act_Par!=null) Act_Par.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Act_Pars!=null) Act_Pars.traverseBottomUp(visitor);
        if(Act_Par!=null) Act_Par.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsArray(\n");

        if(Act_Pars!=null)
            buffer.append(Act_Pars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Act_Par!=null)
            buffer.append(Act_Par.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsArray]");
        return buffer.toString();
    }
}
