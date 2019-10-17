package collections

trait Set extends (String => Boolean) {
  /*
  From here, we change implementation approach a little (differ from OldSet.scala). We ll follow now OOP approach,
  We ll have add as `abstract` method and two different implementation of `add`;
  One for Empty Set and another for NonEmpty Set
  We make the `add` function abstract here

  */
  def add(input: String): Set
  def remove(input: String): Set
  def union(that: Set): Set

  final def isSubsetOf(that: Set): Boolean =
    ???
}
// Companion object of the trait
object Set {

  // ----------------Implementation of NonEmpty Set -------------------------//
  /*
  There is a convention in FP, it is called Cons or Constructed, here it is named as Link or NonEmpty Set
  empty Set provides the implementation of `apply` [`(String => Boolean)]`
  So we need to implement it for NonEmpty Set or Link
  */

  private final case class NonEmpty(element: String, otherElements: Set) extends Set {
    override final def apply(input: String): Boolean =
      input == element || otherElements(input)

    // Add in NonEmpty Set
    override final def add(input: String): Set =
      if (input == element)
        this
      else
        NonEmpty(input, otherElements.add(element))

    // Remove in NonEmpty Set
    override final def remove(input: String): Set =
      if (input == element) otherElements
      else NonEmpty(element, otherElements.remove(input))

    // Uninon in NonEmpty Set
    def union(that: Set): Set = ???
  }

  // ----------------Implementation of Empty Object -------------------------//

  // We ll have a private object named `Empty`, that ll extend Set
  private object Empty extends Set {
    def apply(input: String): Boolean = false

    /*
    Add in Empty Set
    that is actually the production of NonEmpty Sets. As soon as, you add something in the NonEmpty Set, it becomes a nonempty set
   */
    def add(input: String): Set = NonEmpty(input, Empty)

    // Remove in Empty Set
    def remove(input: String): Set = this

    // Uninon in Empty Set
    def union(that: Set): Set = ???

  }

  /*
  Empty Set provides the implementation of `(String => Boolean)`
  val empty: Set = input => false
  As we have an object named `Empty` which has same `apply` implementation, we need to use it for Set [`val empty: OldSet = input => false`]
   */
  val empty: Set = Empty

}
