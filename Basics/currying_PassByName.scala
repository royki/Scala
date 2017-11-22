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
}