import scala.io.Source._

object PrintRunways extends App {
	// val readRunways = io.Source.fromFile("H:/Scripts/Scala/luna/csv/runways.csv", "UTF-8")
	// var count = 0
	// for(line <- readRunways.getLines) {
	// 	val cols = line.split(",").map(_.trim)
	// 	println(s"${cols(2)}")
	// 	count += 1
	// }
	// println("Total: "+count)

	case class Runways(airportId: String, surface: String)

	def parseData(line: String): Runways = {
		val p = line.split(",")
		val airportId = p(2)
		val surface = p(5)
		Runways(airportId, surface)
	}

	val readRunways = io.Source.fromFile("H:/Scripts/Scala/luna/csv/runways.csv", "UTF-8")
	val lines = readRunways.getLines.drop(1).filter(_.contains(",")).map(parseData).toArray
	readRunways.close

	// println("AirportID "+ lines.map(_.airportId.mkString(" ")))
	for (line <- lines) {
		val airId = lines.map(_.airportId)
		println(airId.mkString(" "))
	}
}