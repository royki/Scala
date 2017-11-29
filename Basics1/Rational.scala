class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)

  val numer = x / g
  val denom = y / g

  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def -(that: Rational) =
    new Rational(numer * that.denom - that.numer * denom,
      denom * that.denom)

  def *(that: Rational) =
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational) =
    new Rational(numer * that.denom, denom * that.numer)

  override def toString = x + "/" + y
}

trait Ordered[T] {
  def compare(that: T): Int

  def <(that: T) = (this compare that) < 0
  def >(that: T) = (this compare that) > 0
  def <=(that: T) = (this compare that) <= 0
  def >=(that: T) = (this compare that) >= 0
}

class OrderedRational(x: Int, y: Int) extends Rational(x, y) with
  Ordered[OrderedRational] {

  def compare(that: OrderedRational) =
    (numer * that.denom) compare (denom * that.numer)
}

object Rational {
  def apply(x: Int, y: Int) = new OrderedRational(x, y)
  def apply(x: Int) = new OrderedRational(x, 1)
}

val a = Rational(1, 2)
val b = Rational(1)

println(a + " + " + b + " = " + (a + b))
println(a + " - " + b + " = " + (a - b))
println(a + " * " + b + " = " + (a * b))
println(a + " / " + b + " = " + (a / b))
println(a + " < " + b + " = " + (a < b))
println(a + " > " + b + " = " + (a > b))
println(a + " <= " + b + " = " + (a <= b))
println(a + " >= " + b + " = " + (a >= b))
