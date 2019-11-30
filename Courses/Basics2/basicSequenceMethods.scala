val arr = Array(6,1,2,4,5,7)

arr.drop(2)
arr.dropRight(2)

arr.head
arr.tail

arr(arr.lenght-1)
arr.splitAt(3)

arr.take(3)
arr.takeRight(3)

//Slice takes 2 arguments - beginning index and ending index
// 1st index - inclusive, 2nd index - exclusive
arr.slice(2,5)

// Patch
//Patch takes an index, and new array to replace 
arr.patch(3, Array(98, 99), 3)

// Difference
arr.diff(Array(7,8,9))
Array(1,2,3,4,5).diff(Array(1,2,4))

// Distinct
Array(1,2,4,2,4,2,5).distinct

// Intersect
arr.intersect(List(4,5,6))

// Union
arr.union(Array(1,2,11,12))

// Min, Max, Product, Sorted, mkString
arr.min
arr.max
arr.product
arr.sorted
arr.mkString(", ")

// zip
arr.zip('a' to 'z')

// zipWithIndex
arr.zipWithIndex