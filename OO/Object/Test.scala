object QuickSort {
  def QuickSort(lst: List[Int]): List[Int] = lst match {
    case Nil => Nil
    case x :: Nil => lst
    case _ =>
      val pivot = lst.head
      val (before, after) = lst.tail.partition(_ < pivot)
      QuickSort(before) ++ (pivot :: QuickSort(after))
  }
  
  def main(args: Array[String]) {     
    val nums = List.fill(10)(util.Random.nextInt(100))
    println(nums.mkString(", "))
    println(QuickSort(nums).mkString(", "))
  }
}