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
}