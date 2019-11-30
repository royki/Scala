val a = Array(1,2,3,4,5,6,7,8,9,10)
Array(8,2,6).map(a) // map() returing the value of index 8, 2 n 6 from Array a

val nset = Set("One", "Two", "Three", "Five")
Array("Six", "Two", "One").map(nset)

val nmap = Map("One" -> 1, "Two" -> 2, "Three" -> 3, "Five" -> 5)
Array( "Two", "One").map(nmap)

scala> val a = Array(1,2,3,4,5,6,7,8,9,10)
a: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

scala> Array(8,7,6).map(a)
res23: Array[Int] = Array(9, 8, 7)

scala> Array(11,12,13).map(a)
java.lang.ArrayIndexOutOfBoundsException: 11
  at scala.collection.mutable.WrappedArray$ofInt.apply$mcII$sp(WrappedArray.scala:178)
  at scala.collection.mutable.WrappedArray$ofInt.apply(WrappedArray.scala:178)
  at scala.collection.mutable.WrappedArray$ofInt.apply(WrappedArray.scala:175)
  at scala.collection.TraversableLike.$anonfun$map$1(TraversableLike.scala:234)
  at scala.collection.IndexedSeqOptimized.foreach(IndexedSeqOptimized.scala:32)
  at scala.collection.IndexedSeqOptimized.foreach$(IndexedSeqOptimized.scala:29)
  at scala.collection.mutable.ArrayOps$ofInt.foreach(ArrayOps.scala:239)
  at scala.collection.TraversableLike.map(TraversableLike.scala:234)
  at scala.collection.TraversableLike.map$(TraversableLike.scala:227)
  at scala.collection.mutable.ArrayOps$ofInt.map(ArrayOps.scala:239)
  ... 28 elided
  
scala> Array(6,7,8,9).map(a)
res30: Array[Int] = Array(7, 8, 9, 10) 