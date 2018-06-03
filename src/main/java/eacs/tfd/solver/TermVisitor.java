package eacs.tfd.solver;

public interface TermVisitor {
	
	void visit(Variable variable);
	
	void visit(Constant constant);
}
