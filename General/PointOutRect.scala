println("Enter the X Value Point")
	val px = readDouble
println("Enter the Y Value Point")
	val py = readDouble

println("Input the min X Value for the rectangle")
	val rx = readDouble
println("Input the min Y Value for the rectangle")
	val ry = readDouble	
println("Input the min width for the rectangle")	
	val width = readDouble
println("Input the min height for the rectangle")	
	val height = readDouble

val outsideX = (rx > px) || (px > rx+width)
val outsideY = (ry > py) || (py > ry+height)

println(outsideX ||	 outsideY)