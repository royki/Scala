object listProblem extends App {

	val lstvalue = List(1, 1, 2, 3, 5, 8)

	def numberOfElement[A](lst: List[A]): Int = lst match {
		case head :: Nil => 1
		case head :: tail => 1+numberOfElement(tail)
		case _ => throw new NumberFormatException
	}

	println(numberOfElement(lstvalue))	

	def numberOfElement1[A](lst: List[A]): Int = lst.foldLeft(0){(c,_) => c+1}
	println(numberOfElement1(lstvalue))

	def kthElement[A](lst: List[A], k: Int): A = (lst, k) match {
		case (head :: _, 0) => head
		case (_ :: tail, k) => kthElement(tail, k-1)
		case _ => throw new NumberFormatException
	}
	println(kthElement(lstvalue, 2))

	def lastElement[A](lst: List[A]): A = lst match {
		case head :: Nil => head
		case head :: tail => lastElement(tail)
		case _ => throw new NumberFormatException
	}
	println(lastElement(lstvalue))

	def lastElement1[A](lst: List[A]): A = lst.last
	println(lastElement1(lstvalue))

	def lastButOneElement[A](lst: List[A]): A = lst match {
		case head :: Nil => head
		case head :: tail => tail.init.last
		case _ => throw new NumberFormatException
	}

	println(lastButOneElement(lstvalue))	

	def lastButOneElement1[A](lst: List[A]): A = lst match {
		case head :: _ :: Nil => head
		case _ :: tail => lastButOneElement1(tail)
		case _ => throw new NumberFormatException
	}
	println(lastButOneElement1(lstvalue))

	def isPalindrom[A](lst:List[A]): Boolean = lst == lst.reverse
	println(isPalindrom(lstvalue))

	def flattenList(lst: List[Any]): List[Any] = lst flatMap { 
		something =>
			something match {
				case ms:List[_] => flattenList(ms)
				case e => List(e)	
			}		
		}

	val flatten = flattenList(List(List(1, 1), 2, List(3, List(5, 8))))
	println(flatten)

	def duplicateInList[A](lst: List[A]): List[A] = lst match {
		case Nil => Nil
		case (head :: tail) => head :: duplicateInList(tail.dropWhile(_ == head))
	}
	val list1 = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")	
	println(duplicateInList(list1))

	def compressListFunc[A](lst: List[A]): List[A] = lst.foldRight(List[A]()) {
		(head, tail) => 
		if(tail.isEmpty || tail.head != head) head :: tail
		else tail
	}
	
	println(compressListFunc(list1))

	def packList[A](lst: List[A]): List[List[A]] = {
		if(lst.isEmpty) List(List())
		else {
			val (head, tail) = lst span {_ == lst.head}
			if(tail == Nil) List(head)
			else head :: packList(tail)
		}
	}
	println(packList(list1))

	def encodeRunLength[A](lst: List[A]): List[(Int, A)] = {
		packList(lst) map {
			e => (e.length, e.head)
		}
		// val(n, l) = packList(lst)
		// (n.length,l.head)
	}
	println(encodeRunLength(list1))

	def encodeRunLengthDirect[A](lst: List[A]): List[(Int, A)] = 
		if(lst.isEmpty)	Nil
		else {
			val(head, tail) = lst span {_ == lst.head}
			(head.length, head.head) :: encodeRunLengthDirect(tail)
		}
	println(encodeRunLengthDirect(list1))

	def encodeRunLengthModify[A](lst: List[A]): List[Any] = encodeRunLength(lst) map {
		t => if(t._1 == 1) t._2 else t			 	
	}
	println(encodeRunLengthModify(list1))

	def dencodeRunLength[A](lst: List[(Int,A)]): List[A] = lst flatMap { e =>
		e match {
			case (freq, item) => (1 to freq).map(_ => item)
		}
	}
	val list2 = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
	println(dencodeRunLength(list2))

}