object Recursion extends App {

	/*def main(args: Array[String]): Unit = {
		println("Hello World")
	}*/

	println("Hello World")
	println("-" * 30)

	/*def fibonacci(n: Int):Int = {
		var iterations = 0

		def loop(x: Int): Int = {
			iterations += 1

			if(x == 0)
			0
			else if(x == 1)
			1
			else
			loop(x - 1) + loop(x - 2)
		}
		val result = loop(n)
		println("Iterations: "+ iterations)
		result
	}*/

	/*def fibonacci(n: Int):Int = {
		var iterations = 0

		@scala.annotation.tailrec
		def loop(x: Int, accu1: Int, accu2: Int): Int = {

			iterations += 1
			if(x == 0)
			accu1
			else if(x == 1)
			accu2
			else
			loop(x = x - 1, accu1=accu2, accu2 = accu1 + accu2)
		}
		val result = loop(n, 0, 1)
		println("Iterations: "+ iterations)
		result
	}

	println("0 => "+ fibonacci(0))
	println("1 => "+ fibonacci(1))
	println("2 => "+ fibonacci(2))
	println("3 => "+ fibonacci(3))
	println("4 => "+ fibonacci(4))
	println("5 => "+ fibonacci(5))
	println("6 => "+ fibonacci(6))
	println("7 => "+ fibonacci(7))
	println("8 => "+ fibonacci(8))
	println("50 => "+ fibonacci(50))*/


	/*def factorial(n: Int): Int = {
		var iterations = 0

		def loop(x: Int): Int = {
			iterations += 1
			if(x == 0)
			1
			else
			x * loop(x - 1)
		}
		println("Iterations: "+ iterations)
		loop(n)
	}*/

	def factorial(n: Int): Int = {

		var iterations = 0
		@scala.annotation.tailrec
		def loop(x: Int, accu: Int): Int = {
			iterations += 1
			if(x == 0)
				accu
			else
				loop(x - 1, accu * x)
		}
		val result = loop(n, 1)
		println("Iterations: "+ iterations)
		result
	}

	println("0 => "+ factorial(0))
	println("1 => "+ factorial(1))
	println("2 => "+ factorial(2))
	println("3 => "+ factorial(3))
	println("4 => "+ factorial(4))
	println("5 => "+ factorial(5))
	println("6 => "+ factorial(6))
	println("7 => "+ factorial(7))
	println("8 => "+ factorial(8))
	// println("50 => "+ factorial(50))

	println("-" * 30)
}