// Scala supports named arguments
object Named_DefaultArgumentsInScala {
	def main(args: Array[String]): Unit = {
		
		grade(List(3,1,4), List(1,2,4), List(5,6,2))
		// Named arguments
		grade(assignments= List(1,2,4), test=List(5,6,2), quiz=List(3,1,4))

		// for Nil
		grade(List(3,1,4), List(1,2,4))
		// Named arguments
		grade(assignments= List(1,2,4), quiz=List(3,1,4))
	}

	def grade(quiz: List[Int], assignments: List[Int], test: List[Int]): Double = {
		???		
	}

		def grade(quiz: List[Int], assignments: List[Int], test: List[Int]= Nil): Double = {
		???		
	}
}