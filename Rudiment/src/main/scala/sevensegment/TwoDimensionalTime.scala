import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import TwoDimensionalString._

object TwoDimensionalTime {

  val Stars: TwoDimensionalString =
    TwoDimensionalString(
      top    = "   ",
      middle = " * ",
      bottom = " * "
    )

  def showCurrentTime(pattern: String): Unit = {
    show(LocalDateTime.now, pattern)
  }

  private[this] def show(time: LocalDateTime, pattern: String): Unit = {
    formatted(time, pattern).show()
  }

  private[this] def formatted2(time: LocalDateTime, pattern: String): TwoDimensionalString = {
    var result: TwoDimensionalString = TwoDimensionalString.Empty

    oneDimensional(time, pattern) foreach {
      timeDigit =>
        if (timeDigit == ':')
          result += Stars
        else
          result += TwoDimensionalDigit(timeDigit.toString.toInt)
    }

    result
  }

  private[this] def formatted(time: LocalDateTime, pattern: String): TwoDimensionalString = {
    oneDimensional(time, pattern).foldLeft(TwoDimensionalString.Empty) {
      (result, timeDigit) =>
        if (timeDigit == ':')
          result + Stars
        else
          result + TwoDimensionalDigit(timeDigit.toString.toInt)
    }
  }

  private[this] def oneDimensional(time: LocalDateTime, pattern: String): String = {
    time.format(DateTimeFormatter.ofPattern(pattern))
  }
}
