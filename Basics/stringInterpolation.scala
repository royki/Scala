object stringInterpolation extends Any {
	val name = "ROY"
	val age = 29
	val message = name + " is " + age + " years old"
	val message2 = s"$name is $age years old"	
	
	val tuple = (1,2,4, "hi there")
	val (a,b,c) = t
	println(t._1)
	val str = s"The 2nd element of tupple is ${t._2}"
    
	name == "ROY"
	name = "ROY" * 5 // multiplication of Strings
}