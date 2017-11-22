// Fill is carried method, take 2 arguments as separate list
// Fill doesn't give any information of index

Array.fill(100)(0)

List.fill(100)(math.random)


// Tabulate takes 2 arguments, last argument is a function, it takes the index
Array.tabulate(10)(i => i*i)

// Prefer not to use
new Array[Int](20) // =>take default value of 0
new Array[String](10) // take default value of Null


