package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

import org.apache.log4j.Logger;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class Compiler {

	public static void main(String[] args) throws Exception {
		
		
		Logger log = Logger.getLogger(SemanticAnalyzer.class);
		if (args.length < 2) {
			log.error("Not enough arguments supplied! Usage: MJParser <source-file> <obj-file> ");
			return;
		}
		Reader br = null;
		final Struct boolType = new Struct(5);
		try {
			
			File sourceCode = new File(args[0]);
			if (! sourceCode.exists()) {
				log.info("File doesnt exists: " + sourceCode.getAbsolutePath());
				return;
			}
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			
			Yylex lexer = new Yylex(br);
			MJParser p = new MJParser(lexer);
			Symbol currToken = p.parse();
			
			SyntaxNode prog = (SyntaxNode) (currToken.value);
			//if(!p.errorDetected) {
				//log.info(prog.toString());
			
				Program pp=(Program)(currToken.value);
		        System.out.println("========================Ispis sintaksnog stabla=========================");
		        System.out.println(pp.toString(""));
	
				//Tab.dump();
		        System.out.println("========================Semanticka analiza===========================");
				SemanticAnalyzer semanticCheck = new SemanticAnalyzer();
				prog.traverseBottomUp(semanticCheck);
				Tab.dump();
				
				/*Collection<Obj> oo = Tab.find("MJProgram").getLocalSymbols();
				for(Obj o: oo)
					System.out.println(o.getName());*/
				//System.out.println(Tab.find("proba").getLevel());
				
				if (! semanticCheck.isErrorDetected()) {
					File objFile = new File(args[1]);
					log.info("Generisanje bajtkod fajla: " + objFile.getAbsolutePath());
					if (objFile.exists())
						objFile.delete();
					CodeGenerator codeGenerator = new CodeGenerator();
					prog.traverseBottomUp(codeGenerator);
					Code.dataSize = semanticCheck.nVars;
					Code.mainPc = codeGenerator.getMainPc();
					Code.write(new FileOutputStream(objFile));
					
					/*System.out.println(Code.dataSize);
					System.out.println(Code.mainPc);
					System.out.println(Code.pc);*/
					
					log.info("Parsiranje uspesno zavrseno!");
					
				}
				else
					log.info("Parsiranje nije uspesno zavrseno!");
			//}
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}

}
