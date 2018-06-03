package eacs.tfd.solver;

public class ReductionMethod extends SolutionMethod {
	
	@Override
	protected void resolve() {
		super.resolve();
		String names[] = this.prepareNames();
		this.crossingMultiplyTwoLastEquations(names[0]);
		this.addTwoLastEquations(names);
		this.clearIncognitoLastEquation(names[1]);
		this.seStolution(names[1], this.getLastEquation(1));
		this.applyFirstEquationWithLastEquation(names);
		this.clearIncognitoLastEquation(names[0]);
		this.seStolution(names[0], this.getLastEquation(1));
	}
	
	private void crossingMultiplyTwoLastEquations(String name) {
		Fraction value1 = this.getLastEquation(2).getValue(name);
		Fraction value2 = this.getLastEquation(1).getValue(name);
		this.copyLastEquation(2);
		this.getLastEquation(1).multiply(value2);
		this.copyLastEquation(2);
		value1.multiply(-1);
		this.getLastEquation(1).multiply(value1);
	}

	private void addTwoLastEquations(String[] names) {
		this.copyLastEquation(1);
		this.getLastEquation(1).add(this.getLastEquation(3));
		this.simplifyLasEquation(names);
	}
	
	private void clearIncognitoLastEquation(String name) {
		this.copyLastEquation(1);
		this.getLastEquation(1).multiply(this.getLastEquation(2).getValue(name));
	}
	
	private void applyFirstEquationWithLastEquation(String[] names) {
		this.copyLastEquation(9);
		this.getLastEquation(1).apply(names[1], this.getLastEquation(2).getValue(Side.RIGHT));
		this.copyLastEquation(1);
		this.getLastEquation(2).multiply(-1);
		this.getLastEquation(1).add(new Constant(this.getLastEquation(2).getValue(Side.LEFT)));
		this.copyLastEquation(1);
		this.getLastEquation(1).simplify(Side.LEFT);
		this.copyLastEquation(1);
		this.getLastEquation(1).simplify(Side.RIGHT);
	}	

}
