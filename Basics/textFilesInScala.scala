import scala.io.StdIn._
import scala.io.Source
import java.io.PrintWriter

object TextFilesInScala {
	def main(args: Array[String]): Unit = {
		// Source Type gives back sequence but it is iterator, not array or list
		// Iterator consumed as it's used
		// Fundamental method of iterator is next() and hasNext()
		// Iterator also have map,filter
		// Source is iterator of character
		// Source has method to read line -> getLines()		
		val source = Source.fromFile("matrix.txt")
		// source.next() // iterator of character
		val lines = source.getLines() // iterator of Strings => read whole line
		val buildMatrix = lines.map(line => line.split(" ").map(_.toDouble)).toArray
		// lines.map(line => line.split(" ") -> Iterator Array of String
		// lines.map(line => line.split(" ").map(_.toDouble) -> Iterator Array of Double
		// lines.map(line => line.split(" ").map(_.toDouble)).toArray -> Array of Double
		source.close()		
		val pw = new PrintWriter("sumOfRows.txt")		
		buildMatrix.foreach{row => pw.println(row.sum)}
		// buildMatrix.foreach{row => pw.println(row.filter(_<20).sum)}
		// buildMatrix.foreach{row => pw.println(row.filter(_<50).mkString(" "))}
		pw.close()
	}
}