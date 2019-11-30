import collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Deadlock extends App {

	/*var cnt = 0
	Future{for(i <- 1 to 100000) cnt += 1}.foreach{_ => println("f1 is done")}
	Future{for(i <- 1 to 100000) cnt += 1}.foreach{_ => println("f2 is done")}*/

	var b1 = mutable.Buffer[String]()
	var b2 = mutable.Buffer[String]()

	def doWork(count: Int): Unit = Thread.sleep(count)

	def useBuffers(buf1: mutable.Buffer[String], buf2: mutable.Buffer[String]): Unit = {
		buf1.synchronized {
			doWork(1000)
			buf2.synchronized {
				doWork(1000)
			}
		}
	}

	Future { useBuffers(b1, b2)}.foreach(_ => println("Call 1"))
	Future { useBuffers(b2, b1)}.foreach(_ => println("Call 2"))
	Thread.sleep(3000)
	println("Main done")

}