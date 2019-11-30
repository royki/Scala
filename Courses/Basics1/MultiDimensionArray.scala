def matrixAddition(m1: Array[Array[Double]], m2: Array[Array[Double]]): Array[Array[Double]] = {
	
	//One way to create fill and add
	/*val ret = Array.fill(m1.length,m1(0).length)(0.0)
	for( i <- 0 until ret.length; j <- 0 until ret(0).length)
		ret(i)(j) = m1(i)(j)+m2(i)(j)*/

	//Another way
	Array.tabulate(m1.length,m1(0).length)((i,j) => {
		m1(i)(j)+m2(i)(j)
	})

	for((r1,r2) <- m1.zip(m2)) yield {
		for((x1,x2) <- r1.zip(r2)) yield x1+x2
	}
}