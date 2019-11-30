import io.StdIn._

object matchExpression extends App {

	val fizzBuzz = for( i <- 0 to 10) yield {
		(i%3, i%5) match {
			case (0,0) => "fizzBuzz"
			case (0,_) => "fizz"
			case (_,0) => "buzz"		
			case _ => i.toString
			}	
	}

	def fact(n: Int): Int = n match {
		case 0 | 1 => 1
		case _ => n*fact(n-1)
	}
	// println(fact(readLine.toInt))

	def sumSquares(n: Int): Int = n match {
		case 1 => 1
		case _ => n*n+sumSquares(n-1)
	}
	// println(sumSquares(readLine.toInt))

	def countDown(n: Int): Unit = n match {
		case 0 => 
		case _ => 
			println(n)
			countDown(n-1)
	}
	println(countDown(readLine.toInt))
}