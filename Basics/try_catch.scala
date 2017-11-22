val str = "124 "
val num = try { 
	str.toInt
} catch {
	case e: NumberFormatException => 0
}
println(num)


val i = try {
	readInt
} catch {
	case e:NumberFormatException => println(e)
}


val i: Int = {
	try {
		readInt
	} catch {
		case e:NumberFormatException => println(e)
		i
	}
}