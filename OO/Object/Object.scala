//Object Decoration 
/*
Classes are effectively blueprint of making objects 
and extentiate object using "new" - that tells scala to do - is to create object from class
Object decoration is very similar to Class decoration, but they don't 
make a whole class of object, they make a single object.
*/

//No arguments in object declaration 

object Object {
	var i = 0
	def func1 {
		i +=1
		println(i)
	}
}

//Companion Object
Int.MaxValue

Array(1,2,3)
Array.apply(1,2,3)