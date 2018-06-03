package eacs.tfd.solver;

import java.util.ArrayList;
import java.util.List;

public class EquationSystem {

	private List<Equation> equationList;
	
	private SolutionMethod solutionMethod;
	
	public EquationSystem(){
		this.equationList = new ArrayList<Equation>();
	}
	
	public void add(Equation equation) {
		assert equation != null;
		assert this.solutionMethod == null;
		this.equationList.add(equation);
	}
	
	public void resolve(SolutionMethod solutionMethod){
		assert solutionMethod != null;
		this.solutionMethod = solutionMethod;
		this.solutionMethod.set(equationList);
		this.solutionMethod.resolve();
	}
	
	public int getSolution(String name){
		assert name != null && !name.equals("");
		assert this.solutionMethod != null;
		return this.solutionMethod.getSolution(name);
	}
	
	protected boolean equal(EquationSystem equationSystem){
		assert equationSystem != null;
		if (this.equationList.size()!= equationSystem.equationList.size()){
			return false;
		}
		for(int i=0; i<this.equationList.size(); i++){
			if (!this.equationList.get(i).equal(equationSystem.equationList.get(i)))
				return false;
		}
		return true;
	}
	
	public String toString() {
		String result = "\n";
		for(int i=0; i<this.equationList.size(); i++){
			result += this.equationList.get(i) + "\n";
		}
		return result;
	}
	
}

