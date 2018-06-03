package eacs.tfd.solver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Equation {

	private Map<Side, Expression> members;

	public Equation() {
		this(new Expression[]{new Expression(), new Expression()});
	}

	Equation(Expression[] expresions){
		this.members = new HashMap<Side, Expression>();
		int i=0;
		for(Side side : Side.values()) {
			this.members.put(side, expresions[i++]);
		}
	}
	
	public void add(Side side, Term term) {
		this.getExpression(side).add(term.clon());		
	}
	
	public void add(Term term){
		for(Expression expresion : this.members.values()){
			expresion.add(term);
		}
	}
	
	public void add(Equation equation){
		for(Side side : Side.values()){
			this.getExpression(side).add(equation.members.get(side));
		}
	}
	
	protected Expression getExpression(Side side){
		return this.members.get(side);
	}
	
	public void multiply(int value){
		for(Expression expresion : members.values()){
			expresion.multiply(value);
		}
	}
	
	public void multiply(Fraction value){
		for(Expression expresion : members.values()){
			expresion.multiply(value);
		}
	}
	
	
	public Fraction getValue(String name) {
		for(Expression expresion : members.values()){
			if (expresion.hasName(name)){
				return expresion.getValue(name);
			}
		}
		return new Fraction(0,0);
	}
	
	public Fraction getValue(Side side) {
		return this.getExpression(side).getValue();
	}
	
	public int getSolution() {
		return this.getExpression(Side.RIGHT).getValue().getintValue();
	}
	
	public void simplify(Side side, String name){
		this.getExpression(side).simplify(name);
	}
	
	public void simplify(Side side) {
		this.getExpression(side).simplify();		
	}
	
	public Set<String> getNameSet() {
		Set<String> nameSet = new HashSet<String>();
		for(Expression expresion : members.values()){
			for(String name : expresion.getNameSet()){
				nameSet.add(name);
			}
		}
		return nameSet;
	}	
	
	public boolean equal(Equation equation) {
		if (this == equation)
			return true;
		if (equation == null)
			return false;
		for(Side side : Side.values()){
			if (!this.getExpression(side).equal(equation.getExpression(side)))
				return false;
		}
		return true;
	}
	
	public Equation clon() {
		return new Equation(new Expression[]{
				this.getExpression(Side.LEFT).clon(),
				this.getExpression(Side.RIGHT).clon()				
		});
	}
	
	@Override
	public String toString(){
		return members.get(Side.LEFT) + " =" + members.get(Side.RIGHT) + "\n";
	}


	
	public void apply(String name, int value) {
		for(Side side : Side.values()){
			if (members.get(side).hasName(name)){
				members.get(side).apply(name, value);
			}
		}
	}
	
	public void apply(String name, Fraction fraction) {
		for(Side side : Side.values()){
			if (members.get(side).hasName(name)){
				members.get(side).apply(name, fraction);
			}
		}
	}

	public void invert() {
		Equation equation = new Equation(new Expression[]{
								this.members.get(Side.RIGHT),
								this.members.get(Side.LEFT)
							});
		this.members = equation.members;
	}





}
