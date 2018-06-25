// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class MethodName extends Method_Name {

    private Method_Return_Type Method_Return_Type;
    private String I2;

    public MethodName (Method_Return_Type Method_Return_Type, String I2) {
        this.Method_Return_Type=Method_Return_Type;
        if(Method_Return_Type!=null) Method_Return_Type.setParent(this);
        this.I2=I2;
    }

    public Method_Return_Type getMethod_Return_Type() {
        return Method_Return_Type;
    }

    public void setMethod_Return_Type(Method_Return_Type Method_Return_Type) {
        this.Method_Return_Type=Method_Return_Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Method_Return_Type!=null) Method_Return_Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Method_Return_Type!=null) Method_Return_Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Method_Return_Type!=null) Method_Return_Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodName(\n");

        if(Method_Return_Type!=null)
            buffer.append(Method_Return_Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodName]");
        return buffer.toString();
    }
}
