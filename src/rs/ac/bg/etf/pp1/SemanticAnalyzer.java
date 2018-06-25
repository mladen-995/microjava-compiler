package rs.ac.bg.etf.pp1;

import java.util.Collection;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	int nGlobals;
	final int maxVars = 65536;
	final int maxGlobals = 65536;
	Struct currentType = Tab.noType;
	Obj currentConstant;
	Struct methodType;
	boolean hasMain = false;
	String currentMethodName;
	int formParsNo;
	int actParsNo;
	boolean allocateArray = false;
	
	Struct boolType;

	Logger log = Logger.getLogger(getClass());
	
	public SemanticAnalyzer() {
		Tab.init();
		boolType = new Struct(5);
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public boolean isErrorDetected() {
		return errorDetected;
	}

	
	//---------------------------------------------------------------------
	
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProg_Name().obj);
		Tab.closeScope();
		if (! hasMain)
			report_error("Ne postoji funkcija main", null);
	}
	
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
		Tab.openScope();
	}
	
	
	public void visit(VarDecl var) {
		Obj o = Tab.currentScope().findSymbol(var.getI1());
		if (o != null)
			report_error("Promenljiva " + var.getI1() + " je vec deklarisana u opsegu", var);
		else if (currentType != Tab.noType) {
			Obj node = Tab.insert(Obj.Var, var.getI1(), currentType);
			
			nVars++;
			if (nVars > maxVars)
				report_error("Broj lokalnih promeljivih je prekoracen", null);
		}
	}
	
	
	public void visit(VarDeclArray var) {
		Obj o = Tab.currentScope().findSymbol(var.getI1());
		if (o != null)
			report_error("Promenljiva " + var.getI1() + " je vec deklarisana u opsegu", var);
		else {
			Obj node = Tab.insert(Obj.Var, var.getI1(), new Struct(Struct.Array, currentType));
			nVars++;
			if (nVars > maxVars)
				report_error("Broj lokalnih promeljivih je prekoracen", null);
		}
	}
	
	public void visit(Type type) {
		Obj o_type = Tab.find(type.getTypeName());
		if (o_type == Tab.noObj) {
			report_error("Tip " + type.getTypeName() + " nije pronadjen", type);
			type.struct = Tab.noType;
			currentType = Tab.noType;
		}
		else {
			if (o_type.getKind() == Obj.Type) {
				type.struct = o_type.getType();
				currentType = o_type.getType();
			}
			else {
				report_error("Ime "+o_type.getKind()+Obj.Type + type.getTypeName() + " ne predstavlja tip", type);
				type.struct = Tab.noType;
			}
		}
	}
	
	
	public void visit(ConstTypeNumber const_number) {
		if (currentConstant != null) {
			if (currentConstant.getType().getKind() == Struct.Int)
				currentConstant.setAdr(const_number.getN1());
			else
				report_error("Greska pri dodeli vrednosti. Vrednost globalne promeljive " + currentConstant.getName() + " nije odgovarajuceg tipa", const_number);
		}
		currentConstant = null;
	}
	
	public void visit(ConstTypeChar const_char) {
		if (currentConstant.getType().getKind() == Struct.Char)
			currentConstant.setAdr(const_char.getC1());
		else
			report_error("Greska pri dodeli vrednosti. Vrednost globalne promeljive " + currentConstant.getName() + " nije odgovarajuceg tipa", const_char);
		currentConstant = null;
	}

	public void visit(ConstTypeBoolean const_bool) {
		if (currentConstant.getType().getKind() == 5 ) {
			if (const_bool.getB1().equals("true"))
				currentConstant.setAdr(1);
			else
				currentConstant.setAdr(0);
		}
		else
			report_error("Greska pri dodeli vrednosti. Vrednost globalne promeljive " + currentConstant.getName() + " nije odgovarajuceg tipa", const_bool);
		
		currentConstant = null;
	}
	
	
	public void visit(ConstDecl const_decl) {
		//currentType = Tab.noType;
	}
	
	public void visit(ConstName const_name) {
		Obj o_type = Tab.find(const_name.getI1());
		if (o_type != Tab.noObj)
			report_error("Globalna promeljiva " + const_name.getI1() + " je vec deklarisana u opsegu", const_name);
		else {
			currentConstant = Tab.insert(Obj.Con, const_name.getI1(), currentType);
			nGlobals++;
			if (nGlobals > maxGlobals)
				report_error("Broj globalnih promeljivih je prekoracen", null);
			
		}
	}
	
	
	public void visit(ConstDeclWrapper const_wrapper) {
		currentType = Tab.noType;
	}
	
	
	public void visit(MethodDecl methodDecl) {
		Obj o = methodDecl.getMethod_Name().obj;
		
		if (o != Tab.noObj) {
			Tab.chainLocalSymbols(methodDecl.getMethod_Name().obj);
			Tab.closeScope();
			if (! returnFound && methodType != Tab.noType)
				report_error("Metoda " + methodDecl.getMethod_Name().obj.getName() + " ocekuje povratni rezultat", methodDecl);
			returnFound = false;
			
			o.setLevel(formParsNo);
		}
		else {
			report_error("Metoda nema ime", methodDecl);
		}
	}
	
	
	public void visit(MethodName methodName) {
		
		Obj o = Tab.find(methodName.getI2());
		if (o != Tab.noObj) {
			report_error("Metoda " + methodName.getI2() + " je vec deklarisana", methodName);
			methodName.obj = Tab.noObj;
		}
		else {
			methodName.obj = Tab.insert(Obj.Meth, methodName.getI2(), methodType);
			Tab.openScope(); 
			currentMethod = methodName.obj;
			formParsNo = 0;
			if (methodName.getI2().equals("main"))
				hasMain = true;
		}
	}
	
	
	public void visit(MethodReturnTypeVoid methodReturnType) {
		methodType = Tab.noType;
	}
	
	public void visit(MethodReturnType methodReturnType) {
		methodType = methodReturnType.getType().struct;
	}
	
	
	public void visit(StatementReturn statementReturn) {
		if (currentMethod.getType() != Tab.noType)
			report_error("Metoda ne treba da vrati nikakav rezultat", null);
	}
	
	public void visit(StatementReturnExpr statementReturn) {
		returnFound = true;
		if (statementReturn.getExpr().struct.getKind() != currentMethod.getType().getKind())
			report_error("Metoda ne vraca odgovarajuci tip", statementReturn);
			
	}
	
	public void visit(FormParam pars) {
		formParsNo++;
	}
	
	

	
	
	public void visit(DesignatorIdent designatorIdent) {
		Obj o = Tab.find(designatorIdent.getI1());
		if (o == Tab.noObj) {
			report_error("Designator " + designatorIdent.getI1() + " nije deklarisana", designatorIdent);
			designatorIdent.obj = Tab.noObj;
		}
		else
			designatorIdent.obj = o;
		
		if (o.getType().getKind() == Struct.Array)
			allocateArray = true;
	}
	
	
	public void visit(TermOne termOne) {
		
		if (termOne.getFactor().struct.getKind() == Struct.Array) {
			if (termOne.getFactor().struct.getElemType().getKind() == Struct.Int
					|| termOne.getFactor().struct.getElemType().getKind() == Struct.Int
					|| termOne.getFactor().struct.getElemType().getKind() == Struct.Char
					|| termOne.getFactor().struct.getElemType().getKind() == 5)
				termOne.struct = termOne.getFactor().struct;
			
			else {
				report_error("Term1 i factor nisu istog tipa", termOne);
				termOne.struct = Tab.noType;
			}
				
		}
		else if (termOne.getFactor().struct.getKind() == Struct.Int
				|| termOne.getFactor().struct.getKind() == Struct.Char
				|| termOne.getFactor().struct.getKind() == 5)
			termOne.struct = termOne.getFactor().struct;
		
		else {
			report_error("Term2 i factor nisu istog tipa", termOne);
			termOne.struct = Tab.noType;
		}
	}
	
	public void visit(TermAdd term) {
		if (term.getTerm().struct.getKind() == Struct.Array ) {
			if (term.getTerm().struct.getElemType().getKind() != Struct.Int ) {
				report_error("Aritmeticke operacije se mogu izvrsavati samo nad int podacima", term);
				term.struct = Tab.noType;
			}
		}
		else if (term.getTerm().struct.getKind() != Struct.Int ) {
			report_error("Aritmeticke operacije se mogu izvrsavati samo nad int podacima", term);
			term.struct = Tab.noType;
		}
			
			
		else if (term.getFactor().struct.getKind() == Struct.Array) {
			if (term.getFactor().struct.getElemType().getKind() != Struct.Int) {
				report_error("Aritmeticke operacije se mogu izvrsavati samo nad int podacima", term);
				term.struct = Tab.noType;
			}
			else
				term.struct = term.getFactor().struct.getElemType();
		}
		else if (term.getFactor().struct.getKind() != Struct.Int) {
			report_error("Aritmeticke operacije se mogu izvrsavati samo nad int podacima", term);
			term.struct = Tab.noType;
		}
		
		else {
			term.struct = term.getFactor().struct;
		}
		
		
	}
	
	
	public void visit(ExprOne exprOne) {
		if (exprOne.getTerm().struct != Tab.noType) {
			if (exprOne.getTerm().struct.getKind() == Struct.Array
					|| exprOne.getTerm().struct.getKind() == Struct.Int
					|| exprOne.getTerm().struct.getKind() == Struct.Char
					|| exprOne.getTerm().struct.getKind() == 5)
				exprOne.struct = exprOne.getTerm().struct;
			
			else {
				report_error("Term i factor nisu istog tipa", exprOne);
				exprOne.struct = Tab.noType;
			}
		}
		else
			exprOne.struct = Tab.noType;
	}
	
	public void visit(ExprPara exprOne) {
		/*if (((ExprOne)exprOne.getParent()).getTerm().struct.getKind() != Struct.Int)
			report_error("Aritmeticke operacije se mogu izvrsavati samo nad int podacima", exprOne);
		else*/ if (exprOne.getTerm().struct.getKind() == Struct.Array) {
			if (exprOne.getTerm().struct.getElemType().getKind() != Struct.Int)
				report_error("Aritmeticke operacije se mogu izvrsavati samo nad int podacima", exprOne);
		}
		else if (exprOne.getTerm().struct.getKind() != Struct.Int)
			report_error("Aritmeticke operacije se mogu izvrsavati samo nad int podacima", exprOne);

	}
	
	public void visit(Const const_n) {
		const_n.struct = Tab.intType;
	}
	
	public void visit(Char char_c) {
		char_c.struct = Tab.charType;
	}
	
	public void visit(Bool bool_b) {
		bool_b.struct = boolType;
	}
	
	
	public void visit(DesignatorStatementEqual des) {
		if (des.getDesignator().obj.getType().getKind() == Struct.Array && ! allocateArray) {
			if (des.getDesignator().obj.getType().getElemType().getKind() != des.getExpr().struct.getKind())
				report_error("Tipovi pri dodeli vrednosti moraju biti isti", des);
		}
		else if (des.getDesignator().obj.getType().getKind() != des.getExpr().struct.getKind()) {
			report_error("Tipovi pri dodeli vrednosti moraju biti isti", des);
		}
		
		
		allocateArray = false;
	}
	
	public void visit(DesignatorStatementInc des) {
		if (des.getDesignator().obj.getType() != Tab.noType) {
			if (des.getDesignator().obj.getKind() != Obj.Var || des.getDesignator().obj.getType().getKind() != Struct.Int)
				report_error("Designator " + des.getDesignator().obj.getName() + " mora biti tipa int", des);
		}
		else
			report_error("Designator " + des.getDesignator().obj.getName() + " mora biti tipa int", des);
	}
	
	public void visit(DesignatorStatementDec des) {
		if (des.getDesignator().obj.getType() != Tab.noType) {
			if (des.getDesignator().obj.getKind() != Obj.Var || des.getDesignator().obj.getType().getKind() != Struct.Int)
				report_error("Designator " + des.getDesignator().obj.getName() + " mora biti tipa int", des);
		}
		else
			report_error("Designator " + des.getDesignator().obj.getName() + " mora biti tipa int", des);
	}
	
	public void visit(ExprParen expr) {
		expr.struct = expr.getExpr().struct;
	}
	
	public void visit(NewTypeBrace expr) {
		if (expr.getExpr().struct.getKind() == Struct.Int) {
			expr.struct = new Struct(Struct.Array, new Struct(expr.getType().struct.getKind()));
		}
		else {
			report_error("Pri korisnjenju operatora new, tip mora biti int", expr);
			expr.struct = new Struct(Struct.None);
		}
	}
	
	
	public void visit(StatementRead read) {
		if (read.getDesignator().obj != Tab.noObj) {
			if (! (read.getDesignator().obj.getKind() != Obj.Meth 
					|| read.getDesignator().obj.getType().getKind() == Struct.Int
					|| read.getDesignator().obj.getType().getKind() == Struct.Char
					|| read.getDesignator().obj.getType().getKind() == 5))
				report_error("Deisgnator u read funkciji mora biti promenljiva", read);
		}
		else
			report_error("Deisgnator u read funkciji mora biti deklarisan", read);
	}
	
	public void visit(StatementPrint print) {
		// ako je niz
		if (print.getExpr().struct.getKind() == Struct.Array) {
			if (! (print.getExpr().struct.getElemType().getKind() == Struct.Int
					|| print.getExpr().struct.getElemType().getKind() == Struct.Char
					|| print.getExpr().struct.getElemType().getKind() == 5))
				report_error("Deisgnator u print funkciji nije isrpavan", print);
		}
		// obicna promeljiva
		else if (! (print.getExpr().struct.getKind() == Struct.Int || print.getExpr().struct.getKind() == Struct.Char || print.getExpr().struct.getKind() == 5)) {
				report_error("Deisgnator u print funkciji nije isrpavan", print);
		}

	}
	
	public void visit(StatementDesignatorParent callMethod) {
		/*if (callMethod.getDesignator().obj != Tab.noObj) {
			Obj o = Tab.find(callMethod.getDesignator().obj.getName());
			if (o != Tab.noObj) {
				if (o.getKind() != Obj.Meth) {
					report_error("Metoda " + callMethod.getDesignator().obj.getName() + " ne predstavlja funkciju", callMethod);
				}
			}
			else {
				report_error("Metoda " + callMethod.getDesignator().obj.getName() + " nije deklarisana", callMethod);
			}
		}
		else {
			report_error("Metoda nije deklarisana", callMethod);
		}*/

	}
	
	
	public void visit(StatementDesignatorParentActPars callMethod) {
		if (actParsNo < currentMethod.getLevel())
			report_error("Premalo parametara: Metoda " + currentMethod.getName() + " ocekuje " + currentMethod.getLevel() + " parametara", callMethod);
		else if (actParsNo > currentMethod.getLevel())
			report_error("Previse parametara: Metoda " + currentMethod.getName() + " ocekuje " + currentMethod.getLevel() + " parametara", callMethod);

	}
	
	/*public void visit(ActParsArray act) {
		report_info("B"+actParsNo,null);
		if (actParsNo != currentMethod.getLevel())
			report_error("Premalo parametara: Metoda " + currentMethod.getName() + " ocekuje " + currentMethod.getLevel() + " parametara", act);
	}
	
	public void visit(ActParsExpr act) {
		report_info("A"+actParsNo,null);
		if (currentMethod.getLevel() == 1) {
			if (actParsNo != currentMethod.getLevel())
				report_error("Premalo parametara: Metoda " + currentMethod.getName() + " ocekuje " + currentMethod.getLevel() + " parametara", act);
		}
	}*/
	
	public void visit(ActPar act) {
		Collection<Obj> formParams = currentMethod.getLocalSymbols();
		int i=0;
		Obj fp1 = null;
		for(Obj o: formParams) {
			if (i==actParsNo && i<currentMethod.getLevel()) {
				fp1 = o;
				break;
			}
			i++;
		}
		if (fp1 != null) {
			if (act.getExpr().struct.getKind() == Struct.Array) {
				if (fp1.getType().getKind() != act.getExpr().struct.getElemType().getKind())
					report_error("Parametar " + fp1.getName() + " mora biti odgovarajuceg tipa", act);
			}
			else if (fp1.getType().getKind() != act.getExpr().struct.getKind())
				report_error("Parametar " + fp1.getName() + " mora biti odgovarajuceg tipa", act);
			
		}
		actParsNo++;
	}
	
	public void visit(DesignatorCallMethod act) {
		report_info("Pretraga metode " + act.getDesignator().obj.getName() + " pronadjen", act);
		if (act.getDesignator().obj != Tab.noObj) {
			Obj o = Tab.find(act.getDesignator().obj.getName());
			if (o != Tab.noObj) {
				if (o.getKind() != Obj.Meth) {
					report_error("Metoda " + act.getDesignator().obj.getName() + " ne predstavlja funkciju", act);
				}
				else {
					currentMethod = o;
					actParsNo = 0;
					act.obj = act.getDesignator().obj;
					report_info("Metoda " + act.getDesignator().obj.getName() + " pronadjena", act);
				}
			}
			else {
				report_error("Metoda " + act.getDesignator().obj.getName() + " nije deklarisana", act);
			}
		}
		else {
			report_error("Metoda nije deklarisana", act);
		} 
	}
	
	
	public void visit(FactorDesignator fac) {
		if (fac.getDesignator().obj.getType().getKind() == Struct.Array)
			fac.struct = fac.getDesignator().obj.getType().getElemType();
		else
		fac.struct = fac.getDesignator().obj.getType();
	}
	
	public void visit(FactorDesignatorPars facp) {
		facp.struct = facp.getDesignator_Call_Method().obj.getType();
	}
	
	public void visit(FactorDesignatorMeth facp) {
		facp.struct = facp.getDesignator_Call_Method().obj.getType();
	}
	
	
	public void visit(DesignatorAdd des) {
		report_info("Pretraga simbola " + des.getI1(), des);
		Obj o = Tab.find(des.getI1());
		if (o == Tab.noObj) {
			report_error("Designator " + des.getI1() + " nije deklarisana", des);
			des.obj = Tab.noObj;
		}
		else {
			des.obj = o;
			report_info("Simbol " + des.getI1() + " pronadjen", des);
		}
		
		allocateArray = false;
	}
	
	public void visit(ArArray a) {
		if (a.getExpr().struct.getKind() != Struct.Int) {
			report_error("Broj indeksa u nizu  mora biti ceo broj", a);
		}
	}
	
	
	
	

}
