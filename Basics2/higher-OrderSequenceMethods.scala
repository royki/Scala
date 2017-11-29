// key aspects of the functional programming language is ability to pass around of functions.
// Treat functions like just like other values and can pass them into other functions or methods.
// When a function takes another functions as an arguments or returns one is called higher order functions.


val arr = Array(1,2,3,4,5,6) 

// Important and used higher order methods

//  foreach (least use due to sideeffect)
arr.foreach(println) // but has sideeffect 

// map (calculate something, all the elements in the collection)
arr.map(i => i*2)
arr.map(_*2)

// filter - taes boolen function
arr.filter( _ < 5)
arr.filter(_ %2==0)

//count 
arr.count(_%2==0)

// exists
arr.exists(_<5)

// forall
arr.forall(_<10)

// find
arr.find(_%4==0)

// partition - returns 2 Arrays - one with less than 5 elements and 2nd one with not less than 5 elements
arr.partition(_<5)

//reduce - takes function of 2 arguments
arr.reduce(_+_) // arr.sum or fold

// min,max based on some criteria
val arrStr = Array("learning", "scla", "is", "fun")
arrStr.minBy(_.length)
arrStr.maxBy(_.length)