object ConcatLists extends App {
	
	def concatLists[T <% Ordered[T]](l1: List[T], l2: List[T]): List[T] = l1 match {
		case List() => l2
		case head :: tail => head :: concatLists(tail, l2)
	}	

	val l1 = List('a','e','i','o','u')
	val l2 = List('A','E','I','O','U')

	println(concatLists(l1,l2))
}
