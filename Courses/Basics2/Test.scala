import scala.io.StdIn._
import scala.io.Source
import java.io.PrintWriter

object Test {
	def main(args: Array[String]): Unit = {
		
		// read from file
		val textFile = Source.fromFile("test.txt")
		val textLines = textFile.getLines()

		// make array of string	
		val lines = textLines.map(line => line.split(" ").map(_.toString)).toArray
		textFile.close()

		// write to new file
		val pw = new PrintWriter("pw.txt")
		// lines.foreach{row => pw.println(row.mkString(" ").toUpperCase)}
		// lines.foreach{row => pw.println(row.mkString(" ").drop(1))}
		// lines.foreach{row => pw.println(row.drop(1).mkString(" "))}
		// lines.foreach{row => pw.println(row.mkString(" ").filter(c => "scala".contains(c)))}
		lines.foreach{row => pw.println(row.mkString(" ").filter(_ < 'i'))}
		pw.close()

	}	
}