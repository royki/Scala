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
	val nums = Array.fill(2000)(math.random)
	sortFunc(nums)
	//test_Sorted_1(nums)
	//test_Sorted_2(nums)
	test_Sorted_3(nums)

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

def timeSort(a: Array[Double], sort: Array[Double] => Unit): Double = {
	val start = System.nanoTime
	sort(a)
	val ret = (System.nanoTime-start)*1e-9
	test_Sorted_2(a)
	ret
}
//val bigNums = Array.fill(10000)(math.random)

val nums = Array.fill(2000)(math.random)
//val nums = Array(5,8,3,2,9,6,4,7,1)
println("Unsorted Array => " + nums.mkString(","))
println("-----------------")
selection_Sort(nums)
println("Sorted Array => " + nums.mkString(","))
println("-----------------")
println(test_Sort(selection_Sort))
println("Time taken for selection_Sort :: " + timeSort(nums.map(x => x), selection_Sort))