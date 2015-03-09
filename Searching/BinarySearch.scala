val nums = Array(1,6,3,8,4,7,8,9,6,4,33,56,7,8,65,43)


// N values looks for mid, then N/2, N/4, N/8,....4,2,1 -> power of 2
// 2^l = N => l = log2(N)
// 2^10 = 1024 ~ 10^3

// N 		Sequential 			Binary
//1000		500 				10
//10^6 		5*10^5 				20
//10^9		5*10^8				30

def binary_Search(arr: Array[Int], lookingFor: Int): Int = {
	var start = 0
	var end = arr.length
	var mid = (start + end)/2	
	while(arr(mid) != lookingFor && start < end) {		
		//println(start+" "+mid+" "+end)
		if(lookingFor < arr(mid)) {
			end = mid
		}
		else {
			start = mid + 1
		}
		mid = (start + end)/2		
	}
	if(arr(mid) == lookingFor) mid else -1
}

def binary_Search2(a: Array[Int], lookingFor: Int): Int= {
	def recurHelper(start: Int, end: Int): Int = {
		if(start >= end) -1
		else {
			val mid = (start+end)/2
			if(a(mid) == lookingFor) mid
			else if(lookingFor < a(mid)) recurHelper(start,mid)
			else recurHelper(mid+1, end)
		}
	}
	recurHelper(0, a.length)
}

val snums = nums.sorted
println(snums.mkString(","))
println(binary_Search2(snums,4))
println(binary_Search2(snums,7))
println(binary_Search2(snums,65))
println(binary_Search2(snums,2))