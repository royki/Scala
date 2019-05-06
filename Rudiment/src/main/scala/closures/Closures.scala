object Closures extends App {
  println("-" * 50)

  // HOF => here it returns another function
  def closedTerm(freeVariable: Int): Int => Int = boundVariable => boundVariable + freeVariable

  def closedTerm1(freeVariable: Int): Int => Int = {
    val openTerm: Int => Int =
      boundVariable => boundVariable + freeVariable

    openTerm
  }

  def closedTerm2(freeVariable: Int): Int => Int = {
    def openTerm(boundVariable: Int): Int =
      boundVariable + freeVariable

    openTerm
  }

  // Curried
  def closedTerm3(freeVariable: Int)(boundVariable: Int): Int = {
    boundVariable + freeVariable
  }

  // Uncurried
  def closedTerm4(freeVariable: Int, boundVariable: Int): Int = {
    boundVariable + freeVariable
  }

  println(closedTerm(7)(0))
  println(closedTerm(7)(1))
  println(closedTerm(7)(2))
  println(closedTerm(7)(3))

  println(closedTerm(freeVariable = 10)(0))
  println(closedTerm1(freeVariable = 10)(1))
  println(closedTerm2(freeVariable = 10)(2))
  println(closedTerm3(freeVariable = 10)(3))

  val partialComputation = closedTerm2(freeVariable = 30)
  println(partialComputation(3))

  println("-" * 50)
}
