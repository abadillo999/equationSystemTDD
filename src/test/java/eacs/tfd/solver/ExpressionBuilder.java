package eacs.tfd.solver;

public class ExpressionBuilder {

	private Expression expression;
	
	public ExpressionBuilder() {
		this.expression = new Expression();
	}
	
	public ExpressionBuilder term(Fraction fraction, String name){
		expression.add(new Variable(fraction, name));
		return this;
	}
	
	public ExpressionBuilder term(Fraction fraction){
		expression.add(new Constant(fraction));
		return this;
	}
	public ExpressionBuilder term(int value, String name){
		expression.add(new Variable(value, name));
		return this;
	}
	
	public ExpressionBuilder term(int value){
		expression.add(new Constant(value));
		return this;
	}
	
	public Expression build(){
		return expression;
	}
}
