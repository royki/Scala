object RemoveNthElementFromList extends App {

	def removeNthelementFromList[T <% Ordered[T]](n: T, list: List[T]): List[T] = {
		(list take n) ::: (list drop n + 1)
	}
	
/*	
scala> List(1,2,3,4,5,6)
res0: List[Int] = List(1, 2, 3, 4, 5, 6)

scala> res0 take 2
res1: List[Int] = List(1, 2)

scala> res0 drop 3
res2: List[Int] = List(4, 5, 6)

scala> res1 ::: res2
res3: List[Int] = List(1, 2, 4, 5, 6)
*/	
}