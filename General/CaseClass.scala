import scala.io.Source

case class Player(name: String, made: Int, attempted: Int, rebounds: Int, points: Int) 

def makePlayer(line: String): Player = {
	val p = line.split("\t")
	val name = p(0)
	val shots = p(2).split("-")
	val made = shots(0).toInt
	val attempted = shots(1)toInt
	val rebounds = p(7).toInt
	val points = p(14).toInt
	Player(name,made,attempted,rebounds,points)
}

/*def source(readSource: File):File = {
	if(!readSource)
		println("Not found")
	else Source.fromFile("boxscore.txt")
}*/

val source = Source.fromFile("boxscore.txt")
val lines = source.getLines
val players = lines.map(makePlayer).toArray
source.close

players.foreach(println)
println(players.map(_.points).sum)

		