// function to fill all elements of an array
def fillArray(arr: Array[Int], value:Int, Index:Int) {
	if(Index < arr.length){
		arr(Index) = value
		fillArray(arr, value, Index+1)
	}	
}

// function to print an array
def printArray(arr: Array[Int], Index: Int)  {
	if(Index < arr.length){
		print(arr(Index)+ " ")
		printArray(arr, Index+1)
	} else {
		println()
	}
	
}

// function to fill an array with user input
def readArray(arr: Array[Int], Index: Int) {
	if(Index < arr.length) {
		arr(Index) = readInt()
		readArray(arr, Index+1)
	}
}

// function to sum elements of an array
def sumArray(arr: Array[Int], Index: Int): Int = {
	if(Index >= arr.length) 0 
	else arr(Index)+ sumArray(arr, Index+1)
}

// make an array and use it with those functions
val nums = new Array[Int](10)
fillArray(nums, 5, 0)
printArray(nums, 0)

val smallNums = new Array[Int](5)
readArray(smallNums, 0)
printArray(smallNums, 0)

println(sumArray(nums,0))
println(sumArray(smallNums, 0))