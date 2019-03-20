object Tuples extends App {
  println("-" * 50)
  /*
  // Tuple1
  val tuple1 = new Tuple1("tuple 1")
  println(s"Tuple1 element 1\t${tuple1._1}")

  // Tuple or Heterogeous List
  val tuple2 = new Tuple2(1234, "one two three four")
  println(s"Tuple2 element 1\t${tuple2._1}")
  println(s"Tuple2 element 2\t${tuple2._2}")

  // another syntax of Tuple2
  val tuple2a = (1234, "one two three four")
  println(s"Tuple2 element 1\t${tuple2a._1}")
  println(s"Tuple2 element 2\t${tuple2a._2}")

  // another syntax of Tuple2
  val tuple2b = 1234 -> "one two three four"
  println(s"Tuple2 element 1\t${tuple2b._1}")
  println(s"Tuple2 element 2\t${tuple2b._2}")

  println

  // `swap` in tuple2
  val swapped = tuple2.swap
  println(s"Swapping value in tuple2\t${swapped._1}")
  println(s"Swapping value in tuple2\t${swapped._2}")

  println

  // Tuple3
  val tuple3 = new Tuple3(1234, "one two three four", 'c')
  println(s"Tuple3 element 1\t${tuple3._1}")
  println(s"Tuple3 element 2\t${tuple3._2}")
  println(s"Tuple3 element 3\t${tuple3._3}")

  // another syntax of Tuple3
  val tuple3a = (1234, "one two three four", 'c')
  println(s"Tuple3 element 1\t${tuple3a._1}")
  println(s"Tuple3 element 2\t${tuple3a._2}")
  println(s"Tuple3 element 3\t${tuple3a._3}")
*/
  type StringToInt = Tuple2[String, Int] // Can be written as (String, Int)
  def addTuples(f: StringToInt, s: StringToInt): StringToInt = {
    (f._1 + s._1, f._2 + s._2)
  }

  def stringLength(st: String): StringToInt = {
    // st -> st.length
    (st, st.length)
  }

  val result = addTuples(
    f = stringLength("Dev"),
    s = stringLength("InsideYou")
  )

  println(result)

  println("-" * 50)
}
