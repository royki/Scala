// complexity N * N

object RecursiveInsertionSort extends App {

	def recursiveInsertionSort[T <% Ordered[T]](list: List[T]): List[T] = list match {
		case List() => List()
		case head :: tail => insert(head, recursiveInsertionSort(tail))
	}

	def insert[T <% Ordered[T]](i: T, list: List[T]): List[T] = list match {
		case List() => List(i)
		case head :: tail => if (i <= head) i :: list
							 else head :: insert(i, tail)		
	}
	
	val list = List(4,6,1,9,0,10)

	println(recursiveInsertionSort(list))
}