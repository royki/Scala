import io.StdIn._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success
import scala.concurrent.Await
import scala.concurrent.duration._

object FutureObject extends App {
	val page1 = Future {
		"Google " +io.Source.fromURL("http://www.google.com").take(100).mkString
	}

	val page2 = Future {
		"Scala " +io.Source.fromURL("https://www.scala-lang.org").take(100).mkString
	}

	val page3 = Future {
		"SO " +io.Source.fromURL("https://stackoverflow.com").take(100).mkString
	}

	val pages = List(page1, page2, page3)
	val fPage = Future.firstCompletedOf(pages)
	fPage.foreach(println)
	val allPages = Future.sequence(pages)
 	allPages.foreach(println)
	Thread.sleep(5000)
}