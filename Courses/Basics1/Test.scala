def readText(index: Int, lines: Array[String]) {
	if(index < lines.length){
		lines(index) = readLine
		readText(index+1, lines)
	}
}

val numLines = readInt
val lines = new Array[String](numLines)
readText(0,lines)

println(lines)