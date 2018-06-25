// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl extends Method_Decl {

    private Method_Name Method_Name;
    private Form_Pars_List Form_Pars_List;
    private Var_Decl_Method Var_Decl_Method;
    private Statement_List Statement_List;

    public MethodDecl (Method_Name Method_Name, Form_Pars_List Form_Pars_List, Var_Decl_Method Var_Decl_Method, Statement_List Statement_List) {
        this.Method_Name=Method_Name;
        if(Method_Name!=null) Method_Name.setParent(this);
        this.Form_Pars_List=Form_Pars_List;
        if(Form_Pars_List!=null) Form_Pars_List.setParent(this);
        this.Var_Decl_Method=Var_Decl_Method;
        if(Var_Decl_Method!=null) Var_Decl_Method.setParent(this);
        this.Statement_List=Statement_List;
        if(Statement_List!=null) Statement_List.setParent(this);
    }

    public Method_Name getMethod_Name() {
        return Method_Name;
    }

    public void setMethod_Name(Method_Name Method_Name) {
        this.Method_Name=Method_Name;
    }

    public Form_Pars_List getForm_Pars_List() {
        return Form_Pars_List;
    }

    public void setForm_Pars_List(Form_Pars_List Form_Pars_List) {
        this.Form_Pars_List=Form_Pars_List;
    }

    public Var_Decl_Method getVar_Decl_Method() {
        return Var_Decl_Method;
    }

    public void setVar_Decl_Method(Var_Decl_Method Var_Decl_Method) {
        this.Var_Decl_Method=Var_Decl_Method;
    }

    public Statement_List getStatement_List() {
        return Statement_List;
    }

    public void setStatement_List(Statement_List Statement_List) {
        this.Statement_List=Statement_List;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Method_Name!=null) Method_Name.accept(visitor);
        if(Form_Pars_List!=null) Form_Pars_List.accept(visitor);
        if(Var_Decl_Method!=null) Var_Decl_Method.accept(visitor);
        if(Statement_List!=null) Statement_List.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Method_Name!=null) Method_Name.traverseTopDown(visitor);
        if(Form_Pars_List!=null) Form_Pars_List.traverseTopDown(visitor);
        if(Var_Decl_Method!=null) Var_Decl_Method.traverseTopDown(visitor);
        if(Statement_List!=null) Statement_List.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Method_Name!=null) Method_Name.traverseBottomUp(visitor);
        if(Form_Pars_List!=null) Form_Pars_List.traverseBottomUp(visitor);
        if(Var_Decl_Method!=null) Var_Decl_Method.traverseBottomUp(visitor);
        if(Statement_List!=null) Statement_List.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(Method_Name!=null)
            buffer.append(Method_Name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Form_Pars_List!=null)
            buffer.append(Form_Pars_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Var_Decl_Method!=null)
            buffer.append(Var_Decl_Method.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement_List!=null)
            buffer.append(Statement_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
