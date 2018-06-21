def readAndSum(n: Int): Int = {
	if(n< 1) 0 
	else {
		println("Enter a grade :: =>")
		val grade = readInt
		grade + readAndSum(n-1)
	}	
}

def readAndProduct(n: Int): Int = {
	if(n < 1) 1 
	else {
		println("Enter a grade ::+>")
		val grade = readInt
		grade * readAndProduct(n-1)
	}
}
//readAndCombine(3,0,(x,y) => x+y) // 0 base case
//readAndCombine(3,1,(x,y) => x*y) // 1 base case
//readAndCombine(3,0, _+_ ) // short syntax
def readAndCombine(n: Int, base: Int, combineFunc: (Int, Int) => Int): Int = {
	if(n < 1) base 
	else {
		println("Enter a grade ::+>")
		val grade = readInt
		combineFunc(grade, readAndCombine(n-1, base, combineFunc))
	}
}

/*
print("Number of Grades :: ->")
val numGrade = readInt
val prodGrade = SumAndProduct(numGrade)
println("The Avg is : " + prodGrade.toDouble/numGrade)*/