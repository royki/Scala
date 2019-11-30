import scala.io.Source

val source = Source.fromFile("emma.txt")
val lines = source.getLines
val text = lines.map(line => line.split(",").map(_.toString))
source.close
source.foreach(r => println(r.mkString(" ")))
//println(source.mkString)