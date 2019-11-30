//Read in temp data with fill

def parseTemps(line: String):Array[Double] = {
	val parts = line.split(",")
	Array(parts(1).toInt, parts(2).toInt, parts(4).toDouble,
		if(parts(6) == ".") -100 else parts(6).toDouble)
}

val temps = Array.fill(readInt)(parseTemps(readLine))