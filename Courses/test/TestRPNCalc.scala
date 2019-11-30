package test

import org.junit._
import org.junit.Assert._
import adt.RPNCalc._

class TestRPNCalc {
	@Test def basicOps {
		assertEquals(5, RPNCalc("2 3 +".split(" ")), 0.0)
		assertEquals(6, RPNCalc("2 3 *".split(" ")), 0.0)
		assertEquals(6, RPNCalc("9 3 -".split(" ")), 0.0)
		assertEquals(3, RPNCalc("9 3 /".split(" ")), 0.0)
	}

	@Test def addOps {
		assertEquals(25, RPNCalc("2 3 + 5 *".split(" ")), 0.0)
		assertEquals(2, RPNCalc("2 3 * 3 /".split(" ")), 0.0)
		assertEquals(13, RPNCalc("9 3 - 7 +".split(" ")), 0.0)
		assertEquals(0, RPNCalc("9 3 / 3 -".split(" ")), 0.0)
	}
}