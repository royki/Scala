import scala.io.Source._

object PrintAirPort extends App {

	val readAirport = io.Source.fromFile("H:/Scripts/Scala/luna/csv/airports.csv", "UTF-8")
	for(line <- readAirport.getLines.drop(1)) {
		val cols = line.split(",").map(_.trim)
		println(s"${cols(2)} | ${cols(3)}")
	}

	readAirport.close

}