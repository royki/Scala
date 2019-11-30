object List {
	def main(args: Array[String]): Unit = {
		println("Enter value into List")
		val lst = buildList()
		println(lst)
		println(concatStrings(lst))
		println(concatStringsPatternMatch(lst))

	// using pattern
	val Array(a,b,c) = ("one two three").split(" ")

	}

	def buildList(): List[String] = {
		val input = readLine()
		if(input == "quit") Nil
		else input :: buildList()
	}

	// using head and tail
	def concatStrings(words: List[String]): String = {
		if(words.isEmpty) ""
		else words.head + "+" + concatStrings(words.tail)
	}

	// using pattern
	def concatStringsPatternMatch(words: List[String]): String = words match {
		case Nil => ""
		case head :: tail => head + "+" + concatStringsPatternMatch(tail)
	}

}
