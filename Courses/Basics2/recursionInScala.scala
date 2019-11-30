object recursion extends App {

	def factorial(n: BigInt): BigInt = if(n < 2) 1 else n*factorial(n-1)

	println(factorial(5))
	println("===============")

	def fib(n: Int): Int = n match {
		case 0 | 1 => 1
		case _ => fib(n-2)+fib(n-1)
	}
	println(fib(5))
	println("===============")

	def countDown(n: Int): Unit = {		
		if(n > 0) {
			print(n)
			countDown(n-1)
		}
	}
	println(countDown(10))
	println("===============")

	def squareSum(n: BigInt): BigInt = {
		if(n < 2) 1
		else n*n + squareSum(n-1)
	}
	println(squareSum(4))
	println("===============")

	def countFromTo(from: Int, to: Int): Unit = {
		if(from <= to) {
			print(from)
			countFromTo(from+1, to)
		}
	}
	println(countFromTo(1, 10))
	println("===============")

	import annotation.tailrec
	
	def Factorial_tailRecur(n: Int): Int = {	
		def helper(n: Int, acc: Int): Int = n match {
			case 0 => acc
			case 1 => acc
			case _ => helper(n-1, n*acc)
		}
		helper(n,1)
	}
	println(Factorial_tailRecur(5))

	def Factorial_tailRecur1(n: Int): Int = {
		@tailrec
		def loop(n: Int, acc: Int): Int = {
			if(n == 0) acc
			else loop(n-1, acc * n)
		}
		loop(n,1)
	}
	println(Factorial_tailRecur1(5))
}