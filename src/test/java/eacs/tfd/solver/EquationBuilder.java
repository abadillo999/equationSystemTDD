package eacs.tfd.solver;

public class EquationBuilder {

	private Equation equation;
	
	private Side side;
	
	public EquationBuilder() {
		this.equation = new Equation();
		this.side = Side.LEFT;
	}
	
	public EquationBuilder term(int value, String name){
		this.equation.add(side, new Variable(value, name));
		return this;
	}
	
	public EquationBuilder term(int value){
		this.equation.add(side, new Constant(value));
		return this;
	}
	
	public EquationBuilder equals(){
		this.side = Side.RIGHT;
		return this;
	}
	
	public Equation build(){
		assert this.side == Side.RIGHT;
		return equation;
	}
}
