// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class DivOp extends Mul_op {

    public DivOp () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DivOp(\n");

        buffer.append(tab);
        buffer.append(") [DivOp]");
        return buffer.toString();
    }
}