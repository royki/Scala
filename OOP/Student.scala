package OOP

class Student(
	val firstName: String, 
	val lastName: String, 
	quizess: List[Int] = Nil, 
	assignments: List[Int] = Nil,
	tests: List[Int] = Nil) {

	def quizAverage: Double = if(quizess.isEmpty) 0.0 
		else if (quizess.length == 1) quizess.head
		else (quizess.sum - quizess.min).toDouble/(quizess.length -1)
	def assignmentAverage: Double = if(assignments.isEmpty) 0.0 
		else assignments.sum.toDouble/assignments.length
	def testAverage: Double = if(tests.isEmpty) 0.0 
		else tests.sum.toDouble/tests.length
	def average: Double = quizAverage * 0.1 + assignmentAverage * 0.5 + testAverage * 0.4
}