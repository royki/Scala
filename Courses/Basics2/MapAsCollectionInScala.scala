// Sequence of collections has one type parameter.
// Maps have two type parameter.

val nmap = Map(1 -> "A", 2 -> "B", 3 -> "C", 4 -> "D")
nmap(2)
nmap.apply(2)
nmap + (5 -> "E")
nmap - (1)

// Iterating Through Maps

val n = (1 to 100).map(i => i.toString -> i) // Gives sequence of tuple
// In sequence of tuple, we can use toMap
(1 to 100).map(i => i.toString -> i).toMap
// Maps generally doesn't preserve order
val m = n.take(5)
// Pattern match
for((k,v) <- m) println(k+ " "+ v)

//map on Map collection
n.map( t => t._1*2 -> t._2*2) // arguments is a map also

// If arguments in map is one argument, it ll return iterable list
n.map( t => t._1*2)

// Filter on Map
n.filer( t => t._2 < 5)
n.filer( t => t._1 < "5")


scala> val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
romanNumerals: scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -> 5, X -> 10)

scala> val capitalOfCOuntry = Map("US" -> "Washington", "Switzerlnd" -> "Bern")
capitalOfCOuntry: scala.collection.immutable.Map[String,String] = Map(US -> Washington, Switzerlnd -> Bern)


scala> capitalOfCOuntry("US")
res0: String = Washington

scala> capitalOfCOuntry("Andora")
java.util.NoSuchElementException: key not found: Andora
  at scala.collection.immutable.Map$Map2.apply(Map.scala:135)
  ... 28 elided

scala> capitalOfCOuntry.get("Andora")
res3: Option[String] = None

scala> capitalOfCOuntry.get("US")
res4: Option[String] = Some(Washington)

val cap1 = capitalOfCOuntry.withDefaultValue "<unknown>"
cap1("Andorra")

def showCapital(country: String) = capitalOfCOuntry.get(country) match {
	case Some(capital) => capital
	case None => "Missing Data"
}

showCapital("US") // "Washington"

// Options also support quite a few operations of the other collections like - map, flatMap, filter

// Two useful operation of SQL queries in addition to for-expressions are groupBy and orderBy

// orderBy on a collection can be expressed by sortWith and sorted

scala> val fruit = List("apple", "pear", "orange", "pineapple", "banana")
fruit: List[String] = List(apple, pear, orange, pineapple, banana)

scala> fruit.sortWith(_.length < _.length)
res8: List[String] = List(pear, apple, orange, banana, pineapple)

scala> fruit.sorted
res9: List[String] = List(apple, banana, orange, pear, pineapple)

// groupBy is available on Scala collection. It partitions a collection into a map of collections according to a discriminator function f.

scala> fruit.groupBy(_.head)
res10: scala.collection.immutable.Map[Char,List[String]] = Map(b -> List(banana), p -> List(pear, pineapple), a -> List(apple), o -> List(orange))


// Polynomial
// + operation on Polynomial
class Poly(val terms0: Map[Int, Double]) {
	// Auxillury constructor
	def this(bindings: (Int, Double)*) = this(bindings.toMap)

	val terms = terms0.withDefaultValue(0.0)

	def +(other: Poly) = new Poly(terms ++ (other.terms).map(adjust))

	def adjust(term: (Int, Double)): (Int, Double) = {
		val (exp, coeff) = term		
		// terms.get(exp) match {
		// 	case Some(coeff1) => exp -> (coeff + coeff1)
		// 	case None => exp -> coeff
		// }

		//Instead of pattern match, return the binding
		exp -> (coeff + terms(exp))
	}
	override def toString = (for((exp, coeff) <- terms.toList.sorted) yield coeff+"x^"+exp).mkString(" + ")
}


// + function is written with foldLeft
def +(other: Poly) = new Poly((other.terms.foldLeft(terms)addTerm))
def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
	val (exp, coeff) = term
	terms + (exp -> (coeff + terms(exp)))
}


val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
p1 + p2

// map is a partial function. Applying map to a key value in map(key) could lead to an exception., if the jey was not stored
// in the map. There is an operation "withDefaultValue" that turns map into a total function

