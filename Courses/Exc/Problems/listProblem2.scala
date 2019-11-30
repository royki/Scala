object listProblem extends App {
	
	def lastButOnethElementList[A](lst: List[A]): A =  lst match {		
		case head::Nil => lst.head
		case _ => lst.init.last
	}

	def lastButOneElementList1[A](lst: List[A]): A = lst match {
		case head::_::Nil => head
		case _::tail => lastButOneElementList1(tail)	
		// case _ => new throw NumberFormatException	
	}

	def nthElementList[A](lst: List[A], n:Int): A = (lst,n) match {
		case (h::_,0) => h
		case (_::tail,n) => nthElementList(tail, n-1)			
	}

	def numOfElement1[A](lst:List[A]): Int = lst match {
		case Nil => 0
		case head::tail => numOfElement1(tail) + 1
	}

	def numOfElement2[A](lst:List[A]): Int = lst.foldLeft(0){(h,_) => h+1}

	def reverseList[A](lst: List[A]): List[A] = lst match {
		case Nil => Nil		
		case head::tail => reverseList(tail):::List(head)
	}

	def duplicateInList[A](lst: List[A]): List[A] = lst match {
		case Nil => Nil
		case head :: tail  => head :: duplicateInList(tail.dropWhile(_ == head))	
	}

	def duplicateInList1[A](lst: List[A]): List[A] = lst.foldRight(List[A]()){
		(head, tail) => 
			if(tail.isEmpty || tail.head != head) head :: tail
			else tail
	}

	def packList[A](lst: List[A]): List[List[A]] =  {
		if(lst.isEmpty) List(List())
		else {
			val(head, tail) = lst span {_ == lst.head}
			if(tail == Nil) List(head)
			else head :: packList(tail)
		}
	}

	def runLengthEncoding[A](lst: List[A]): List[(Int, A)] = {
		packList(lst) map {
			e => (e.length, e.head)
		}
	}

	def runLengthEncodingModiify[A](lst: List[A]): List[Any] = {
		// packList(lst) map {
		// 	e => if(e.length > 1) (e.length, e.head)
		// 		 else e
		// }
		runLengthEncoding(lst) map {e => if (e._1 == 1) e._2 else e}
	}

	val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
	println(runLengthEncodingModiify(lst))
	println(runLengthEncoding(lst))
	println(packList(lst))
}