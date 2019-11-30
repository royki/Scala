// Another significant type is Option type
// find method on collection. find method returns an Option

val arr = Array(1,2,3,4,5,6,7,8)

arr.find(_ < 3)
Option[Int] = Some(2)

arr.find(_ > 9)
Option[Int] = None

// If find methond doesn't find any value -- Hence it gives Option type
res0 match {
	case Some(i) => println(s"Found $i")
	case None => println("Nothing Found")
}

res0.getOrElse(0)

res0.map(_*2)
> Option[Int] = Some(2)

res1.map(_*2)
> Option[Int] = None
