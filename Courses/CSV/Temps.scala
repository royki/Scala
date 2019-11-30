def readAllLines(index: Int, lines: Array[String]) {
	if(index < lines.length){
		lines(index) = readLine
		readAllLines(index+1, lines)
	}
}

def extraxtData(line: String):(Int, Int, Double, Double, Double, Double) = {
	val parts = line.split(",")
	( parts(1).toInt, parts(2).toInt, parts(3).toDouble, 
		parts(4).toDouble, parts(5).toDouble, parts(6).toDouble)
}

val numLines = readInt
val lines = new Array[String](numLines)
readAllLines(0,lines)

val data = lines.filter(!_.contains(",..,")).map(extraxtData)

/*val highs = lines.filter(!_.contains(",..,")).map(l => {
	val parts = l.split(",")
	parts(2).toDouble	
})
*/

println("Enter a date in mm/yyyy format")
val date = readLine
val Array(mStr,yStr) = date.split("/")
println(date)
//val day = dStr.toInt
val month = mStr.toInt
val year = yStr.toInt
val record = data.find(d => d._2 == month && d._1 == year)

record match {
	case Some((_,_,_,high,av,low)) => 
		println("Compare avarage to " +av+ " High and Low " +(high+low)/2)
	case None => 
		println("No record found")
}

println(record)

/*println(lines.last)
println(highs.last)
println("Hot days = " +highs.count(_>=10))
println("Hottest day = " +highs.max)*/