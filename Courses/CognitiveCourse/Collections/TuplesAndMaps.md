#### _Tuples_
- `A loose aggregation of values into a single container`
- `It can have up to 22 values in Scala`
- `Are always used when you see parantheses wrapping data`without a specific types`
```scala 
> Tuple2(1,"a")
> res0: (Int, String) = (1,a)
```
- `Can be accessed using a 1-based accessor for each values`
- `Can be deconstructed into names bound to each value in a tuple`
```scala
> val tuple = (1, "a" , 2, "b")
> tuple._3
> res1: Int = 2
> val (f, s, th, fo) = tuple
> f: Int = 1
> s:String = a
```
#### _Tuple2_ 
- `Frequently called a pair`
- `Have a unique syntax for values`
```scala
> (1, "a")	  
> res2: (Int, String) = (1, a)
> (2 -> "b")
> res3: (Int, String) = (2, b)
> (3 -> "c" -> 4 )
((Int, String), Int) = ((3,c),4)
```
#### _Unapply to deconstruct a Case Class_

```scala
> case class Time(h:Int = 0, s:Int = 0)
> val t = Time(9,0)
> Time.unapply(t)
> Option[(Int, Int)] = Some(9,0)


scala> 1 to 5
res9: scala.collection.immutable.Range.Inclusive = Range 1 to 5

scala> 'a' to 'g'
res10: scala.collection.immutable.NumericRange.Inclusive[Char] = NumericRange a to g

scala> res9
res12: scala.collection.immutable.Range.Inclusive = Range 1 to 5

scala> res10
res13: scala.collection.immutable.NumericRange.Inclusive[Char] = NumericRange a to g

scala> res9.zip(res10)
res14: scala.collection.immutable.IndexedSeq[(Int, Char)] = Vector((1,a), (2,b), (3,c), (4,d), (5,e))

scala> res14.toMap
res15: scala.collection.immutable.Map[Int,Char] = Map(5 -> e, 1 -> a, 2 -> b, 3 -> c, 4 -> d)

scala>  res15.get(6)
res19: Option[Char] = None

scala>  res15.get(1)
res20: Option[Char] = Some(a)

scala>  res15(1)
res16: Char = a

scala>  res15(6)
java.util.NoSuchElementException: key not found: 6

scala>  res15.getOrElse(1, "z")
res22: Any = a

scala>  res15.getOrElse(1, 'z')
res23: Char = a
```