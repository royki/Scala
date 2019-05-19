// Patter Matching: Syntactic Sugar of `if` expression; type check; type cast and `equal` method.
// It is for Data Structure not for Object

object PatternMatching extends App {
  println("-" * 100)
  val one = 1
  val Two = 2

  def method(input: Any): Any = input match {
    // case variable => s"Any: $variable"
    case 2                      => 2 // Constant Pattern
    case `one`                  => s"Matched one ${`one`}" // Constant Pattern
    case Two                    => s"Matched Two $Two" // Constant Pattern
    // case _: Boolean  => s"Matched Boolean" // type Pattern
    // case name: Boolean => s"Matched Boolean $name" // type Pattern
    // case name @ (_: Boolean) => s"Matched Boolean $name" // type Pattern
    case name @ (n: Boolean)    => s"Matched Boolean $name | $n" // type Pattern
    case name @ null            => name
    case name @ PatternMatching => PatternMatching // Pattern Match of object
    case _                      => input
  }

  // Function Overloading
  // def method(input: Int): Any = input match {
  //   case variable => s"Int: $variable"
  // }

  println(method(PatternMatching)) // println(method(this))
  println(method(null))
  println(method(1))
  println(method(2))
  println(method(true))
  println(method(false))
  println(method("Scala"))
  println(method("sbt"))
  println(method('s'))

  println("-" * 100)
}
