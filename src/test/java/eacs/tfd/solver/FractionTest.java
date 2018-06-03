package eacs.tfd.solver;

import static org.junit.Assert.*;

import org.junit.Test;
// toString

public class FractionTest {

	@Test
	public void multiplyTest() {
		Fraction test1 = new Fraction(2,7);
		test1.multiply(4);
		assertTrue(new Fraction(8,7).equals(test1));
		
		Fraction test2 = new Fraction(1,4);
		test2.multiply(6);
		assertTrue(new Fraction(3,2).equals(test2));
	}
	
	@Test
	public void multiplyNegativeTest() {
		Fraction test2 = new Fraction(2,7);
		test2.multiply(-4);
		assertTrue(new Fraction(-8,7).equals(test2));
	}
	
	@Test
	public void addTest(){
		Fraction test1 = new Fraction(1,3);
		test1.add(new Fraction(3,4));
		assertTrue(new Fraction(13,12).equals(test1));
		
		Fraction test2 = new Fraction(1,4);
		test2.add(new Fraction(1,4));
		assertTrue(new Fraction(1,2).equals(test2));
		
	}
	
	

	

}
