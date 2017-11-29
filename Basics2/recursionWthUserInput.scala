import io.StdIn._

object WithUserInput extends App {
	def sum(n: Int): Int = if (n < 1) 0 else readInt + sum(n-1)

	// println(sum(5))

	def sumPositive(): Int = {
		val input = readInt
		if(input >= 0) {
			input + sumPositive()
		}
		else 0
	}
	// println(sumPositive())

	def sumUntilQuit(): Int = {
		val input = readLine.toLowerCase.trim
		if(input == "quit") 
			0
		else input.toInt + sumUntilQuit()
	}
	// println(sumUntilQuit())

	def sumAndCount(): (Int, Int) = {
		val input = readLine.toLowerCase.trim
		if(input == "quit") 
			(0,0)
		else {
			val(sum, count) = sumAndCount()
			(input.toInt+sum, count+1)
		}	
	}
	// println(sumAndCount())
	// val (s,c) = sumAndCount()
	// println(s/c.toDouble)

	def mulAndCunt(): (Int, Int) = {
		val input = readLine.toLowerCase.trim
		if(input == "quit") 
			(1,0)
		else {
			val(mul, count) = mulAndCunt()
			(input.toInt*mul, count+1)
		}
	}
	// println(mulAndCunt())

	def inputAndCount(base: Int, op:(Int, Int) => Int): (Int, Int) = {
		val input = readLine.toLowerCase.trim
		if(input == "quit") 
			(base, 0)
		else {
			val (value, count) = inputAndCount(base, op)
			(op(input.toInt, value), count+1)
		}
	}
	// val (value1, count1) = inputAndCount(1, _*_)
	// println(value1+ " " + count1)
	// val (value2, count2) = inputAndCount(0, _+_)
	// println(value2+ " " + count2)
	// val (value3, count3) = inputAndCount(Int.MaxValue, _ min _)
	// println(value3+ " " + count3)	
	val (value4, count4) = inputAndCount(Int.MinValue, _ max _)
	println(value4+ " " + count4)	
}