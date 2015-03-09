import xml._

/*val testXML = XML.loadFile("simple.xml")
val menu = testXML \ "breakfast_menu"
println(menu.map(e => e \\ "@name").mkString(","))
println(testXML \\ "breakfast_menu")
println(testXML \\ "price")
*/

case class Grade(value: Int, comment: Option[String]) 
case class Student(name: String, quiz: List[Grade], test: List[Grade], assignments: List[Grade])

def toGrade(node: Node): Grade = {
	//println(node.text)
	val value = (node \ "@value").text.toInt
	val comments = (node \ "comment").map(_.text)
	val comment = if(comments.isEmpty) None else Some(comments.head)
	Grade(value,comment)
}


def toStudent(node: Node): Student = {
	val name = (node \ "@name").text
	val quiz = (node \ "quiz").map(toGrade).toList
	val test = (node \ "test").map(toGrade).toList
	val assignments = (node \ "assignment").map(toGrade).toList
	Student(name,quiz,test,assignments)
}

def gradeToXML(g: Grade, t: String): Node = { 	
		def makeComments = g.comment match {
				case Some(c) => <comment>{c}</comment>
				case None => ""
			}
		t match {
		case "quiz" =>
			<quiz value={g.value.toString}>
			{makeComments}		
			</quiz>
		case "test"	 =>
			<test value={g.value.toString}>
			{makeComments}		
			</test>
		case "assignment" => 
			<assignment value={g.value.toString}>
			{makeComments}		
			</assignment>
	}
}

def studentToXML(s: Student): Node = {
	<student name={s.name}> A
		{s.quiz.map(n => gradeToXML(n,"quiz"))}
		{s.test.map(n => gradeToXML(n,"test"))}
		{s.assignments.map(n => gradeToXML(n,"test"))}
	</student>
}

val gradeXML = XML.loadFile("grades.xml")
val std = (gradeXML \ "student").map(toStudent).toArray
// println(std.map(e => e \ "@name").mkString("\n"))
// println(testXML \\ "quiz")
std.foreach(println)
XML.save("grades2.xml", <grades>{std.map(studentToXML)}</grades>)

