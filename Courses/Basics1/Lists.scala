// Read list of a given length
def readList(length: Int): List[Int] = {
	if(length < 1) Nil
	else readInt() :: readList(length-1)
}

// Read list of unknown length
def readListUntilQuit() : List[Int] = {
	val word = readLine()
	if(word == "quit") Nil
	else word.toInt :: readListUntilQuit()
}
// Sum list
def sumList(lst: List[Int]): Int = {
	if(lst.isEmpty) 0
	else lst.head + sumList(lst.tail)
}
// List of tuples with names and values
def readNamesAndAges(): List[(String, Int)] = {
	val name = readLine()
	if(name == "quit") Nil
	else {
		val age = readInt()
		(name,age) :: readNamesAndAges()
	}
}
// Find the smallest one
def findSmallest(lst: List[(String, Int)]): (String, Int) = {
	if(lst.tail.isEmpty) lst.head
	else {
		val smallest = findSmallest(lst.tail)
		if(lst.head._2 <= smallest._2) lst.head else smallest
	}
}


// Code using functions
val lst = readListUntilQuit()
println(lst)
println(sumList(lst))

val people = readNamesAndAges()
println(people)

println("Yougest one:: " +findSmallest(people))

def scaleList(list: List[Double], factor: Double): List[Double] = list match {
	case Nil => list
	case head :: tail => head * factor :: scaleList(tail, factor)
}

def scaleList(list: List[Double], factor: Double): List[Double] = {
	list.map (x => x * factor)
}

def squareList(xs: List[Double]): List[Double] = xs match {
	case Nil =>  Nil
	case head :: tail => head*head :: squareList(tail)
}

def squareList(xs: List[Double]): List[Double] =  {
	xs.map(x => x * x)
}

def  posElems(xs: List[Int]): List[Int] = xs match {
	case Nil => Nil
	case head :: tail => if(head > 0) head :: posElems(tail) else posElems(tail)
}

def posElems(xs: List[Int]): List[Int] = {
	xs.filter( x => x > 0)
}

scala> val nums = List(2, 4, -2, 5, 9, 1, 3)
nums: List[Int] = List(2, 4, -2, 5, 9, 1, 3)

nums.filter(x => x > 0)
res0: List[Int] = List(2, 4, 5, 9, 1, 3)

nums.filterNot(x => x > 0)
res1: List[Int] = List(-2)

// partition is filter and filterNot in one go; it returns in pair
nums.partition(x => x > 0)
res2: (List[Int], List[Int]) = (List(2, 4, 5, 9, 1, 3),List(-2))

// take longest prefix while predicate is true
scala> nums.takeWhile(x => x > 0)
res3: List[Int] = List(2, 4)

// drop the prefix and take suffix while predicate is true
scala> nums.dropWhile(x => x > 0)
res4: List[Int] = List(-2, 5, 9, 1, 3)

// prefix and suffix together in one go; 
scala> nums.span(x => x > 0)
res5: (List[Int], List[Int]) = (List(2, 4),List(-2, 5, 9, 1, 3))

// Function return consecutive duplicates (pack function)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => 
  	val(first, rest) = xs.span(y => y == x) 
  	first :: pack(rest)
}

def encode[T](xs: List[T]): List[(T, Int)] = {
	pack(xs).map(ys => (ys.head, ys.length))
}

scala> pack(List("a", "a", "a", "b", "c", "c", "a"))
res7: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))

scala> encode(List("a", "a", "a", "b", "c", "c", "a"))
res8: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))

def sumOfList(xs: List[Int]): Int = xs match {
	case Nil => 0
	case head :: tail => head + sumOfList(tail)
}

// reduceLeft can only be applied in non empty list
def sumOfList(xs: List[Int]): Int = (0 :: xs).reduceLeft((x, y) => x + y)
def productOfList(xs: List[Int]): Int = (1 :: xs).reduceLeft((x, y) => x * y)

// foldLeft is defined in terms of more general function 
// foldLeft is like reduceLeft but it takes an accumulator, z, as an additional parameter, which
// is returned when foldLeft is called on an empty list

def sumOfList(xs: List[Int]): Int = xs.foldLeft(0){(x, y) => x + y}
def productOfList(xs: List[Int]): Int = xs.foldLeft(1){(x, y) => x * y}

def lengthFun[T](xs: List[T]): Int = (xs foldRight 0)( ??? )