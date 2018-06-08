// generated with ast extension for cup
// version 0.8
// 22/3/2018 16:44:45


package rs.ac.bg.etf.pp1.ast;

public class ConstTypeDerived3 extends ConstType {

    public ConstTypeDerived3 () {
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
        buffer.append("ConstTypeDerived3(\n");

        buffer.append(tab);
        buffer.append(") [ConstTypeDerived3]");
        return buffer.toString();
    }
}
