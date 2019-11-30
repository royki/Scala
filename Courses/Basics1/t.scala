def t(arr: Array[Int], l: Int): Int = {
	var start = 0
	var end = arr.length
	var mid = (start+end)/2
	while(arr(mid) != l && start < end){
		if(l < arr(mid)){
			end = mid
		} else {
			start = mid+1
		}
		mid = (start+end)/2
	}
	if(arr(mid) == l) mid else -1
}

val nums = Array(1,6,3,8,4,7,8,9,6,4,33,56,7,8,65,43)
val snums = nums.sorted
println(snums.mkString(","))
println(t(snums,4))
println(t(snums,7))
println(t(snums,65))
println(t(snums,2))