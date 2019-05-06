// Scala `case class` generates some methods like string methods, it also generates companion object

object StringWithLength {
  // generates `apply() methods`, it is exactly like constructor
  // now we can use `apply` methods instead of `new StringWithLength`
  def apply(str: String): StringWithLength = new StringWithLength(str)
}

final case class StringWithLength(val str: String) {
  val length: Int = str.length

  // `addTuples` -> `add` -> `+` (symbolic method)
  def +(that: StringWithLength): StringWithLength = {
    // new StringWithLength(this.str + that.str)
    // StringWithLength.apply(this.str + that.str)
    StringWithLength(this.str + that.str) // or we don't need to use `apply`, as complier will do it in behalf
  }
}

final case class Person(
    name: String,
    age: Int,
    ph: String,
    email: String
)

object TuplesUsingClass extends App {
  println("-" * 50)

  // Type alias is replaced with the class StringWithLength
  // We will produce a new instance of the `addTuples`

  /*
  def addTuples(f: StringWithLength, s: StringWithLength): StringWithLength = {
    new StringWithLength(f.str + s.str)
   }
*/

  // val result: StringWithLength = new StringWithLength("Dev") + new StringWithLength("InsideYou")
  // val result: StringWithLength = StringWithLength.apply("Dev") + StringWithLength.apply("InsideYou")
  val result: StringWithLength = StringWithLength("Dev") + StringWithLength("InsideYou")

  /*
  val result: StringWithLength = addTuples(
    f = new StringWithLength("Dev"),
    s = new StringWithLength("InsideYou")
  )
 */

  println(result)
  println(result.str)
  println(result.length)
  println

  val p = Person(
    name  = "Vald",
    age   = 31,
    ph    = "+xx xx-xx-xx-xx-xx",
    email = "vald@devinsideyou.de"
  )
  println(p)

  println("-" * 50)
}
