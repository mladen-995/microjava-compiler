// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclList extends Method_Decl_List {

    private Method_Decl_List Method_Decl_List;
    private Method_Decl Method_Decl;

    public MethodDeclList (Method_Decl_List Method_Decl_List, Method_Decl Method_Decl) {
        this.Method_Decl_List=Method_Decl_List;
        if(Method_Decl_List!=null) Method_Decl_List.setParent(this);
        this.Method_Decl=Method_Decl;
        if(Method_Decl!=null) Method_Decl.setParent(this);
    }

    public Method_Decl_List getMethod_Decl_List() {
        return Method_Decl_List;
    }

    public void setMethod_Decl_List(Method_Decl_List Method_Decl_List) {
        this.Method_Decl_List=Method_Decl_List;
    }

    public Method_Decl getMethod_Decl() {
        return Method_Decl;
    }

    public void setMethod_Decl(Method_Decl Method_Decl) {
        this.Method_Decl=Method_Decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Method_Decl_List!=null) Method_Decl_List.accept(visitor);
        if(Method_Decl!=null) Method_Decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Method_Decl_List!=null) Method_Decl_List.traverseTopDown(visitor);
        if(Method_Decl!=null) Method_Decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Method_Decl_List!=null) Method_Decl_List.traverseBottomUp(visitor);
        if(Method_Decl!=null) Method_Decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclList(\n");

        if(Method_Decl_List!=null)
            buffer.append(Method_Decl_List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Method_Decl!=null)
            buffer.append(Method_Decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclList]");
        return buffer.toString();
    }
}
