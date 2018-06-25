// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class FormParsListArray extends Form_Pars_List_Exists {

    private Form_Pars_List_Exists Form_Pars_List_Exists;
    private Form_Param Form_Param;

    public FormParsListArray (Form_Pars_List_Exists Form_Pars_List_Exists, Form_Param Form_Param) {
        this.Form_Pars_List_Exists=Form_Pars_List_Exists;
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.setParent(this);
        this.Form_Param=Form_Param;
        if(Form_Param!=null) Form_Param.setParent(this);
    }

    public Form_Pars_List_Exists getForm_Pars_List_Exists() {
        return Form_Pars_List_Exists;
    }

    public void setForm_Pars_List_Exists(Form_Pars_List_Exists Form_Pars_List_Exists) {
        this.Form_Pars_List_Exists=Form_Pars_List_Exists;
    }

    public Form_Param getForm_Param() {
        return Form_Param;
    }

    public void setForm_Param(Form_Param Form_Param) {
        this.Form_Param=Form_Param;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.accept(visitor);
        if(Form_Param!=null) Form_Param.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.traverseTopDown(visitor);
        if(Form_Param!=null) Form_Param.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.traverseBottomUp(visitor);
        if(Form_Param!=null) Form_Param.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsListArray(\n");

        if(Form_Pars_List_Exists!=null)
            buffer.append(Form_Pars_List_Exists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Form_Param!=null)
            buffer.append(Form_Param.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsListArray]");
        return buffer.toString();
    }
}
