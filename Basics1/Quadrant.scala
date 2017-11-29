println("Enter an X-coordinate")
	val x = readDouble
println("Enter a Y-coordinate")
	val y = readDouble
if(x < 0){
	if(y < 0){
		println("3rd")	
	}else {
		println("2nd")
	}
}else {
	if(y < 0){
		println("4th")	
	}else {
		println("1st")
	}
}

