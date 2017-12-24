#### _Composition is Hard_
- `Trying to put together multiple higher order functions into a single expression is difficult`
- `For expressions are syntactic sugar that simplifies the work of coding a multi-stage transformation`

#### _Compsing Higher Order Functions_
```scala
scala> val nums = 1 to 3
nums: scala.collection.immutable.Range.Inclusive = Range 1 to 3

scala> nums.map(i => (1 to i).map(j => i * j))
res0: scala.collection.immutable.IndexedSeq[scala.collection.immutable.IndexedSeq[Int]] = Vector(Vector(1), Vector(2, 4), Vector(3, 6, 9))

scala> nums.flatMap(i => (1 to i).map(j => i * j))
res2: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 4, 3, 6, 9)
```

##### _Above example of HOFs in `for` expressions_
```scala
scala> for {
     |    i <- nums
     |    j <- 1 to i
     | } yield i * j
res3: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 4, 3, 6, 9)
```

##### `for` expression syntax
- `Must start with the `for` keyword`
- `Must have generators, using the '<-' arrow. generators get the value out of the containers upon which the `for` comprehensions are working.`
- `The `yield` keyword dictates whether or not a new value is returned as a result of the iterations.`
- ``for` expression is syntactic sugar over `map`, `flatMap`, `withFilter` and `foreach`. `withFilter` is used instead of `filter` due to laziness`

##### Higher Order Functions have rules
- `If we `map` over a `List`, we will get a `List`. `
- `The first generator of a `for` expression follows the same value`
- `Can have guard conditions to apply filters`

##### filtering with `if` guard
```scala
scala>  for {
     |    i <- nums if i % 2 == 1
     |    j <- 1 to i
     | } yield i * j
res4: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 3, 6, 9)
```

##### Definitions inside `for` expression
```scala
scala> for {
     |    time <- times
     |    hours = time.hours if hours > 12
     | } yield (hours -12) + "pm"
res0: Vector[String] = Vector(1pm, 2pm)
```    
##### Effectful Usages
```scala
scala> for(n <- 1 to 3) println(n)
1
2
3

scala> (1 to 3).foreach(n => println(n))
1
2
3

scala> (1 to 3).foreach(println)
1
2
3
```











