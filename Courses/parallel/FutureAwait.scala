import io.StdIn._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success
import scala.concurrent.Await
import scala.concurrent.duration._

object FutureAwait extends App {

	def ParallelFib(n: Int):Int = if(n < 2) 1 else ParallelFib(n-1)+ParallelFib(n-2)
		

	println("First")
	val f = Future {
		println("Printing in the future")
	}
	Thread.sleep(1)
	println("Last")

	val f1 = Future {
		for(i <- 1 to 10) yield ParallelFib(i)
		// throw new RuntimeException("Bad.")
	}	
	println(Await.result(f1, 5 seconds))
	
	Thread.sleep(1000)
	
}