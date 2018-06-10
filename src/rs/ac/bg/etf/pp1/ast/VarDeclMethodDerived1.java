// generated with ast extension for cup
// version 0.8
// 10/5/2018 12:50:18


package rs.ac.bg.etf.pp1.ast;

public class VarDeclMethodDerived1 extends VarDeclMethod {

    private VarDeclMethod VarDeclMethod;
    private VarDeclWrapper VarDeclWrapper;

    public VarDeclMethodDerived1 (VarDeclMethod VarDeclMethod, VarDeclWrapper VarDeclWrapper) {
        this.VarDeclMethod=VarDeclMethod;
        if(VarDeclMethod!=null) VarDeclMethod.setParent(this);
        this.VarDeclWrapper=VarDeclWrapper;
        if(VarDeclWrapper!=null) VarDeclWrapper.setParent(this);
    }

    public VarDeclMethod getVarDeclMethod() {
        return VarDeclMethod;
    }

    public void setVarDeclMethod(VarDeclMethod VarDeclMethod) {
        this.VarDeclMethod=VarDeclMethod;
    }

    public VarDeclWrapper getVarDeclWrapper() {
        return VarDeclWrapper;
    }

    public void setVarDeclWrapper(VarDeclWrapper VarDeclWrapper) {
        this.VarDeclWrapper=VarDeclWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclMethod!=null) VarDeclMethod.accept(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclMethod!=null) VarDeclMethod.traverseTopDown(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclMethod!=null) VarDeclMethod.traverseBottomUp(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMethodDerived1(\n");

        if(VarDeclMethod!=null)
            buffer.append(VarDeclMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclWrapper!=null)
            buffer.append(VarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMethodDerived1]");
        return buffer.toString();
    }
}
