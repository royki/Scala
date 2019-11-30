import collections.Set

import org.scalatest._

class SetSuite extends FunSuite with Matchers {

  private def randomString: String =
    scala.util.Random.alphanumeric.take(5).mkString

  test("apply on an empty Set should yield false") {
    Set.empty(randomString) shouldBe false
    Set.empty.size shouldBe 0
  }

  // Test add element of Set
  test("add on an empty Set should yield a new Set with one element") {
    val first = randomString
    val second = randomString

    first should not be second

    val set = Set.empty.add(first)

    set(first) shouldBe true
    set(second) shouldBe false
  }

  test("add on an nonEmpty Set should yield a new Set with two element") {
    val first = randomString
    val second = randomString

    first should not be second

    val set = Set.empty.add(first).add(second)

    set(first) shouldBe true
    set(second) shouldBe true
  }

  // Test remove element of Set
  test("remove on an empty Set should yield an empty Set") {
    val element = randomString
    val stillEmpty = Set.empty.remove(element)
    stillEmpty(element) shouldBe false
  }

  test("remove on a nonEmpty Set should yield a new Set without element") {
    val element = randomString

    val setWithElement = Set.empty.add(element)

    setWithElement(element) shouldBe true

    val setWithoutElement = setWithElement.remove(element)

    setWithoutElement(element) shouldBe false
  }

  test("remove removes only the element in questions") {
    val first = randomString
    val second = randomString

    val setWithElement = Set.empty.add(first).add(second)

    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true

    val setWithoutElement = setWithElement.remove(first)

    setWithoutElement(first) shouldBe false
    setWithoutElement(second) shouldBe true
  }

  test("remove removes only the element in questions 2") {
    val first = randomString
    val second = randomString

    val setWithElement = Set.empty.add(first).add(second)

    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true

    val setWithoutElement = setWithElement.remove(second)

    setWithoutElement(first) shouldBe true
    setWithoutElement(second) shouldBe false
  }

  test("add/remove combo should ensure that all elements are distinct") {
    val element = randomString
    val set = Set.empty.add(element).add(element).remove(element)
    set(element) shouldBe false
  }

  // Test uninon element of Set
  test("union on empty Set should yield an empty Set") {
    Set.empty.union(Set.empty)(randomString) shouldBe false

    // Test Equality on Set
    val empty = Set.empty
    val uninon = empty.union(empty)

    empty.isSubsetOf(uninon) shouldBe true
    uninon.isSubsetOf(empty) shouldBe true

    Set.empty.union(Set.empty) shouldBe Set.empty
  }

  test(
    "union on non empty Set with an empty Set should yield the original Set untouched"
  ) {
    // val nonEmptySet = Set.empty.add(randomString)
    // Set.empty.union(nonEmptySet) shouldBe true

    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = Set.empty
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

    val left = Set.empty.add(a).add(b)
    val right = Set.empty.add(c).add(d)

    // As we have the equality function, so we can test the using equality function
    /*
    left.union(right)(a) shouldBe true
    left.union(right)(b) shouldBe true
    left.union(right)(c) shouldBe true
    left.union(right)(d) shouldBe true

    right.union(left)(a) shouldBe true
    right.union(left)(b) shouldBe true
    right.union(left)(c) shouldBe true
    right.union(left)(d) shouldBe true
     */

    // Test with equality on Set
    left.union(right) shouldBe Set.empty.add(a).add(b).add(c).add(d)
    right.union(left) shouldBe Set.empty.add(a).add(b).add(c).add(d)

  }

  // Test intersection element of Set
  test("intersection on empty Set should yield an empty Set") {
    // Set.empty.intersect(Set.empty) shouldBe Set.empty // this is failing as there is no equality function
    Set.empty.intersect(Set.empty)(randomString) shouldBe false
  }

  test(
    "intersection on non empty Set with an empty Set should yield the original Set untouched"
  ) {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = Set.empty
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

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(c).add(d).add(e)

    // As we have the equality function, so we can test using equality function
    /*
    val intersectionLeft = left.intersect(right)

    intersectionLeft(a) shouldBe false
    intersectionLeft(b) shouldBe false
    intersectionLeft(c) shouldBe true
    intersectionLeft(d) shouldBe false
    intersectionLeft(e) shouldBe false

    val intersectionRight = right.intersect(left)

    intersectionRight(a) shouldBe false
    intersectionRight(b) shouldBe false
    intersectionRight(c) shouldBe true
    intersectionRight(d) shouldBe false
    intersectionRight(e) shouldBe false
     */

    // As we have the equality function, so we can test the above using equality function
    // Test with equality on Set
    left.intersect(right) shouldBe Set.empty.add(c)
    right.intersect(left) shouldBe Set.empty.add(c)
  }

  // Test difference element of Set
  test("difference on empty Set should yield an empty Set") {
    Set.empty.diff(Set.empty)(randomString) shouldBe false
  }

