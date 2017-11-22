object if_while extends Any {
	def main(args: Array[String]): Unit = {
		var i = 0
		// It is a statement not expression
		while(i < 10) {
			println(i)
			i += 1 
		}

		// do..while
		do {
			println(i)
			i += 1			
		} while(i < 10)
	}

	// if else 
	// they are statement in other language
	if(age < 18 ) {
		println("Not allowed")
	} else {
		println("Allowed")
	}

	//  In scala If Else also an expression
	val response = if(age < 18 ) {
		"Not allowed"
	} else {
		"Allowed"
	}	
	println(response)

	// If as expression. If is used as expression and dont have else, the else is implicitly defined to give back unit
	println(if(age < 18) " Not Allowed." else "Allowed")

	// not good decoration as val a is type Any
	val a = if(true) "hi" else 5 
}