package eacs.tfd.solver;

import java.util.List;
import java.util.Set;

public class Variable extends Term {
	
	private String name;
	
	public Variable(int value, String name){
		super(value);
		assert name != null && !name.equals("");
		this.name = name;
	}
	
	public Variable(Fraction fraction, String name){
		super(fraction);
		assert name != null && !name.equals("");
		this.name = name;
	}
	
	public Variable(List<Integer> fraction, String name){
		super(fraction);
		assert name != null && !name.equals("");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean hasName(String name) {
		assert name != null;
		return this.name.equals(name);
	}
	
	@Override
	public boolean hasName(Set<String> nameSet) {
		assert nameSet != null;
		for(String name : nameSet){
			if (this.hasName(name))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean equal(Term term) {
		assert term != null;
		return super.equal(term) && term.hasName(name);
	}
	
	@Override
	public Term clon() {
		return new Variable(this.getValue(), this.name);
	}
	
	@Override
	public String toString(){
		return super.toString() + name;
	}
	
	@Override
	public void dispatch(TermVisitor termVisitor) {
		assert termVisitor != null;
		termVisitor.visit(this);
	}
	
}
