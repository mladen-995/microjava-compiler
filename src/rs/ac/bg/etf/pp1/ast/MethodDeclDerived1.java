// generated with ast extension for cup
// version 0.8
// 10/5/2018 12:50:18


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclDerived1 extends MethodDecl {

    private MethodReturnType MethodReturnType;
    private FormParsList FormParsList;
    private VarDeclMethod VarDeclMethod;
    private StatementList StatementList;

    public MethodDeclDerived1 (MethodReturnType MethodReturnType, FormParsList FormParsList, VarDeclMethod VarDeclMethod, StatementList StatementList) {
        this.MethodReturnType=MethodReturnType;
        if(MethodReturnType!=null) MethodReturnType.setParent(this);
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.VarDeclMethod=VarDeclMethod;
        if(VarDeclMethod!=null) VarDeclMethod.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodReturnType getMethodReturnType() {
        return MethodReturnType;
    }

    public void setMethodReturnType(MethodReturnType MethodReturnType) {
        this.MethodReturnType=MethodReturnType;
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public VarDeclMethod getVarDeclMethod() {
        return VarDeclMethod;
    }

    public void setVarDeclMethod(VarDeclMethod VarDeclMethod) {
        this.VarDeclMethod=VarDeclMethod;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.accept(visitor);
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(VarDeclMethod!=null) VarDeclMethod.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodReturnType!=null) MethodReturnType.traverseTopDown(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(VarDeclMethod!=null) VarDeclMethod.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.traverseBottomUp(visitor);
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(VarDeclMethod!=null) VarDeclMethod.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclDerived1(\n");

        if(MethodReturnType!=null)
            buffer.append(MethodReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclMethod!=null)
            buffer.append(VarDeclMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclDerived1]");
        return buffer.toString();
    }
}
