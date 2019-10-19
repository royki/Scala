package collections

// We ll user `foreach` & `varargs`
sealed trait SetforEach extends (String => Boolean) {
  import SetforEach._  
  /* 
   `foreach` take cares both empty & non empty set. 
   So it will moved to the `trait` and `apply` implementation will be removed from empty & non empty set as well 
    */
    override final def apply(input: String): Boolean ={
      var result = false
        foreach { current => 
          result = result || current == input
        }
      result
    }

    // def add(input: String): SetforEach
    final def add(input: String): SetforEach = {
      var result = NonEmpty(input, SetforEach.empty)
        foreach { current => 
          if(current != input)          
            result = NonEmpty(current, result)
        }
      result
    }

 
  // def remove(input: String): SetforEach
  final def remove(input: String): SetforEach = {
    var result = SetforEach.empty
    foreach { current =>
      if(current != input) 
        result = NonEmpty(current, result)
    }        
    result
  }

  // def union(that: SetforEach): SetforEach
  final def union(that: SetforEach): SetforEach = {
    var result = that
    foreach { current =>
      result = result.add(current)
    }
    result
  }

  // def intersect(that: SetforEach): SetforEach 
  final def intersect(that: SetforEach): SetforEach = {
    var result = empty
    foreach { current =>
      if(that(current))
        result = result.add(current)
    }
    result
  }

  // def diff(that: SetforEach): SetforEach
  final def diff(that: SetforEach): SetforEach = {
    var result = empty
    foreach { current => 
      if(that(current)) result        
      else  
        result = result.add(current)
    }
    result
  }

  // def isSubsetOf(that: SetforEach): Boolean
  final def isSubsetOf(that: SetforEach): Boolean = {
    var result = true

    foreach { current => 
      result = result && that(current)
    }
    result
  }
  
  final def isSupersetOf(that: SetforEach): Boolean = that.isSubsetOf(this)

  final override def equals(other: Any): Boolean = other match {
    case that: SetforEach => this.isSubsetOf(that) & that.isSubsetOf(this)
    case _                => false
  }
  
  // def size: Int
  final def size: Int = {
    var result = 0
    foreach {current => 
      result = result + 1
    }
    result
  }
  def isEmpty: Boolean /* = this eq Set.empty */
  final def nonEmpty: Boolean = !isEmpty

  // def isSingleton: Boolean
  final def isSingleton: Boolean = {
    if(isEmpty) false
    else {
      val nonEmptySet = this.asInstanceOf[NonEmpty]
      val element = nonEmptySet.element
      val otherElements = nonEmptySet.otherElements
      otherElements.isEmpty
    }
  }

  override final def hashCode: Int = {
    if(isEmpty) 41
    else {
      val nonEmptySet = this.asInstanceOf[NonEmpty]
      val element = nonEmptySet.element
      val otherElements = nonEmptySet.otherElements
      element.hashCode + otherElements.hashCode
    }
  }

  // def sample: Option[String]
  final def sample: Option[String] = {
    if(isEmpty) None
    else {
      val nonEmptySet = this.asInstanceOf[NonEmpty]
      val element = nonEmptySet.element
      Some(element)
    }
  }

  // `foreach` implementation
  // (function: String => Unit) will be replaced by generics later
  // def foreach(function: String => Unit): Unit
  final def foreach(function: String => Unit): Unit = {
    if(nonEmpty) {
      // val NonEmpty(element, otherElements) = this // equality is expensive

      val nonEmptySet = this.asInstanceOf[NonEmpty]
      val element = nonEmptySet.element
      val otherElements = nonEmptySet.otherElements
      function(element)
      otherElements.foreach(function)
    }
  }

}

// Companion object of the trait
object SetforEach {

  // Implementaion with `varargs`
  // passing multiple value of a parameter, use `varargs`
  def apply(element: String, otherElements: String*): SetforEach = {
    /* 
    var result: SetforEach = SetforEach.empty.add(element) 
    As we are already inside the object `SetforEach`, we can write as
    */
    var result: SetforEach = empty.add(element) 
    // `otherElements` are type of sequence of String 
    // here `foreach` is imported from Scala Collections; not what is built here
    
    // val test: scala.collection.Seq[String] = otherElements

    otherElements.foreach { current => 
      result = result.add(current)
    }
    result
  }


  // ** Rewriting all functions using `foreach`
  // ----------------Implementation of NonEmpty Set -------------------------//

