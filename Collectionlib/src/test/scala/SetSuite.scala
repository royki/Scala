import collections._

import org.scalatest._

class SetSuite extends FunSuite with Matchers {

  private def randomString: String =
    scala.util.Random.alphanumeric.take(5).mkString

  test("apply on an empty Set should yield false") {
    Set.empty(randomString) shouldBe false
  }

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

  // test("union on empty Set should yield an empty Set") {
  //   Set.empty.union(Set.empty)(randomString) shouldBe false
  // }

  // test("union on non empty Set with an empty Set should yield the original Set untouched") {
  //   // val nonEmptySet = Set.empty.add(randomString)
  //   // Set.empty.union(nonEmptySet) shouldBe true

  //   val first = randomString
  //   val second = randomString

  //   first should not be second

  //   val emptySet = Set.empty
  //   val nonEmptySet1 = emptySet.add(first).add(second)

  //   emptySet.union(nonEmptySet1)(first) shouldBe true
  //   emptySet.union(nonEmptySet1)(second) shouldBe true

  //   nonEmptySet1.union(emptySet)(first) shouldBe true
  //   nonEmptySet1.union(emptySet)(second) shouldBe true
  // }

  // test("union on two non empty Set with an empty Set should yield their union") {
  //   val a = randomString
  //   val b = randomString
  //   val c = randomString
  //   val d = randomString

  //   val left = Set.empty.add(a).add(b)
  //   val right = Set.empty.add(c).add(d)

  //   left.union(right)(a) shouldBe true
  //   left.union(right)(b) shouldBe true
  //   left.union(right)(c) shouldBe true
  //   left.union(right)(d) shouldBe true
  // }

  // test("intersection on empty Set should yield an empty Set") {
  //   // Set.empty.intersect(Set.empty) shouldBe Set.empty // this is failing as there is no equality function
  //   Set.empty.intersect(Set.empty)(randomString) shouldBe false
  // }

  // test("intersection on non empty Set with an empty Set should yield the original Set untouched") {
  //   val first = randomString
  //   val second = randomString

  //   first should not be second

  //   val emptySet = Set.empty
  //   val NonEmptySet = emptySet.add(first).add(second)

  //   emptySet.intersect(NonEmptySet)(first) shouldBe false
  //   emptySet.intersect(NonEmptySet)(second) shouldBe false

  //   NonEmptySet.intersect(emptySet)(first) shouldBe false
  //   NonEmptySet.intersect(emptySet)(second) shouldBe false
  // }

  // test("intersection on two non empty Set with an empty Set should yield their common Set") {
  //   val a = randomString
  //   val b = randomString
  //   val c = randomString
  //   val d = randomString
  //   val e = randomString

  //   val left = Set.empty.add(a).add(b).add(c)
  //   val right = Set.empty.add(c).add(d).add(e)

  //   val intersectionLeft = left.intersect(right)

  //   intersectionLeft(a) shouldBe false
  //   intersectionLeft(b) shouldBe false
  //   intersectionLeft(c) shouldBe true
  //   intersectionLeft(d) shouldBe false
  //   intersectionLeft(e) shouldBe false

  //   val intersectionRight = right.intersect(left)

  //   intersectionRight(a) shouldBe false
  //   intersectionRight(b) shouldBe false
  //   intersectionRight(c) shouldBe true
  //   intersectionRight(d) shouldBe false
  //   intersectionRight(e) shouldBe false
  // }

  // test("difference on empty Set should yield an empty Set") {
  //   Set.empty.diff(Set.empty)(randomString) shouldBe false
  // }

  // test("difference on a non empty Set with an empty Set should yield an empty Set") {
  //   val first = randomString
  //   val second = randomString

  //   first should not be second

  //   val emptySet = Set.empty
  //   val nonEmptySet = emptySet.add(first).add(second)

  //   emptySet.diff(nonEmptySet)(first) shouldBe false
  //   emptySet.diff(nonEmptySet)(second) shouldBe false

  //   nonEmptySet.diff(emptySet)(first) shouldBe true
  //   nonEmptySet.diff(emptySet)(second) shouldBe true
  // }

  // test("difference on two non empty Sets should yield their difference") {
  //   val a = randomString
  //   val b = randomString
  //   val c = randomString
  //   val d = randomString

  //   val left = Set.empty.add(a).add(b).add(c)
  //   val right = Set.empty.add(b).add(c).add(d)

  //   val leftDifference = left.diff(right)

  //   leftDifference(a) shouldBe true
  //   leftDifference(b) shouldBe false
  //   leftDifference(c) shouldBe false
  //   leftDifference(d) shouldBe false

  //   val rightDifference = right.diff(left)

  //   rightDifference(a) shouldBe false
  //   rightDifference(b) shouldBe false
  //   rightDifference(c) shouldBe false
  //   rightDifference(d) shouldBe true
  // }

  test("isSubsetOf on an empty Set should yield true") {
    pending

    Set.empty.isSubsetOf(Set.empty) shouldBe true
    Set.empty.isSubsetOf(Set.empty.add(randomString)) shouldBe true
  }
}
