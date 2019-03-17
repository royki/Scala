package collections

trait Set extends (String => Boolean) {
  final def add(input: String): Set = element => // true
    // input == element                // add one element only
    input == element || this(element) // add elements

  final def remove(input: String): Set = element =>
    // input == !element // remove only element
    input != element || !this(element) // remove elements

  final def union(that: Set): Set = element =>
    this(element) || that(element)

  final def intersect(that: Set): Set = element =>
    this(element) && that(element)

  final def diff(that: Set): Set = element =>
    this(element) && !that(element)

  final def isSubsetOf(that: Set): Boolean =
    ???
}

object Set {
  val empty: Set = input => false
}