  private final case class NonEmpty(element: String, otherElements: SetforEach)
      extends SetforEach {
      
    /*
     override final def apply(input: String): Boolean =
      input == element || otherElements(input)
    */


    // Add in NonEmpty Set
    /* 
    override final def add(input: String): SetforEach =
      if (input == element)
        this
        else
        NonEmpty(input, otherElements.add(element))
   */
      
    // Remove in NonEmpty Set
   /* 
    override final def remove(input: String): SetforEach =
      if (input == element) otherElements
      else NonEmpty(element, otherElements.remove(input))
    */
   
    
    // Union in NonEmpty Set
    /* 
    override final def union(that: SetforEach): SetforEach = {
      val newSet = that.add(element)
      otherElements.union(newSet)
    }
    */   

    // Intersection in NonEmpty Set
    /* 
    override final def intersect(that: SetforEach): SetforEach = {
      if (that(element))
        otherElements.intersect(that).add(element)
      else
        otherElements.intersect(that)
    }
    */

    // Difference in NonEmpty Set
    /* 
    override final def diff(that: SetforEach): SetforEach = {
      if (that(element))
        otherElements.diff(that)
      else
        otherElements.diff(that).add(element)
    }
    */
    
    // isSubsetOf NonEmpty Set
    /* 
    override final def isSubsetOf(that: SetforEach): Boolean =
      that(element) && otherElements.isSubsetOf(that)
    */

    // hashCode
    /* override final def hashCode: Int = element.hashCode + otherElements.hashCode */

    // Size of NonEmpty Set
    /* override final def size: Int = 1 + otherElements.size */

    // isEmpty on NonEmpty Set
    override final def isEmpty: Boolean = false

    // isSingleton on NonEmpty Set
    /* override final def isSingleton: Boolean = otherElements.isEmpty */

    // sample of NonEmpty Set
    /* override final def sample: Option[String] = Some(element) */

    // foreach on NonEmpty Set
    /* 
    def foreach(function: String => Unit): Unit = {
      function(element)
      otherElements.foreach(function)
    }
    */
  }

  private object NonEmpty {
    private[this] def unapply(any: Any): Option[(String, Set)] = {
      patternMatchingNotSupported
    }
  }

  // ----------------Implementation of Empty Set -------------------------//

  // We ll have a private object named `Empty`, that ll extend Trait Set
  private object Empty extends SetforEach {
    // def apply(input: String): Boolean = false

    /*
    Add in Empty Set
    that is actually the production of NonEmpty Sets. As soon as, you add something in the NonEmpty Set, it becomes a nonempty set
     */
    /* override final def add(input: String): SetforEach = NonEmpty(input, Empty) */

    // Remove in Empty Set     
    /* override final def remove(input: String): SetforEach = this */
    
    
     // Union in Empty Set
    /* override final def union(that: SetforEach): SetforEach = that */

    // Intersection in Empty Set
    /* override final def intersect(that: SetforEach): SetforEach = this */

    // Difference in Empty Set
    /* override final def diff(that: SetforEach): SetforEach = this */

    // isSubsetOf Empty Set
    /* override final def isSubsetOf(that: SetforEach): Boolean = true */

    // Size of Empty Set
    /* override final def size: Int = 0 */

    // isEmpty on Empty Set
    override final def isEmpty: Boolean = true

    // isSingleton on Empty Set
    /* override final def isSingleton: Boolean = false */

    // Sample of Empty Set
    /* override final def sample: Option[String] = None */

    // `foreach` on Empty Set
    
    /* 
    def foreach(function: String => Unit): Unit = {
      ()
    }
   */

    private[this] def unapply(any: Any): Option[(String, Set)] = {
      patternMatchingNotSupported
    }
  }

  /*
  Empty Set provides the implementation of `(String => Boolean)`
  val empty: Set = input => false
  As we have an object named `Empty` which has same `apply` implementation, we need to use it for Set [`val empty: OldSet = input => false`]
  */

  // The companion object `Set/SetforEach` has `unapply` method;
  // make it `private` to make unaccessable. & making any as `Any`, insteadOf `Set` type to restrict any value
  private[this] def unapply(any: Any): Option[(String, Set)] = {
    patternMatchingNotSupported
  }

  private[this] def patternMatchingNotSupported: Nothing = sys.error("Pattern matching on Sets is expensive and therefore not supported")

  val empty: SetforEach = Empty

}
