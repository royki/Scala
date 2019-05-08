import java.util._
import scala.concurrent.duration._

object Scala {
  def tickUntilEnterIsPressed(interval: FiniteDuration)(someCode: => Unit) = {
    val timer: Timer = new Timer

    val delayInMilliseconds: Long = 0
    val periodInMillisecodns: Long = interval.toMillis

    val task: TimerTask = new TimerTask {
      def run(): Unit = {
        someCode
      }
    }

    timer.scheduleAtFixedRate(
      task,
      delayInMilliseconds,
      periodInMillisecodns
    )

    io.StdIn.readLine // Read from User Input

    timer.cancel()
  }

  def loop(times: Int)(someCode: => Unit): Unit = {
    1 to times foreach { _ =>
      someCode
    }
  }

  def wait(delay: FiniteDuration): Unit = {
    Thread.sleep(delay.toMillis)
  }
}
