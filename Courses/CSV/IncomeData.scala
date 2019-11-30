//This program reads and does a little analysis of Income data
//import scala.io.Source

def lineToTuple(line:String): (String, Array[Double]) = {
	val parts = line.split(",")
	val header = parts(1).trim
	//println(header.toString)
	val data = parts.drop(2).map(_.toDouble)
	(header,data)
}

for( i <- 0 to 4) readLine

//val source = Source.fromFile("download.csv")
val yearLine = readLine
val dataLines = for( i <- 0 to 20) yield readLine

val incomeData = dataLines.map(lineToTuple)
incomeData.foreach(id => println(id._1+" "+id._2.mkString(",")))
//incomeData.foreach(id => println(id._2.mkString(",")))

val diffs = for((h,data) <- incomeData) yield {
	val diff = for (i <- 0 until data.length-1) yield data(i+1)-data(i)
	//val diff = for((y1,y2) <- data.zip(data.tail)) yield y2-y1
	(h,diff)
}

//println(diffs(0)._2.mkString(", "))

