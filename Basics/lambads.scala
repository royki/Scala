 // a Function is called higher ordered if it accepts another function as an argument or results into a function.
 
 val filter = (predicte: Int => Boolean, xs: List[Int]) => {
	for(x <- xs; if predicte(x)) yield x	
 }
 
 val even = (x: Int) => x % 2 == 0
 val odd = (x: Int) => x % 2 == 1
 
 val candidates = List(1,2,3,4,5,6,7,8,9,10)
 val evenValues = filter(even, candidates)
 val oddValuse = filter(odd, evenValues)