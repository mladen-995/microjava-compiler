// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ExprOne extends Expr {

    private Term Term;
    private Expr_Para Expr_Para;

    public ExprOne (Term Term, Expr_Para Expr_Para) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.Expr_Para=Expr_Para;
        if(Expr_Para!=null) Expr_Para.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public Expr_Para getExpr_Para() {
        return Expr_Para;
    }

    public void setExpr_Para(Expr_Para Expr_Para) {
        this.Expr_Para=Expr_Para;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(Expr_Para!=null) Expr_Para.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(Expr_Para!=null) Expr_Para.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(Expr_Para!=null) Expr_Para.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprOne(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr_Para!=null)
            buffer.append(Expr_Para.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprOne]");
        return buffer.toString();
    }
}
