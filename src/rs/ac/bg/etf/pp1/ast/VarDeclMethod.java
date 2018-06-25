// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class VarDeclMethod extends Var_Decl_Method {

    private Var_Decl_Method Var_Decl_Method;
    private Var_Decl_Wrapper Var_Decl_Wrapper;

    public VarDeclMethod (Var_Decl_Method Var_Decl_Method, Var_Decl_Wrapper Var_Decl_Wrapper) {
        this.Var_Decl_Method=Var_Decl_Method;
        if(Var_Decl_Method!=null) Var_Decl_Method.setParent(this);
        this.Var_Decl_Wrapper=Var_Decl_Wrapper;
        if(Var_Decl_Wrapper!=null) Var_Decl_Wrapper.setParent(this);
    }

    public Var_Decl_Method getVar_Decl_Method() {
        return Var_Decl_Method;
    }

    public void setVar_Decl_Method(Var_Decl_Method Var_Decl_Method) {
        this.Var_Decl_Method=Var_Decl_Method;
    }

    public Var_Decl_Wrapper getVar_Decl_Wrapper() {
        return Var_Decl_Wrapper;
    }

    public void setVar_Decl_Wrapper(Var_Decl_Wrapper Var_Decl_Wrapper) {
        this.Var_Decl_Wrapper=Var_Decl_Wrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Var_Decl_Method!=null) Var_Decl_Method.accept(visitor);
        if(Var_Decl_Wrapper!=null) Var_Decl_Wrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Var_Decl_Method!=null) Var_Decl_Method.traverseTopDown(visitor);
        if(Var_Decl_Wrapper!=null) Var_Decl_Wrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Var_Decl_Method!=null) Var_Decl_Method.traverseBottomUp(visitor);
        if(Var_Decl_Wrapper!=null) Var_Decl_Wrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMethod(\n");

        if(Var_Decl_Method!=null)
            buffer.append(Var_Decl_Method.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Var_Decl_Wrapper!=null)
            buffer.append(Var_Decl_Wrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMethod]");
        return buffer.toString();
    }
}
