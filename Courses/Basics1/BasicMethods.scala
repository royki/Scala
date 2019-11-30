def averageGroup(nums: List[Double], size: Int): List[Double] = {
	if(nums.length <= size) List(nums.sum/nums.length)
	else {
		val first = nums.take(size)
		(first.sum/nums.length) :: averageGroup(nums.drop(size), size)
	}
}

def averageGroup1(nums: List[Double], size: Int): List[Double] = {
	if(nums.length <= size) List(nums.sum/nums.length)
	else {
		val (first, rest) = nums.splitAt(size)
		(first.sum/first.length) :: averageGroup(rest, size)
	}
}

/*def readList(lst: List[Double], Index: Int) {
	if(Index < lst.length) {
		lst(Index) = readInt()
		readList(lst, Index+1)
	}	
}*/

val n = List(1,3.0,4,5,6,7,8,9,10,11,12,13)

println(averageGroup(n,3))
println(averageGroup1(n,3))

