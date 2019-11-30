import scala.io.Source._
import scala.collection.mutable.ArrayBuffer

object PrintCountry extends App {

	// val readCountry = io.Source.fromFile("H:/Scripts/Scala/luna/csv/countries.csv", "UTF-8")
	// for (line <- readCountry.getLines) {
	// 	val cols = line.split(",").map(_.trim)
	// 	println(s"${cols(2)} | ${cols(3)}")
	// }
	// readCountry.close
    
	// each row is an array of strings
	val rows = ArrayBuffer[Array[String]]()
	// read csv file
	val readCountry = using(io.Source.fromFile("H:/Scripts/Scala/luna/csv/countries.csv", "UTF-8")) {
		source => for(line <- source.getLines) {
			rows += line.split(",").map(_.trim)
		}
	}
	// print the results
	for( row <- rows) {
		println(s"${row(0)} | ${row(1)} | ${row(2)}")
	}
	

	def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B =
        try {
            f(resource)
        } finally {
            resource.close()
    }
}