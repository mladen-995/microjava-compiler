// generated with ast extension for cup
// version 0.8
// 10/5/2018 12:50:18


package rs.ac.bg.etf.pp1.ast;

public class ConstTypeDerived2 extends ConstType {

    public ConstTypeDerived2 () {
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
        buffer.append("ConstTypeDerived2(\n");

        buffer.append(tab);
        buffer.append(") [ConstTypeDerived2]");
        return buffer.toString();
    }
}
