def shell_Sort(arr: Array[Double]):Unit {
	var gap = arr.lenght/2
	while(gap >=1) {
		for( i <- 1 until arr.length) {
			val temp = arr(i)
			var j = i-1
			while(j> -1 && arr(j) > temp) {
				arr(j+1) = arr(j)
				j -= 1
			}
			arr(j+1) = temp
		}
		gap = (gap/2.2).round.toInt
	}
}