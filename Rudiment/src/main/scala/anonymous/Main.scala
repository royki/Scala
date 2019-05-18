// Anonymous and Partial Functions.
// Partial Functions only be checked in run time; whereas Total Functions be checked in compile time
// Function Literal are merely syntactic sugar of Anonymous classes

object Anonymous {
  def main(args: Array[String]): Unit = {
    println("-" * 80)
    code(args)
    println("-" * 80)
  }

  def code(args: Array[String]): Unit = {

    /*
    trait Chatty {
      // function name `sayHi` to change as `apply`
      // If we've a Function named as `apply`, we don't need to call it later.
      def apply(greeting: String): Unit
    }

    class Person(name: String) extends Chatty {
      override def apply(greeting: String): Unit = {
        println(s"Hi I'm $name. $greeting")
      }
    }

    val singleton: Chatty = new Chatty {
      override def apply(greeting: String): Unit = {
        println(s"Hi, I'm singleton!!")
      }
    }

    val alice = new Person("Alice")
    val bob: Chatty = new Person("Bob")

    alice("How is doing?")
    bob("What's Up!!!")
    singleton.apply("I'm cool!!!")
 */

    trait SimpleFunction0[+Output] {
      def apply(): Output
    }

    // We change our `trait` to named parameter
    trait SimpleFunction1[-Input1, +Output] {
      // trait SimpleFunction1 {
      // def apply(argument: String): Unit
      def apply(argument1: Input1): Output
    }

    trait SimpleFunction2[-Input1, -Input2, +Output] {
      def apply(argument1: Input1, argument2: Input2): Output
    }

    /*class NameFunction1(name: String) extends SimpleFunction1 {
      override def apply(argument: String): Unit = {
        println(s"Hi I'm $name. $argument")
      }
    }

    val singleton: SimpleFunction1 = new SimpleFunction1 {
      override def apply(argument: String): Unit = {
        println(s"Hi, I'm singleton!!")
      }
    }*/

    // Function Literal or Lambda or Anonymous Function
    // this is with Syntactic sugar
    val totalFuc: Int => String = argument => "\"" + argument + "\""
    val randomNumber = scala.util.Random.nextInt

    // We've a problem here - as SimpleFunction1 takes `String` and returns `Unit` but we want the total function as it takes `Int` and returns `String`
    // We'll use `type parameter` to avoid this; and change our `trait` to take Input and Output

    // Scala has `Function1` trait which exactly works like `SimpleFunction1`. We can simply call `Function1` as well

    // val totalFucWithOutSyntacticSugar: SimpleFunction1 = new SimpleFunction1 {
    // val totalFucWithOutSyntacticSugar: SimpleFunction1[Int, String] = new SimpleFunction1[Int, String] {
    val totalFucWithOutSyntacticSugar: Function1[Int, String] = new Function1[Int, String] {
      override def apply(argument: Int): String = {
        "\"" + argument + "\""
      }
    }

    // println(" " + randomNumber)
    // println(totalFuc(randomNumber))
    // println(totalFucWithOutSyntacticSugar(randomNumber))

    // val alice = new NameFunction1("Alice")
    // val bob: SimpleFunction1 = new NameFunction1("Bob")

    // alice("How is doing?")
    // bob("What's Up!!!")
    // singleton("I'm cool!!!")

    val partialFuncWithOutSyntacticSugar: PartialFunction[Int, String] = new PartialFunction[Int, String] {
      override def apply(argument: Int): String = {
        "\"" + argument + "\""
      }

      def isDefinedAt(x: Int): Boolean = true
    }

    // Partial Function with Syntactic sugar
    type ~>[-Input, +Output] = PartialFunction[Input, Output]

    val partialFunction: Int ~> String = {
      // case 4 => "\"" + 4 + "\""
      case argument if argument == 4 => "\"" + 4 + "\""
      // case argument @ 4 => "\"" + 4 + "\""
    }

    // println(partialFunction(4))
    // println(partialFunction(4))

    def toRomanNumeralDigit(number: Int): String = {
      val partialFunction: Int ~> String = {
        case 0 => "0: N"
        case 1 => "1: I"
        case 2 => "2: II"
        case 3 => "3: III"
        case 4 => "4: IV"
        case 5 => "5: V"
        case 6 => "6: VI"
        case 7 => "7: VII"
        case 8 => "8: VIII"
        case 9 => "9: IX"
      }

      partialFunction(number)
    }

    def toRomanNumeralDigitOrElse(number: Int): String = {
      val partialFunction: Int ~> String = {
        onlyEvenDigits orElse onlyOddDigits
      }
      partialFunction(number)
    }

    lazy val onlyEvenDigits: Int ~> String = {
      case 0 => "0: N"
      case 2 => "2: II"
      case 4 => "4: IV"
      case 6 => "6: VI"
      case 8 => "8: VIII"
    }

    lazy val onlyOddDigits: Int ~> String = {
      case 1 => "1: I"
      case 3 => "3: III"
      case 5 => "5: V"
      case 7 => "7: VII"
      case 9 => "9: IX"
    }

    // (0 to 9).map(toRomanNumeralDigit).foreach(println)
    // (0 to 9).map(toRomanNumeralDigitOrElse).foreach(println)

    // Direct use of Partial Function without having any `def`

    val partialFunctionOutsidedef: Int ~> String = {
      case 0 => "0: N"
      case 1 => "1: I"
      case 2 => "2: II"
      case 3 => "3: III"
      case 4 => "4: IV"
      case 5 => "5: V"
      case 6 => "6: VI"
      case 7 => "7: VII"
      case 8 => "8: VIII"
      case 9 => "9: IX"
    }
    // 0 to 9 map partialFunctionOutsidedef foreach println
    // 0 to Int.MaxValue collect partialFunctionOutsidedef foreach println
    0 until Int.MaxValue takeWhile partialFunctionOutsidedef.isDefinedAt collect partialFunctionOutsidedef foreach println

    // Pattern Matching
    def toRomanNumeralDigitPatterMatch(number: Int): String = number match {
      case 0 => "0: N"
      case 1 => "1: I"
      case 2 => "2: II"
      case 3 => "3: III"
      case 4 => "4: IV"
      case 5 => "5: V"
      case 6 => "6: VI"
      case 7 => "7: VII"
      case 8 => "8: VIII"
      case 9 => "9: IX"
    }

    // 0 to 9 map toRomanNumeralDigitPatterMatch foreach println

  }
}
