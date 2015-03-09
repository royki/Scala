val nums = Array(1,6,3,8,4,7,8,9,6,4,33,56,7,8,65,43)
/*println(nums.indexOf(4))
println(nums.indexOf(7))
println(nums.lastIndexOf(7))*/

//O(n) 
def sequential_Search(arr: Array[Int], lookingFor: Int):Int = {
	var i = 0
	while( i < arr.length && arr(i)!= lookingFor)	{
		i += 1
	}
	if(i < arr.length) i else -1
}

println(sequential_Search(nums,4))
println(sequential_Search(nums,7))
println(sequential_Search(nums,2))