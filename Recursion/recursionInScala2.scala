import annotation.tailrec
object recursionInScala2 extends App {

/*
Function listLength recursively counts the number of items in a list.  
It works fine for list1, the short list, but the longer list exhausts the stack.  
Recursion is a functional language’s bread and butter, 
but we see here that even scala, a functional language, is subject to call stack limitations.
*/

  // Head Recursion or Recursion
  def listLength1(list: List[_]): Int = {
    if(list == Nil) 0
    else 1 + listLength1(list.tail)
  }

  def listLength1WithMatch_1(list: List[_]): Int = list match {
    case Nil => 0
    case _:: tail => 1 + listLength1WithMatch_1(tail)

  }

  var list1 = List(1,2,3,4,5,6,7,8,9,10)
  var list2 = List(1,2,3,4,5,6,7,8,9,10)

  1 to 15 foreach(x => list2 = list2 ++ list2) // ??? what it is returning  
  // println(list2)
  
  // println(listLength1(list1))
  // println(listLength1(list2)) => StackOverflow as recursion optimization failed

  // println(listLength1WithMatch_1(list1))

  // Tail Recursion
  def listLength2(list: List[_]): Int = {
    @tailrec
    def listLength2Helper(list: List[_], acc: Int): Int = {
      if(list == Nil) acc
      else listLength2Helper(list.tail, acc+1)
    }
    listLength2Helper(list, 0)
  }  

  def listLength2WithMatch_2(list: List[_]): Int = {
    @tailrec
    def listLength2MatchHelper(list: List[_], acc: Int): Int = {
      list match {
        case Nil => acc
        case head :: tail => listLength2MatchHelper(tail, acc + 1)
      }
    }
    listLength2MatchHelper(list, 0)
  }

  // println(listLength2(list1))
  // println(listLength2(list2))
  println("No of elements in the List1 " + listLength2WithMatch_2(list1))
  println("No of elements in the List2  " + listLength2WithMatch_2(list2))

  def sum(list: List[Int]): Int = {
    @tailrec
    def sumWithAccumulator(list: List[Int], currentSum: Int): Int = {
        list match {
            case Nil => currentSum
            case x :: xs => sumWithAccumulator(xs, currentSum + x)
        }
    }
    sumWithAccumulator(list, 0)
  }

  println("Summation of elements in List1 " + sum(list1))
  println("Summation of elements in List2 " + sum(list2))
}

