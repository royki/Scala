object TwoDimensionalDigit {
  val Zero: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = "| |",
      bottom = "|_|"
    )

  val One: TwoDimensionalString =
    TwoDimensionalString(
      top    = "   ",
      middle = "  |",
      bottom = "  |"
    )

  val Two: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = " _|",
      bottom = "|_ "
    )

  val Three: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = " _|",
      bottom = " _|"
    )

  val Four: TwoDimensionalString =
    TwoDimensionalString(
      top    = "   ",
      middle = "|_|",
      bottom = "  |"
    )

  val Five: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = "|_ ",
      bottom = " _|"
    )

  val Six: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = "|_ ",
      bottom = "|_|"
    )

  val Seven: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = "  |",
      bottom = "  |"
    )

  val Eight: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = "|_|",
      bottom = "|_|"
    )

  val Nine: TwoDimensionalString =
    TwoDimensionalString(
      top    = " _ ",
      middle = "|_|",
      bottom = " _|"
    )
  /*
  def apply(digit: Int): TwoDimensionalString = {
    if (digit == 0) Zero
    else if (digit == 1) One
    else if (digit == 2) Two
    else if (digit == 3) Three
    else if (digit == 4) Four
    else if (digit == 5) Five
    else if (digit == 6) Six
    else if (digit == 7) Seven
    else if (digit == 8) Eight
    else if (digit == 9) Nine
    else TwoDimensionalString.QuestionMarks
  }
*/
  // Pattern Matching
  def apply(digit: Int): TwoDimensionalString = digit match {
    case 0 => Zero
    case 1 => One
    case 2 => Two
    case 3 => Three
    case 4 => Four
    case 5 => Five
    case 6 => Six
    case 7 => Seven
    case 8 => Eight
    case 9 => Nine
    case _ => TwoDimensionalString.QuestionMarks
  }
}
