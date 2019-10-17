package collections

trait OldSet extends (String => Boolean) {
  // Set is essentially a function, where `element` comes in and `boolean` comes out.
  final def add(input: String): OldSet = element => // true
    // input == element                // add one element only
    input == element || this(element) // add elements

  final def remove(input: String): OldSet = element =>
    // input == !element // remove only element
    // input != element && this(element) // remove elements
    // Need to add test to cover
    input != element && this(input) // remove elements

  // Union essentially is logical OR
  final def union(that: OldSet): OldSet = element =>
    this(element) || that(element)

  // Intersect essentially is logical AND
  final def intersect(that: OldSet): OldSet = element =>
    this(element) && that(element)

  final def diff(that: OldSet): OldSet = element =>
    this(element) && !that(element)

  final def isSubsetOf(that: OldSet): Boolean =
    ???
}
// Companion object of the trait
object OldSet {
  /*
  (String => Boolean) this moved to trait
  val empty: String => Boolean = input => false
  val empty: String => Boolean = _ => false
  */

  /*
  How did `input => false` ended up being `OldSet`.
  Trait `Set` extends (String => Boolean); this is Function1 & F1 has one methond `apply`, so there is one abstract method `Set`.
  Scala here helps it out. Given a function `input => false` which matches the signature, scala will create a `Set`
  This is actually happening here

  val empty: Set = new Set {
    override finle def apply(input: String) = false
  }
  */
  val empty: OldSet = input => false

}
