object arryFunction extends App {
	
	def fillArray(arr: Array[Int], value: Int, index: Int): Unit = {
		if(index < arr.length) {
			arr(index) = value
			fillArray(arr, value, index+1)
		}
	}

	val nums = Array(1,1,1,1)
	fillArray(nums, 99 , 0).foreach println

	def getArrayValue(arr: Array[Int], index: Int): Unit = {
		if(index < arr.length) {
			val v = arr(index)
			println(v)
		} 	
	}
}