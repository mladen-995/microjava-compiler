// generated with ast extension for cup
// version 0.8
// 10/5/2018 12:50:18


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclDerived1 extends ConstDecl {

    private ConstType ConstType;

    public ConstDeclDerived1 (ConstType ConstType) {
        this.ConstType=ConstType;
        if(ConstType!=null) ConstType.setParent(this);
    }

    public ConstType getConstType() {
        return ConstType;
    }

    public void setConstType(ConstType ConstType) {
        this.ConstType=ConstType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstType!=null) ConstType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstType!=null) ConstType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstType!=null) ConstType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclDerived1(\n");

        if(ConstType!=null)
            buffer.append(ConstType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclDerived1]");
        return buffer.toString();
    }
}
