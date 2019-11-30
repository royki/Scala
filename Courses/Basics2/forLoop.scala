for( i <- 0 to 10) {
	println(i)
}


for( i <- 0 to 10; if i%3==0 || i%5==0; j <- 'a' to 'c') {
	println(i + " " + j)	
}

val stuff = for { 
	i <- 0 until 10
	if i%3==0 || i%5==0
	j <- 'a' to 'c' 
	} yield {
		i -> j
	}
println(stuff)