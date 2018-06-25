package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	private boolean useNewOperator = false;
	private int index;
	
	
	public void visit(MethodName methodName) {
		if ("main".equalsIgnoreCase(methodName.getI2())) {
			mainPc = Code.pc;
		}
		methodName.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(methodName.obj.getLevel());
		Code.put(Tab.currentScope().getnVars());
	}
	
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(StatementReturnExpr ret) {
		
	}
	
	public int getMainPc() {
		return mainPc;
	}

	public void visit(StatementPrint print) {
		if (print.getExpr().struct.getKind() == Struct.Char) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		} else {
			Code.loadConst(5);
			Code.put(Code.print);
		}
	}
	
	public void visit(StatementRead read) {
		if (read.getDesignator().obj.getType().getKind() == Struct.Char) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(read.getDesignator().obj);
	}
	
	public void visit(Const const_n) {
		Obj o = new Obj(Obj.Con, "", Tab.intType);
		o.setAdr(const_n.getN1());
		Code.load(o);
	}
	
	public void visit(Char const_n) {
		Obj o = new Obj(Obj.Con, "", Tab.charType);
		o.setAdr(const_n.getC1());
		Code.load(o);
	}
	
	public void visit(Bool const_n) {
		Obj o = new Obj(Obj.Con, "", Tab.intType);
		if (const_n.getB1().equals("true"))
			o.setAdr(1);
		else
			o.setAdr(0);

		Code.load(o);
	}
	
	public void visit(DesignatorStatementEqual des) {
		if (des.getDesignator().obj.getType().getKind() == Struct.Array &&  useNewOperator) {
			Code.put(Code.astore);
			useNewOperator = false;
		}
		else
			Code.store(des.getDesignator().obj);
		
		
	}
	
	public void visit(FactorDesignator des) {
		if (des.getDesignator().obj.getType().getKind() == Struct.Array) {
			Code.put(Code.aload);
			useNewOperator = false;
		}
		else
			Code.load(des.getDesignator().obj);
		
		
	}
	
	
	public void visit(DesignatorStatementInc inc) {
		Code.load(inc.getDesignator().obj);
		Obj o = new Obj(Obj.Con, "", Tab.intType);
		o.setAdr(1);
		Code.load(o);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}
	
	public void visit(DesignatorStatementDec dec) {
		Code.load(dec.getDesignator().obj);
		Obj o = new Obj(Obj.Con, "", Tab.intType);
		o.setAdr(1);
		Code.load(o);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}
	
	public void visit(AddOp des) {
		des.struct = new Struct(1);
	}
	
	public void visit(SubbOp des) {
		des.struct = new Struct(2);
	}
	
	public void visit(MulOp des) {
		des.struct = new Struct(1);
	}
	
	public void visit(DivOp des) {
		des.struct = new Struct(2);
	}
	
	public void visit(PercOp des) {
		des.struct = new Struct(3);
	}
	
	public void visit(ExprPara des) {
		if (des.getAdd_op().struct.getKind() == 1)
			Code.put(Code.add);
		else if (des.getAdd_op().struct.getKind() == 2)
			Code.put(Code.sub);
	}
	
	public void visit(TermAdd des) {
		if (des.getMul_op().struct.getKind() == 1)
			Code.put(Code.mul);
		else if (des.getMul_op().struct.getKind() == 2)
			Code.put(Code.div);
		else if (des.getMul_op().struct.getKind() == 3)
			Code.put(Code.rem);
	}
	
	public void visit(StatementDesignatorParentActPars st) {
		Obj o = st.getDesignator_Call_Method().obj;
		int dest_adr = o.getAdr() - Code.pc; // racunanje relativne adrese
		
		Code.put(Code.call);
		Code.put2(dest_adr);
		
		
	}
	
	public void visit(StatementDesignatorParent st) {
		Obj o = st.getDesignator_Call_Method().obj;
		int dest_adr = o.getAdr() - Code.pc; // racunanje relativne adrese
		
		Code.put(Code.call);
		Code.put2(dest_adr);
		
		Code.put(Code.pop);
	}
	
	public void visit(FactorDesignatorPars st) {
		Obj o = st.getDesignator_Call_Method().obj;
		int dest_adr = o.getAdr() - Code.pc; // racunanje relativne adrese
		
		Code.put(Code.call);
		Code.put2(dest_adr);
		
		
	}
	
	public void visit(FactorDesignatorMeth st) {
		Obj o = st.getDesignator_Call_Method().obj;
		int dest_adr = o.getAdr() - Code.pc; // racunanje relativne adrese
		
		Code.put(Code.call);
		Code.put2(dest_adr);
		
		
	}
	
	
	public void visit(NewTypeBrace arg) {
		Code.put(Code.newarray);
		if (arg.getType().struct.getKind() == Struct.Int)
			Code.put(1);
		else
			Code.put(0);
		
		
		//Code.store(des.getDesignator().obj);
	}
	
	public void visit(ArLast des) {
		Code.load(((DesignatorAdd)des.getParent().getParent()).obj);
		
		useNewOperator = true;
	}
	
	
	
	public void visit(ExprMinus e) {
		Code.put(Code.neg);
	}

	
}
