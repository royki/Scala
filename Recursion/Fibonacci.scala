def Fibonacci(n:Int): Int = {
	if(n < 2) 1 
	else Fibonacci(n-1)+ Fibonacci(n-2)
}

def Fibonacci_Loop(n: Int): Int = {
	if(n < 2) 1
	else {
		var(a,b) = (1,1)
		var c = a+b
		for( i <- 2 until n){
			a=b
			b=c
			c= a+b
		}
		c
	}
}

def Fibonacci_Recur(n: Int): Int = {
	def helper(n: Int, a: Int, b: Int): Int = 
		if(n <= 0) a+b
		else helper(n-1,b,a+b)
		if(n < 2) 1 else helper(n-2,1,1)
}


println(Fibonacci(5))
println(Fibonacci_Loop(5))
println(Fibonacci_Recur(5))