def test_Sorted_1(arr: Array[Double]):Boolean = {
	var ret = true
	for( i <- 0 until arr.length-1) {
		if(arr(i) > arr(i+1)) ret = false
	}
	ret
}

def test_Sorted_2(arr: Array[Double]):Boolean = {
	var ret = true
	var i = 0
	while( i < arr.length-1 && arr(i) <= arr(i+1)) {
		i += 1
	}
	i >= arr.length-1	
}

def test_Sorted_3(arr: Array[Double]):Boolean = {
	(arr.zip(arr.tail).forall(t => t._1 <= t._2))
}

def test_Sort(sortFunc: Array[Double] => Unit):Boolean = {
	val nums = Array.fill(20)(math.random)
	sortFunc(nums)	
	//test_Sorted_1(nums)
	//test_Sorted_2(nums)
	test_Sorted_3(nums)

}

case class Student(name:String, grade:Int) 
def bubble_Sort(arr: Array[Student]) {
	for(i <- 0 until arr.length-1; j <- 0 until arr.length-1 -i) { // n-1 times
		//for(j <- 0 until arr.length-1 -i) { // n-1, n-2, n-3....
			if(arr(j).grade > arr(j+1).grade) {
				val temp = arr(j)
				arr(j) = arr(j+1)
				arr(j+1) = temp
			//}
		}
	}
}


def bubble_Sort(arr: Array[Double]) {
	for(i <- 0 until arr.length-1) { // n-1 times
		for(j <- 0 until arr.length-1 -i) { // n-1, n-2, n-3....
			if(arr(j) > arr(j+1)) {
				val temp = arr(j)
				arr(j) = arr(j+1)
				arr(j+1) = temp
			}
		}
	}
}

def selection_Sort(arr: Array[Double]) {
	for( i <- 0 until arr.length-1) {
		var min = i
		for( j <- i+1 until arr.length) {
			if(arr(j) < arr(min))
				min = j
		}
		if(min!=i) { // n or n-1 times-> in worst case 
			val temp = arr(i)
			arr(i) = arr(min)
			arr(min) = temp
		}
	}
}

def insertion_Sort(arr: Array[Double]) {
	for( i <- 1 until arr.length) {
		val temp = arr(i)
		var j = i-1
		while(j> -1 && arr(j) > temp) {
			arr(j+1) = arr(j)
			j -= 1
		}
		arr(j+1) = temp
	}
}

val bigNums = Array.fill(10000)(math.random)
def timeSort(a: Array[Double], sort: Array[Double] => Unit): Double = {
	val start = System.nanoTime
	sort(a)
	val ret = (System.nanoTime-start)*1e-9
	test_Sorted_2(a)
	ret
}

val nums = Array.fill(100000)(math.random)
println("Time taken for bubble_Sort :: " + timeSort(bigNums.map(x => x), bubble_Sort))
println("Time taken for selection_Sort :: " + timeSort(bigNums.map(x => x), selection_Sort))
println("Time taken for insertion_Sort :: " + timeSort(bigNums.map(x => x), insertion_Sort))

println(test_Sort(bubble_Sort))
println(test_Sort(selection_Sort))
println(test_Sort(insertion_Sort))