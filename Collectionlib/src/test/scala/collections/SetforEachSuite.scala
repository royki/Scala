import collections.SetforEach

import org.scalatest._

class SetforEachSuite extends FunSuite with Matchers {

  private def randomString: String =
    scala.util.Random.alphanumeric.take(5).mkString

  test("apply on an empty Set should yield false") {
    // SetforEach.empty(randomString) shouldBe false
    SetforEach.empty(randomString) shouldBe false
    SetforEach.empty.size shouldBe 0
  }

  // Test add element of Set
  test("add on an empty Set should yield a new Set with one element") {
    val first = randomString
    val second = randomString

    first should not be second

    // Rewriting Test with `varargs`
    // val set = SetforEach(first)
    val set = SetforEach(first)
    
    set(first) shouldBe true
    set(second) shouldBe false
  }
  
  test("add on an nonEmpty Set should yield a new Set with two element") {
    val first = randomString
    val second = randomString
    
    first should not be second
    
    // Rewriting Test with `varargs`
    val set = SetforEach(first, second)

    set(first) shouldBe true
    set(second) shouldBe true
  }

  // Test remove element of Set
  test("remove on an empty Set should yield an empty Set") {
    val element = randomString
    val stillEmpty = SetforEach.empty.remove(element)
    stillEmpty(element) shouldBe false
  }

  test("remove on a nonEmpty Set should yield a new Set without element") {
    val element = randomString

    val setWithElement = SetforEach(element)

    setWithElement(element) shouldBe true

    val setWithoutElement = setWithElement.remove(element)

    setWithoutElement(element) shouldBe false
  }

  test("remove removes only the element in questions") {
    val first = randomString
    val second = randomString

    val setWithElement = SetforEach(first).add(second)

    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true

    val setWithoutElement = setWithElement.remove(first)

    setWithoutElement(first) shouldBe false
    setWithoutElement(second) shouldBe true
  }

  test("remove removes only the element in questions 2") {
    val first = randomString
    val second = randomString

    val setWithElement = SetforEach(first).add(second)

    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true

    val setWithoutElement = setWithElement.remove(second)

    setWithoutElement(first) shouldBe true
    setWithoutElement(second) shouldBe false
  }

  test("add/remove combo should ensure that all elements are distinct") {
    val element = randomString
    // val set = SetforEach(element).add(element).remove(element)
    val set = SetforEach(element, element).remove(element)
    set(element) shouldBe false
  }

  // Test uninon element of Set
  test("union on empty Set should yield an empty Set") {
    SetforEach.empty.union(SetforEach.empty)(randomString) shouldBe false

    // Test Equality on Set
    val empty = SetforEach.empty
    val uninon = empty.union(empty)

    empty.isSubsetOf(uninon) shouldBe true
    uninon.isSubsetOf(empty) shouldBe true

    SetforEach.empty.union(SetforEach.empty) shouldBe SetforEach.empty
  }

  test(
    "union on non empty Set with an empty Set should yield the original Set untouched"
  ) {
    // val nonEmptySet = SetforEach(randomString)
    // SetforEach.empty.union(nonEmptySet) shouldBe true

    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = SetforEach.empty
    val nonEmptySet1 = emptySet.add(first).add(second)

    emptySet.union(nonEmptySet1)(first) shouldBe true
    emptySet.union(nonEmptySet1)(second) shouldBe true

    nonEmptySet1.union(emptySet)(first) shouldBe true
    nonEmptySet1.union(emptySet)(second) shouldBe true
  }

  test("union on two non empty Set with an empty Set should yield their union") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    // val left = SetforEach(a).add(b)
    // val right = SetforEach(c).add(d)
    val left = SetforEach(a, b)
    val right = SetforEach(c, d)
    
