object Helpers {
  private def styled(str: String, color: String): Unit = {
    println(color + str + Console.RESET)
  }

  def showRed(str: String): Unit = {
    styled(str, Console.RED)
  }

  def showGreen(str: String): Unit = {
    styled(str, Console.GREEN)
  }

  def showYellow(str: String): Unit = {
    styled(str, Console.YELLOW)
  }

}
