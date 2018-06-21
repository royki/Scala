// tabulate also use currying

object Currying_PassByName {
	def main(args: Array[String]): Unit = {
		???
	}

	// Without currying
	def add(x:Int, y: Int): Int = x + y

	// With currying
	def add(x:Int)(y:Int): Int = x + y
	val plus3 = add(3)_
	val eight = plus3(5)

	// Pass By Name
	def threeTuple(a: Double): (Double, Double, Double) = {
		(a,a,a)
	}

	// In scala it should think as pass by reference
	threeTuple(5)
	println(threeTuple(math.random))

	// This is a function that takes no arguments and gives back Double
	def threeTuple(a : () => Double): (Double, Double, Double) = {
		(a(),a(),a())
	}
	println(threeTuple(() => math.random))

	// Scala uses the following was pass by name arguments
	def threeTuple(a : => Double): (Double, Double, Double) = {
		(a,a,a)
	}
	println(threeTuple(math.random))



	def sum(f: Int => Int, a: Int, b: Int): Int = {
		if(a > b) 0
		else f(a) + sum(f,a+1,b)
	}

	def sumInts(a: Int, b: Int) = sum(id, a, b)
	def sumCubes(a: Int, b: Int) = sum(cube, a, b)
	def sumFactorials(a: Int, b: Int) = sum(fact, a, b)

	def id(x: Int): Int = x
	def cube(x: Int): Int = x * x * x
	def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)

	// rewritting sum function
	// Sum is now a function that returns another function
	// The returned function sumF applies the given function parameter f and sums the results
	def sum(f: Int => Int):(Int, Int) => Int = {
		def sumF(a: Int, b: Int): Int = {
			if(a > b) 0
			else f(a) + sumF(a + 1, b)
		}
		sumF
	}

	// shorter version of sum
	def sum(f: Int => Int)(a: Int, b: Int): Int = {
		if(a > b) 0 else f(a) + sum(f)(a + 1, b)
	}

	// product function that calculates the product of the values of a function for the points on a given interval
	def product(f: Int => Int)(a: Int, b: Int): Int = {
		if(a > b) 1
		else f(a) * product(f)(a + 1, b)
	}
	product(x => x * x)(3, 4)

	// factorial function in terms of product
	def fact(n: Int): Int = product(x => x)(1, n)
	fact(5)

	// general function which generalizes both sum and product
	def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
		if(a > b) zero
		else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
	}

	// product with mapReduce
	def product(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x, y) => x * y, 1)(a,b)
	product(x => x * x)(3, 4)


	// factorial with mapReduce
	def fact(n: Int): Int = ???

}