    // Test with `varargs`
    left.union(right) shouldBe SetforEach(a).add(b).add(c).add(d)
    right.union(left) shouldBe SetforEach(a).add(b).add(c).add(d)

  }

  // Test intersection element of Set
  test("intersection on empty Set should yield an empty Set") {
    // Set.empty.intersect(Set.empty) shouldBe Set.empty // this is failing as there is no equality function
    SetforEach.empty.intersect(SetforEach.empty)(randomString) shouldBe false
  }

  test(
    "intersection on non empty Set with an empty Set should yield the original Set untouched"
  ) {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = SetforEach.empty
    val NonEmptySet = emptySet.add(first).add(second)

    emptySet.intersect(NonEmptySet)(first) shouldBe false
    emptySet.intersect(NonEmptySet)(second) shouldBe false

    NonEmptySet.intersect(emptySet)(first) shouldBe false
    NonEmptySet.intersect(emptySet)(second) shouldBe false
  }

  test(
    "intersection on two non empty Set with an empty Set should yield their common Set"
  ) {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString
    val e = randomString

    val left = SetforEach(a, b, c)
    val right = SetforEach(c, d, e)

    
    left.intersect(right) shouldBe SetforEach(c)
    right.intersect(left) shouldBe SetforEach(c)
  }

  // Test difference element of Set
  test("difference on empty Set should yield an empty Set") {
    SetforEach.empty.diff(SetforEach.empty)(randomString) shouldBe false
  }

  test(
    "difference on a non empty Set with an empty Set should yield an empty Set"
  ) {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = SetforEach.empty
    val nonEmptySet = emptySet.add(first).add(second)

    emptySet.diff(nonEmptySet)(first) shouldBe false
    emptySet.diff(nonEmptySet)(second) shouldBe false

    nonEmptySet.diff(emptySet)(first) shouldBe true
    nonEmptySet.diff(emptySet)(second) shouldBe true
  }

  test("difference on two non empty Sets should yield their difference") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    val left = SetforEach(a, b, c)
    val right = SetforEach(b, c, d)


    // As we have the equality function, so we can test the above using equality function
    left.diff(right) shouldBe SetforEach(a)
    right.diff(left) shouldBe SetforEach(d)

  }

  // Test subset property of Set
  test("isSubsetOf on an empty Set should yield true") {
    // pending
    SetforEach.empty.isSubsetOf(SetforEach.empty) shouldBe true
    SetforEach.empty.isSubsetOf(SetforEach(randomString)) shouldBe true
  }

  test("isSubsetOf on itself should yield true") {
    // pending
    val set = SetforEach(randomString)
    set.isSubsetOf(set) shouldBe true
  }

  test("isSubsetOf on a non empty set should yield false") {
    val a = randomString
    val b = randomString
    val c = randomString

    val left = SetforEach(a).add(b)
    val right = left.add(c)

    left.isSubsetOf(right) shouldBe true
    right.isSubsetOf(left) shouldBe false
  }

  // Test superset property of Set
  test("isSupersetOf on an empty Set should yield true") {
    // pending
    SetforEach.empty.isSupersetOf(SetforEach.empty) shouldBe true
    SetforEach.empty
      .add(randomString)
      .isSupersetOf(SetforEach.empty) shouldBe true
    SetforEach.empty.isSupersetOf(SetforEach(randomString)) shouldBe false
  }

  test("isSupersetOf on itself should yield true") {
    // pending
    val set = SetforEach(randomString)
    set.isSupersetOf(set) shouldBe true
  }

  test("isSupersetOf on a non empty set should yield false") {
    val a = randomString
    val b = randomString
    val c = randomString

    val left = SetforEach(a).add(b)
    val right = left.add(c)

    left.isSupersetOf(right) shouldBe false
    right.isSupersetOf(left) shouldBe true
  }

  // ** As we're using `case class`, equality & hashCode are free from `case class`
  // ** i.e. equality & hashCode are generated from `case class`
  // Test hashcode in Set
  test("hashCode on an empty Set should not be random") {
    SetforEach.empty.hashCode shouldBe SetforEach.empty.hashCode
    val element = randomString
    SetforEach(element).hashCode shouldBe SetforEach.empty
      .add(element)
      .hashCode
  }

  test("hashCode on an empty Set should not be 0") {
    SetforEach.empty.hashCode should not be 0
  }

  // Test of size of Set
  test(
    "hashCode on a non empty Set should be the sum of all the hashCodes and the hashCode of the empty Set"
  ) {
    val first = randomString
    val second = randomString

    val expected = SetforEach.empty.hashCode + first.hashCode + second.hashCode

    SetforEach(first).add(second).hashCode shouldBe expected
  }

  test("size on an empty Set should be 0") {
    SetforEach.empty.size shouldBe 0
  }

  test("size on a non empty Set should be 1") {
    SetforEach(randomString).size shouldBe 1
  }

  test("size on a non empty Set with 2 distinct elements added should be 2") {
    val first = randomString
    val second = randomString

    first should not be second

    SetforEach(first).add(second).size shouldBe 2
  }

  test("size on a non empty Set with 2 equal elements added should be 1") {
    val element = randomString

    SetforEach(element).add(element).size shouldBe 1
  }

  // Test empty of Set
  test("isEmpty on an empty Set should yield true") {
    SetforEach.empty.isEmpty shouldBe true
    SetforEach.empty.nonEmpty shouldBe false
  }

  test("isEmpty on a non empty Set should yield false") {
    SetforEach(randomString).isEmpty shouldBe false
    SetforEach(randomString).nonEmpty shouldBe true
  }

  // Test isSingleton on Set
  test("isSingleton on an empty Set should yield false") {
    SetforEach.empty.isSingleton shouldBe false
  }

  test("isSingleton on a Set with more than one element should yield false") {
    val first = randomString
    val second = randomString

    first should not be second

    SetforEach(first, second).isSingleton shouldBe false
  }

  test("isSingleton on a Set with a single element should yield true") {
    SetforEach(randomString).isSingleton shouldBe true
  }

  // Test sample
  test("sample should yield a random element from the Set") {
    SetforEach.empty.sample shouldBe None

    val a = randomString
    SetforEach(a).sample shouldBe Some(a)

    val b = randomString
    SetforEach(a, b).sample should contain oneOf (a, b)
  }

  test("foreach on empty Set should not apply the function") {
    noException should be thrownBy SetforEach.empty.foreach { _ =>
      sys.error("should not be thrown")
    }
  }

  // Test Set with `foreach`
  test("foreach on a non empty Set should apply the function") {
    var functionWasApplied = false

    SetforEach.empty
      .add(randomString)
      .foreach(
        _ => functionWasApplied = true
      )

    functionWasApplied shouldBe true
  }

  test("foreach should be able to calculate the size of the given set 0") {
    var size = 0
    val set = SetforEach.empty
    set.foreach(_ => size += 1)

    size shouldBe 0
    size shouldBe set.size
  }

  test("foreach should be able to calculate the size of the given set 1") {
    var size = 0
    val set = SetforEach(randomString)
    set.foreach(_ => size += 1)

    size shouldBe 1
    size shouldBe set.size
  }

  test("foreach should be able to calculate the size of the given set 2") {
    var size = 0
    val set = SetforEach(randomString, randomString)
    set.foreach(_ => size += 1)

    size shouldBe 2
    size shouldBe set.size
  }

  test(
    "foreach should be able to calculate the size of the given set with same element"
  ) {
    var size = 0
    val element = randomString
    val set = SetforEach(element, element)
    set.foreach(_ => size += 1)

    size should not be 2
    size shouldBe set.size
  }

  test("Set() should not compile") {
    "SetforEach()" shouldNot compile
  }

  test("Calling the varargs apply method on the Set companion object should yield a Set with all the arguments as elements") {
    val a = randomString
    val b = randomString
    val c = randomString

    SetforEach(a, b, c) shouldBe SetforEach.empty.add(a).add(b).add(c)
  }
}
