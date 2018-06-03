package eacs.tfd.solver;

public class Fraction {

	private int num;

	private int den;

	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public void add(Fraction fraction) {
		final int num = this.num * fraction.den + fraction.num * this.den;
		final int den = this.den * fraction.den;
		Fraction result = new Fraction(num, den);
		if (!(result.num == 0 || result.den == 0)) {
			result.simplify();
		}
		this.num = result.num;
		this.den = result.den;
	}

	public void multiply(int value) {
		Fraction fraction = new Fraction(value, 1);
		this.multiply(fraction);
	}

	public void multiply(Fraction fraction) {
		Fraction result = new Fraction(fraction.num * this.num, fraction.den * this.den);
		if (!(result.num == 0 || result.den == 0)) {
			result.simplify();
		}
		this.num = result.num;
		this.den = result.den;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + den;
		result = prime * result + num;
		return result;
	}

	public boolean equals(Fraction obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (den != other.den)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	private void simplify() {
		// ecluides's alg
		int a = Math.abs(num);
		int b = Math.abs(den);
		while (b != 0) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		this.num /= a;
		this.den /= a;
	}

	@Override
	public String toString() {
		return "(" + this.num + "/" + this.den + ")";
	}

	public Fraction getValue() {
		return this;
	}
	
	public int getintValue() {
		return this.num / this.den;
	}


}
