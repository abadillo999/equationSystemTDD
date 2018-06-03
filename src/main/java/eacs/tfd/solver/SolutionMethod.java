package eacs.tfd.solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class SolutionMethod {

	protected List<Equation> equationList;

	protected Set<String> nameSet;

	protected Map<String, Equation> solutions;

	protected SolutionMethod() {
		this.equationList = new ArrayList<Equation>();
		this.nameSet = new HashSet<String>();
		this.solutions = new HashMap<String, Equation>();
	}

	protected void set(List<Equation> equationList) {
		for(Equation equation : equationList){
			this.equationList.add(equation.clon());
			for (String name : equation.getNameSet()) {
				this.nameSet.add(name);
			}
		}
	}

	protected void resolve(){
		assert this.nameSet.size() == 2; //TODO Verificador de todo ...
	}
	
	protected void fresolve(){
		assert this.nameSet.size() == 2; //TODO Verificador de todo ...
	}
	
	protected void copyLastEquation(int before){
		this.equationList.add(this.getLastEquation(before).clon());
	}
	
	protected Equation getLastEquation(int before){
		return this.equationList.get(this.equationList.size() - before);
	}
	
	protected void simplifyLasEquation(String[] names) {
		this.copyLastEquation(1);
		this.getLastEquation(1).simplify(Side.LEFT, names[0]);
		this.copyLastEquation(1);
		this.getLastEquation(1).simplify(Side.LEFT, names[1]);
		this.copyLastEquation(1);
		this.getLastEquation(1).simplify(Side.RIGHT);;
	}	

	protected void seStolution(String name, Equation equation) {
		assert nameSet.contains(name);
		assert equation != null;
		this.solutions.put(name, equation);
	}

	protected int getSolution(String name) {
		assert nameSet.contains(name);
		return this.solutions.get(name).getSolution();
	}
	
	protected String[] prepareNames(){
		String names[] = new String[this.nameSet.size()];
		this.nameSet.toArray(names);
		return names;
	}

}
