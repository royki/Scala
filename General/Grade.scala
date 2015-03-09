def readAndsum(n: Int): Int = {
	if(n< 1) 0 else {
		println("Enter a grade :: =>")
		val grade = readInt
		grade + readAndsum(n-1)
	}	
}

print("Number of Grades :: ->")
val numGrade = readInt
val sumGrade = readAndsum(numGrade)
println("The Avg is : " + sumGrade.toDouble/numGrade)