// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class ExprPara extends Expr_Para {

    private Add_op Add_op;
    private Term Term;
    private Expr_Para Expr_Para;

    public ExprPara (Add_op Add_op, Term Term, Expr_Para Expr_Para) {
        this.Add_op=Add_op;
        if(Add_op!=null) Add_op.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.Expr_Para=Expr_Para;
        if(Expr_Para!=null) Expr_Para.setParent(this);
    }

    public Add_op getAdd_op() {
        return Add_op;
    }

    public void setAdd_op(Add_op Add_op) {
        this.Add_op=Add_op;
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
        if(Add_op!=null) Add_op.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(Expr_Para!=null) Expr_Para.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Add_op!=null) Add_op.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(Expr_Para!=null) Expr_Para.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Add_op!=null) Add_op.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(Expr_Para!=null) Expr_Para.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprPara(\n");

        if(Add_op!=null)
            buffer.append(Add_op.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [ExprPara]");
        return buffer.toString();
    }
}
