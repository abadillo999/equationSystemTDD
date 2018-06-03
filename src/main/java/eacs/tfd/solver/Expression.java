package eacs.tfd.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Expression {

	private List<Term> termList;

	public Expression() {
		this.termList = new ArrayList<Term>();
	}

	private boolean empty() {
		return this.termList.size() == 0;
	}

	public void add(Term term) {
		assert term != null;
		this.termList.add(term.clon());
	}

	public void add(Expression expression) {
		assert expression != null;
		for (Term term : expression.termList) {
			this.add(term.clon());
		}
	}

	public void multiply(int value) {
		for (Term term : termList) {
			term.multiply(value);
		}
	}

	public void multiply(Fraction fraction) {
		for (Term term : termList) {
			term.multiply(fraction);
		}
	}

	public void simplify(String name) {
		Expression expresion = new Expression();
		Variable value = new Variable(0, name);
		for (Term term : this.termList) {
			if (term.hasName(name)) {
				value.add(term.getValue());
			} else {
				expresion.add(term.clon());
			}
		}
		if (!value.getValue().equals(new Constant(0).getValue())) {
			expresion.add(value);
		}
		this.termList = expresion.termList;
	}

	public void simplify() {
		Set<String> nameSet = this.getNameSet();
		Expression expresion = new Expression();
		Constant value = new Constant(0);
		for (Term term : termList) {
			if (term.hasName(nameSet)) {
				expresion.add(term.clon());
			} else {
				value.add(term.getValue());
			}
		}
		if (!value.equal(new Constant(0)) || expresion.termList.size() == 0) {
			expresion.add(value);
		}
		this.termList = expresion.termList;
	}

	public Fraction getValue(String name) {
		assert this.getNameSet().contains(name);
		for (Term term : termList) {
			if (term.hasName(name)) {
				return term.getValue();
			}
		}
		return new Fraction(0, 0);
	}

	public Fraction getValue() {
		assert !this.empty();
		Set<String> nameSet = this.getNameSet();
		for (Term term : termList) {
			if (!term.hasName(nameSet)) {
				return term.getValue();
			}
		}
		return new Fraction(0, 0);
	}
	

	public Set<String> getNameSet() {
		assert !this.empty();
		return new NamesExpresionAnalyzer(termList).getNameSet();
	}

	public boolean hasName(String name) {
		assert name != null && !name.equals("");
		assert !this.empty();
		for (Term term : termList) {
			if (term.hasName(name)) {
				return true;
			}
		}
		return false;
	}

	public void apply(String name, int value) {
		Fraction fraction = new Fraction(value, 1);
		this.apply(name, fraction);
	}

	public void apply(String name, Fraction fraction) {
		Expression expresion = new Expression();
		Constant constant = null;
		for (Term term : termList) {
			if (term.hasName(name)) {
				fraction.multiply(term.getValue());
				constant = new Constant(fraction);
			} else {
				expresion.add(term.clon());
			}
		}
		expresion.termList.add(constant);
		this.termList = expresion.termList;
	}

	public boolean equal(Expression expresion) {
		assert expresion != null;
		if (this == expresion)
			return true;
		if (expresion == null)
			return false;
		if (this.termList.size() != expresion.termList.size())
			return false;
		for (int i = 0; i < this.termList.size(); i++) {
			if (!this.termList.get(i).equal(expresion.termList.get(i)))
				return false;
		}
		return true;
	}

	public Expression clon() {
		assert !this.empty();
		Expression expresion = new Expression();
		for (Term term : this.termList) {
			expresion.add(term.clon());
		}
		return expresion;
	}

	@Override
	public String toString() {
		String result = "";
		for (Term term : this.termList) {
			result += term.toString();
		}
		return result;
	}

}
