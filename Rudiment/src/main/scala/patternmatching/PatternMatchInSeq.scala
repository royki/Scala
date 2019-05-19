// Sequence Pattern Matching: Pattern Matching in Scala Collections

object PatternMatchInSeq extends App {

  println("-" * 75)
  def method(input: Any): Any = input match {
    // case Seq() => "Empty Sequence"
    // case Seq(last) => last
    // case Seq(x, last) => last
    // case Seq(1, 2, 3) => "Sequence Matching"
    // case Seq(x, _*)        => "atleast 1 element"
    // case Seq(x, y, _*)     => "atleast 2 element"
    // case Seq(x, y, tail @ _*) => tail
    // case wrapper: checkedType => wrapper.strings

    // Two Pattern at the same time
    // case _: Int | _: String => "Hahahaah, It works !!!"
    case name @ (_: Int | _: String) => name.getClass

  }

  def method1(input: Color): Any = /*input*/ (input: @unchecked) match {
    case Red => "Color Red Matching without Warring"
  }

  def show(input: Any): Unit = println(method(input))
  def show(input: Color): Unit = println(method(input))

  // show(Seq[Int]())
  // show(Seq.empty[Int]())
  // show(Seq.empty())
  // show(Seq())
  // show(Seq(1))
  // show(Seq(1, 3))
  // show(Seq(1, 2, 3))
  // show(checkedType(Seq("1")))
  // show(1)
  // show("1")

  // println(Seq.empty[String] == Seq.empty[Int])
  // println(Seq("1") == Seq(1))
  // println(Seq("1").getClass == Seq(1).getClass)

  println("-" * 75)
}

final case class checkedType(strings: Seq[String]) extends AnyVal
sealed trait Color
case object Black extends Color
case object Red extends Color
