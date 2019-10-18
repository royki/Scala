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

  def intersect(that: Set): Set
  def diff(that: Set): Set

  def isSubsetOf(that: Set): Boolean 
  final def isSupersetOf(that: Set): Boolean = that.isSubsetOf(this)
  
  final override def equals(other: Any): Boolean = other match {
    case that: Set => this.isSubsetOf(that) & that.isSubsetOf(this)
    case _ => false
  }
  def size: Int
  def isEmpty: Boolean /* = this eq Set.empty */
  final def nonEmpty: Boolean = !isEmpty

  def isSingleton: Boolean

  def sample: Option[String]
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

    // Union in NonEmpty Set
    override final def union(that: Set): Set = {
      val newSet = that.add(element)
      otherElements.union(newSet)
    }
    
    // Intersection in NonEmpty Set
    override final def intersect(that: Set): Set = {
      if(that(element))
      otherElements.intersect(that).add(element)
      else
      otherElements.intersect(that)
    }
    
    // Difference in NonEmpty Set
    override final def diff(that: Set): Set = {
      if(that(element))
        otherElements.diff(that)
      else
        otherElements.diff(that).add(element)
      }

    // isSubsetOf NonEmpty Set
    override final def isSubsetOf(that: Set): Boolean = 
      that(element) && otherElements.isSubsetOf(that)

    // hashCode
    override final def hashCode: Int = element.hashCode + otherElements.hashCode  

    // Size of NonEmpty Set
    override final def size: Int = 1 + otherElements.size

    // isEmpty on NonEmpty Set
    override final def isEmpty: Boolean = false
    
    // isSingleton on NonEmpty Set
    override final def isSingleton: Boolean = otherElements.isEmpty

    // Sample of NonEmpty Set
    override final def sample: Option[String] = Some(element)
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

    // Union in Empty Set
    override final def union(that: Set): Set = that

    // Intersection in NonEmpty Set
    override final def intersect(that: Set): Set = this

    // Difference in NonEmpty Set
    override final def diff(that: Set): Set = this

    // isSubsetOf NonEmpty Set
    override final def isSubsetOf(that: Set): Boolean = true

    // Size of Empty Set
    override final def size: Int = 0

    // isEmpty on Empty Set
    override final def isEmpty: Boolean = true

    // isSingleton on Empty Set
    override final def isSingleton: Boolean = false

    // Sample of Empty Set
    override final def sample: Option[String] = None

  }

  /*
  Empty Set provides the implementation of `(String => Boolean)`
  val empty: Set = input => false
  As we have an object named `Empty` which has same `apply` implementation, we need to use it for Set [`val empty: OldSet = input => false`]
   */
  val empty: Set = Empty

}
