// generated with ast extension for cup
// version 0.8
// 24/5/2018 10:49:11


package rs.ac.bg.etf.pp1.ast;

public class FormParsList extends Form_Pars_List_Exists {

    private Form_Param Form_Param;

    public FormParsList (Form_Param Form_Param) {
        this.Form_Param=Form_Param;
        if(Form_Param!=null) Form_Param.setParent(this);
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
        if(Form_Param!=null) Form_Param.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Form_Param!=null) Form_Param.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Form_Param!=null) Form_Param.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsList(\n");

        if(Form_Param!=null)
            buffer.append(Form_Param.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsList]");
        return buffer.toString();
    }
}
