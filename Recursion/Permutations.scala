//List(1,2,3,4).splitAt(2) => (List(1,2),List(3,4))
// List(List(1,2,3),List(4,5,6)).flatten =>List[Int] = List(1, 2, 3, 4, 5, 6)
def Permutations(lst: List[Int]): List[List[Int]] = lst match{
	case Nil => List(Nil)
	case List(a) => List(lst)
	case _ => 
		(for(i <- lst.indices.toList) yield {
			//val elem = lst(i)
			val (before,rest) = lst.splitAt(i)
			val elem = rest.head
			val supermutes = Permutations(before ++ rest.tail)
			supermutes.map(elem :: _)
		}).flatten
}

def readList(length: Int): List[Int] = {
	if(length < 1) Nil
	else readInt() :: readList(length-1)
}

println("Enter the lenght of the List")
val x = readInt
println("Enter the value of the List")
val l = readList(x)
println(Permutations(l))