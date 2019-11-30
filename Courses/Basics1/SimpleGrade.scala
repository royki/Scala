println("What is the sum of the grades")
	val gradeSum = readInt
println("How many grades went into the sum")	
	val numGrades = readInt

if(numGrades < 1){
	println("NA")	
}else {
	val average = gradeSum.toDouble/numGrades
	println("The average is " + average)		
	val letterGrade = if(average >= 90) "A"
		else if(average >= 80){
			"B"
		} else if(average > 70){
			"C"
		}else if(average > 60){
			"D"
		}else "F"		
		
	println("The Letter grade is " +letterGrade)
}


