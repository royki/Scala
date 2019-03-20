// Case Class

final case class TwoDimensionalString(top: String, middle: String, bottom: String) {
  // println("DevInsideYou")

  require( // scala in-built method; it has two parameters; requirement: Boolean, s: String
    requirement = doAllRowHaveSameLenth,
    message     = "All rows must have same length"
  )

  private[this] def doAllRowHaveSameLenth: Boolean = {
    top.length == middle.length && middle.length == bottom.length
  }

  def +(that: TwoDimensionalString): TwoDimensionalString =
    TwoDimensionalString(
      top    = this.top + that.top,
      middle = this.middle + that.middle,
      bottom = this.bottom + that.bottom
    )

  def show(): Unit = {
    println(rendered)
  }

  private[this] def rendered: String =
    top + "\n" +
      middle + "\n" +
      bottom
}

// Companion object
object TwoDimensionalString {
  val QuestionMarks: TwoDimensionalString =
    TwoDimensionalString(
      top    = "   ",
      middle = " ? ",
      bottom = " ? "
    )
  val Empty: TwoDimensionalString =
    TwoDimensionalString(
      top    = "",
      middle = "",
      bottom = ""
    )
}
