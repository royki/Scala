import scala.io.Source

case class TempData(month: Int, year: Int, tAve: Double, tMax: Double, tMin: Double) 

def parseTemps(line: String):TempData = {
	val p = line.split(",")
	val month = p(2).toInt
	val year = p(1).toInt
	val ave = p(5).toDouble
	val max = p(4).toDouble
	val min = p(6).toDouble	
	TempData(month, year, ave, max, min)
}

val source = Source.fromFile("TX417945_1654.csv")
val lines = source.getLines
lines.next
lines.next
val tempData = lines.filter(!_.contains(",.")).map(parseTemps).toArray
source.close

println("Ave = "+tempData.map(_.tAve).sum/tempData.length)
println("Max = "+tempData.map(_.tMax).sum/tempData.length)
println("Min = "+tempData.map(_.tMin).sum/tempData.length)

for( year <- 1994 to 2011) {
	val yearData = tempData.filter(_.year==year)
	println("Ave of each year -> "+year+ "= "+yearData.map(_.tAve).sum/yearData.length)
}

for( month <- 1 to 12) {
	val monthData = tempData.filter(_.month==month)	
	println("Ave of each month -> "+month+ "= "+monthData.map(_.tAve).sum/monthData.length)
}

println("Max above 99 = " + tempData.count(_.tMax > 99))