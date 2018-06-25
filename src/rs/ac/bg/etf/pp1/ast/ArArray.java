// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ArArray extends Ar_Array {

    private Ar_Last Ar_Last;
    private Expr Expr;

    public ArArray (Ar_Last Ar_Last, Expr Expr) {
        this.Ar_Last=Ar_Last;
        if(Ar_Last!=null) Ar_Last.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public Ar_Last getAr_Last() {
        return Ar_Last;
    }

    public void setAr_Last(Ar_Last Ar_Last) {
        this.Ar_Last=Ar_Last;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Ar_Last!=null) Ar_Last.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Ar_Last!=null) Ar_Last.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Ar_Last!=null) Ar_Last.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArArray(\n");

        if(Ar_Last!=null)
            buffer.append(Ar_Last.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArArray]");
        return buffer.toString();
    }
}
