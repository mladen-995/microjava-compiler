// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class FormPars extends Form_Pars_List {

    private Form_Pars_List_Exists Form_Pars_List_Exists;

    public FormPars (Form_Pars_List_Exists Form_Pars_List_Exists) {
        this.Form_Pars_List_Exists=Form_Pars_List_Exists;
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.setParent(this);
    }

    public Form_Pars_List_Exists getForm_Pars_List_Exists() {
        return Form_Pars_List_Exists;
    }

    public void setForm_Pars_List_Exists(Form_Pars_List_Exists Form_Pars_List_Exists) {
        this.Form_Pars_List_Exists=Form_Pars_List_Exists;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Form_Pars_List_Exists!=null) Form_Pars_List_Exists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPars(\n");

        if(Form_Pars_List_Exists!=null)
            buffer.append(Form_Pars_List_Exists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars]");
        return buffer.toString();
    }
}
