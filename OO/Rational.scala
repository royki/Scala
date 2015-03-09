class Rational(val numer: Int, val denom: Int) { 
// here class Rational is immutable type as the data are declared as val	
// To make the argument visible outside of the class 
//we need to make the argument type as var or val
	def display {
		println(numer+"/"+denom)
	}

	def multiply(r: Rational): Rational = {
		new Rational(numer*r.numer, denom*r.denom)
	}
}

val r1 = new Rational(2,3)
val r2 = new Rational(4,5)

r1.multiply(r2).display
