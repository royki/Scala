val l1 = List(1,2,4)

val l2 = "abc"toList

l1.zip(l2)

val z = l1.zip(l2)

z.map(t => (t._2+t._1).toChar)