// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ActParsExpr extends Act_Pars {

    private Act_Par Act_Par;

    public ActParsExpr (Act_Par Act_Par) {
        this.Act_Par=Act_Par;
        if(Act_Par!=null) Act_Par.setParent(this);
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
        if(Act_Par!=null) Act_Par.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Act_Par!=null) Act_Par.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Act_Par!=null) Act_Par.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsExpr(\n");

        if(Act_Par!=null)
            buffer.append(Act_Par.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsExpr]");
        return buffer.toString();
    }
}
