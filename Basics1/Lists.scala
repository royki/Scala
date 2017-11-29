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