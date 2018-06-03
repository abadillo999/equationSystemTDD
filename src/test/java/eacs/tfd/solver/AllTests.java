package eacs.tfd.solver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	EquationSystemTest.class, 
	EquationTest.class,
	FractionTest.class,
	ExpressionTest.class })
public class AllTests {

}
