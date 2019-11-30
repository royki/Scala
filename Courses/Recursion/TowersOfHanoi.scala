val pegs = Array((1 to 30).toList,List[Int](),List[Int]())

def MoveOneDisk(from: Int, to: Int) {
	require(pegs(to).isEmpty || pegs(from).head < pegs(to).head)
	pegs(to) ::= pegs(from).head
	pegs(from) = pegs(from).tail
}

def MoveStack(n: Int, from: Int, to: Int) {
	if(n==1) MoveOneDisk(from,to)
	else {
		val other = 3-from-to
		MoveStack(n-1,from,other) 
		MoveOneDisk(from,to)
		MoveStack(n-1,other,to)
	}
}

println(pegs.mkString(","))
MoveStack(pegs(0).length,0,2)
//MoveOneDisk(0,2)
println(pegs.mkString(","))
