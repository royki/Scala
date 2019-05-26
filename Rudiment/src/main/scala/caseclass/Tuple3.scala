// Tuples: Immutable heterogenous sequences of fixed length
// 1] Immutable -> They can't be changed (also applied to types)
// 2] heterogenous -> Every element may have a different type
// 3] fixed length -> There is an order

// Tuple Hierarchy
// trait Equals extends Any
// trait Product extends Equals
// trait Product3[+T1, +T2, +T3] extends Product
// final case class Tuple3[+T1, +T2, +T3] extends Product3[+T1, +T2, +T3]

object Tuple3 extends App {

  println("-" * 75)

  // val tuple: Tuple3[String, Int, Boolean] = ("Number", 1234, true)
  // val tuple3 = ("Tuple3", 1234, true)

  // println(tuple)
  // println(tuple3)
  // println(tuple3._2)

  // tuple3 match {
  // case t3 => println(t3._3)
  // case Tuple3(_, _, z) => println(z)
  // case (x, _, _) => println(x)
  // }

  // T3 match {
  //   case (_, num, _) => println(num)
  // }
  // println(T3._2)

  val tuple3 = new T3("Tuple3", 1234, true)
  println(tuple3._3)

  println(!tuple3._3)
  println(tuple3.productArity)
  println(tuple3.productElement(2))

  val iterator: Iterator[Any] = tuple3.productIterator
  iterator foreach println

  println("-" * 75)

}

// Product3 exists in Scala Tuple3 API
class T3(override val _1: String, override val _2: Int, override val _3: Boolean)
  extends Product3[String, Int, Boolean] {

  // Members declared in scala.Equals
  def canEqual(that: Any): Boolean = that.isInstanceOf[T3]

  // Members declared in scala.Product3
  // def _1: String = "Tuple 3"
  // def _2: Int = 456
  // def _3: Boolean = true
}

// Product3 exists in Scala Tuple3 API
object T3 extends Product3[String, Int, Boolean] {

  // Members declared in scala.Equals
  def canEqual(that: Any): Boolean = that.isInstanceOf[T3.type]

  // Members declared in scala.Product3
  def _1: String = "Tuple 3"
  def _2: Int = 123456
  def _3: Boolean = true
}

// Product exists in Scala Tuple3 API
/*object*/ trait P3 extends Product {
  // Members declared in scala.Equals
  def canEqual(that: Any): Boolean = that.isInstanceOf[P3]

  // Members declared in scala.Product
  def productArity: Int = 3
  def productElement(n: Int): Any = n match {
    case 0 => _1
    case 1 => _2
    case 2 => _3
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }
  def _1: String
  def _2: Int
  def _3: Boolean
}
