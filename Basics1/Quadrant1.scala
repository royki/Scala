def quadrant(x: Double, y: Double):Int = {
	if(x < 0){
		if(y < 0)
			3 else 2		
	}else {
		if(y < 0)
			4 else 1
	}	
}

def magnitude(x: Double, y: Double):(Int, Double) = {
	val quad = quadrant(x, y)	
	val mag = math.sqrt(x*x + y*y)
	(quad, mag)
}

println("Enter X")
val x = readDouble
println("Enter Y")
val y = readDouble

//println(quadrant(x,y))
//println(magnitude(x,y))

val (quad, mag) = magnitude(x,y)
println("The point is in quadrant" +quad)
println("The point is in magnitude" +mag)