  test(
    "difference on a non empty Set with an empty Set should yield an empty Set"
  ) {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = Set.empty
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

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(b).add(c).add(d)

    // As we have the equality function, so we can test using equality function
    /*
    val leftDifference = left.diff(right)

    leftDifference(a) shouldBe true
    leftDifference(b) shouldBe false
    leftDifference(c) shouldBe false
    leftDifference(d) shouldBe false

    val rightDifference = right.diff(left)

    rightDifference(a) shouldBe false
    rightDifference(b) shouldBe false
    rightDifference(c) shouldBe false
    rightDifference(d) shouldBe true
     */

    // As we have the equality function, so we can test the above using equality function
    left.diff(right) shouldBe Set.empty.add(a)
    right.diff(left) shouldBe Set.empty.add(d)

  }

  // Test subset property of Set
  test("isSubsetOf on an empty Set should yield true") {
    // pending
    Set.empty.isSubsetOf(Set.empty) shouldBe true
    Set.empty.isSubsetOf(Set.empty.add(randomString)) shouldBe true
  }

  test("isSubsetOf on itself should yield true") {
    // pending
    val set = Set.empty.add(randomString)
    set.isSubsetOf(set) shouldBe true
  }

  test("isSubsetOf on a non empty set should yield false") {
    val a = randomString
    val b = randomString
    val c = randomString

    val left = Set.empty.add(a).add(b)
    val right = left.add(c)

    left.isSubsetOf(right) shouldBe true
    right.isSubsetOf(left) shouldBe false
  }

  // Test superset property of Set
  test("isSupersetOf on an empty Set should yield true") {
    // pending
    Set.empty.isSupersetOf(Set.empty) shouldBe true
    Set.empty.add(randomString).isSupersetOf(Set.empty) shouldBe true
    Set.empty.isSupersetOf(Set.empty.add(randomString)) shouldBe false
  }

  test("isSupersetOf on itself should yield true") {
    // pending
    val set = Set.empty.add(randomString)
    set.isSupersetOf(set) shouldBe true
  }

  test("isSupersetOf on a non empty set should yield false") {
    val a = randomString
    val b = randomString
    val c = randomString

    val left = Set.empty.add(a).add(b)
    val right = left.add(c)

    left.isSupersetOf(right) shouldBe false
    right.isSupersetOf(left) shouldBe true
  }

  // ** As we're using `case class`, equality & hashCode are free from `case class`
  // ** i.e. equality & hashCode are generated from `case class`
  // Test hashcode in Set
  test("hashCode on an empty Set should not be random") {
    Set.empty.hashCode shouldBe Set.empty.hashCode
    val element = randomString
    Set.empty.add(element).hashCode shouldBe Set.empty.add(element).hashCode
  }

  test("hashCode on an empty Set should not be 0") {
    Set.empty.hashCode should not be 0
  }

  // Test of size of Set
  test(
    "hashCode on a non empty Set should be the sum of all the hashCodes and the hashCode of the empty Set"
  ) {
    val first = randomString
    val second = randomString

    val expected = Set.empty.hashCode + first.hashCode + second.hashCode

    Set.empty.add(first).add(second).hashCode shouldBe expected
  }

  test("size on an empty Set should be 0") {
    Set.empty.size shouldBe 0
  }

  test("size on a non empty Set should be 1") {
    Set.empty.add(randomString).size shouldBe 1
  }

  test("size on a non empty Set with 2 distinct elements added should be 2") {
    val first = randomString
    val second = randomString

    first should not be second

    Set.empty.add(first).add(second).size shouldBe 2
  }

  test("size on a non empty Set with 2 equal elements added should be 1") {
    val element = randomString

    Set.empty.add(element).add(element).size shouldBe 1
  }

  // Test empty of Set
  test("isEmpty on an empty Set should yield true") {
    Set.empty.isEmpty shouldBe true
    Set.empty.nonEmpty shouldBe false
  }

  test("isEmpty on a non empty Set should yield false") {
    Set.empty.add(randomString).isEmpty shouldBe false
    Set.empty.add(randomString).nonEmpty shouldBe true
  }

  // Test isSingleton on Set
  test("isSingleton on an empty Set should yield false") {
    Set.empty.isSingleton shouldBe false
  }

  test("isSingleton on a Set with more than one element should yield false") {
    val first = randomString
    val second = randomString

    first should not be second

    Set.empty.add(first).add(second).isSingleton shouldBe false
  }

  test("isSingleton on a Set with a single element should yield true") {
    Set.empty.add(randomString).isSingleton shouldBe true
  }

  test("sample should yield a random element from the Set") {
    Set.empty.sample shouldBe None

    val a = randomString
    Set.empty.add(a).sample shouldBe Some(a)

    val b = randomString
    Set.empty.add(a).add(b).sample should contain oneOf (a, b)
  }

}
