//Divide and Conquer
//nlog(n)

def merge(a: List[Int], b: List[Int]): List[Int] = (a,b) match{
	case (Nil, _) => b
	case (_, Nil) => a
	case (x :: xs, y :: ys) => 
		if(x < y) x :: merge(xs,b)
		else y :: merge(a, ys)
}

def merge_Sort(lst: List[Int]): List[Int] = {
	if(lst.length < 2) lst
	else {
		val(first, second) = lst.splitAt(lst.length/2)
		merge(merge_Sort(first), merge_Sort(second))
	}
}

val nums = List.fill(10)(util.Random.nextInt(100))
println(nums.mkString(", "))
println(merge_Sort(nums).mkString(", "))