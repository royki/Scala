//Divide and Conquer
//nlog(n)

def quick_Sort(lst: List[Int]): List[Int] = lst match {
	case Nil => Nil
	case x :: Nil => lst
	case _ => 
		val pivot = lst.head
		val (before,after) = lst.tail.partition(_< pivot)
		quick_Sort(before) ++ (pivot :: quick_Sort(after))
}

val nums = List.fill(10)(util.Random.nextInt(100))
println(nums.mkString(", "))
println(quick_Sort(nums).mkString(", "))