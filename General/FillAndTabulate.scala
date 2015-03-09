def g(x: Double)(y : Double) = x*y

val arr = new Array[Double](100)

val arr1 = Array(1.0,2.0,3.0)

val arr2 = Array.fill(10)(5)

val arr3 = Array.fill(10)(math.random)

//Tabulate 1st arguments = no of things; 2nd arguments = not a passbyname, it is a 
//function that takes a single arguments of Index
val squares = List.tabulate(100)(i => i*i)
val squares1 = List.tabulate(100)(i => i%2 == 0)

