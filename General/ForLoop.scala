/*for( i <- 0 to 10) {
	if(i % 2 ==0){
		println(i)
	}	
}*/

//for( i <- 0 to 10) yield if(i%2 == 0) i


//Guards on for Loop
//for( i <- 0 to 10; if i%2 == 0) yield i

val nums = Array.fill(100)(math.random)
val smallNums = for( x <- nums) yield x*x
smallNums.length
val pnts = Array.fill(100)(math.random,math.random)

val dists = for( (x,y) <- pnts; if x*x+y*y <=1) yield {
	math.sqrt(x*x+y*y)
}

val dists = for( (x,y) <- pnts; val dsqr = x*x+y*y; if dsqr <=1) yield {
	math.sqrt(dsqr)
}