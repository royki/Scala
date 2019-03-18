object HOF extends App {

  println("-" * 50)

  def plusFive(input: Int): Int = input + 5

  val renderedPlusFiveOld: String = s"Function: plusFive\tArgument: ${10}\tResult: ${plusFive(10)}"
  println(renderedPlusFiveOld)

  def divideByThree(input: Int): Int = input / 3

  val renderedDivideByThree: String = s"Function: divideByThree\tArgument: ${30}\tResult: ${divideByThree(30)}"
  println(renderedDivideByThree)

  def renderFunc(funcName: String, argument: Int, result: Int): String =
    s"Function: $funcName\tArgument: $argument\tResult: $result"

  def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def loop(x: Int, accu: Int): Int = {
      if (x == 0)
        accu
      else
        loop(x - 1, accu * x)
    }
    val result = loop(n, 1)
    result
  }

  val renderedPlusFive: String = renderFunc("+ 5", 10, plusFive(10))
  println(renderedPlusFive)

  // Higher Order Function & Lower Order Function
  def higherOrderFunc(funcName: String, argument: Int, func: Int => Int): String =
    renderFunc(funcName, argument, result = func(argument))

  val renderedPlusFiveHOF: String = higherOrderFunc("+ 5", 10, plusFive)
  println("HOF: " + renderedPlusFiveHOF)

  def show(funcName: String, argument: Int, func: Int => Int): Unit =
    println(higherOrderFunc(funcName, argument, func))

  show("+ 5", 10, plusFive)

  // Using Function Literal instead of small function that is defined
  show("+ 5", 10, input => input + 5)
  show("/ 5", 20, input => input / 5)

  show("mod5", 20, _ % 5)

  val mod2: Int => Int = _ % 2
  // or
  def mod5(x: Int): Int = x % 5

  show("mod2", 27, mod2)
  show("factorial with show", 0, factorial)

  def showRange(funcName: String, arguments: Range, func: Int => Int): Unit =
    arguments foreach { argument =>
      show(funcName, argument, func)
    }

  showRange("factorial", 0 to 10, factorial)

  println("-" * 50)
}
