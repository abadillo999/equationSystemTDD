package eacs.tfd.solver;

import java.util.List;
import java.util.Set;

public abstract class Term {

	private Fraction fraction;

	protected Term(int num){
		this.fraction = new Fraction(num, 1);
	}
	
	protected Term(Fraction fraction){
		this.fraction = fraction;
	}
	
	protected Term(List<Integer> fraction){
		assert fraction.size() == 2;
		this.fraction = new Fraction(fraction.get(0), fraction.get(1));
	}

	public Fraction getValue() {
		return this.fraction;
	}

	public void add(Fraction fraction) {
		this.fraction.add(fraction);
	}
	
	public void multiply(int value) {
		this.fraction.multiply(value);
	}
	
	public void multiply(Fraction fraction) {
		this.fraction.multiply(fraction);
	}
	

	public boolean hasName(String name) {
		assert name != null;
		return false;
	}
	
	public boolean hasName(Set<String> nameSet) {
		assert nameSet != null;
		return false;
	}
	
	public boolean equal(Term term){
		assert term != null;
		return this.fraction.equals(term.fraction); 
	}
	
	public abstract Term clon();
	
	@Override
	public String toString() {
		return this.fraction.toString();
	}

	public abstract void dispatch(TermVisitor termVisitor);

}
