import TwoDimensionalString._
import TwoDimensionalDigit._
import TwoDimensionalTime._
import TwoDimensionalTime._
import Scala._
import Terminal._
import scala.concurrent.duration._

object SevenSegment extends App {
  println("-" * 50)

  // val result = Seven + Eight
  // result.show()

  // TwoDimensionalDigit(1).show()
  // TwoDimensionalDigit(0).show()
  // TwoDimensionalDigit(9).show()
  // TwoDimensionalTime.showCurrentTime(pattern = "HH:mm:ss")

  import Constants._

  Scala.loop(times = FewSeconds) {
    Terminal.clearCanvas()
    Terminal.goUp(LinesToGoUp)

    TwoDimensionalTime.showCurrentTime(TimePattern)

    Scala.wait(Interval)
  }
  println()

  Scala.tickUntilEnterIsPressed(Interval) {
    Terminal.clearCanvas()
    Terminal.goUp(LinesToGoUp)

    TwoDimensionalTime.showCurrentTime(TimePattern)
  }

  object Constants {
    val Interval: FiniteDuration = 1.second
    val LinesToGoUp: Int = Int.MaxValue
    val TimePattern: String = "HH:mm:ss"
    val FewSeconds: Int = 10
  }

  println("-" * 50)
}
