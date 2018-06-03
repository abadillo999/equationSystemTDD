package eacs.tfd.solver;

import java.util.List;

public class Constant extends Term {

	public Constant(int value){
		super(value);
	}
	public Constant(List<Integer> fraction){
		super(fraction);
	}
	public Constant(Fraction fraction){
		super(fraction);
	}
	
	@Override
	public boolean equal(Term term) {
		assert term != null;
		return super.equal(term) && term instanceof Constant;
	}

	@Override
	public Term clon() {
		return new Constant(this.getValue());
	}

	@Override
	public void dispatch(TermVisitor termVisitor) {
		assert termVisitor != null;
		termVisitor.visit(this);
	}
	
}
