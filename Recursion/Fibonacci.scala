def Fib1(n:Int): Int = {
	if(n < 2) 1 
	else Fib1(n-1)+ Fib1(n-2)
}


def Fib2(n: Int): Int = n match {
	case 0|1 => 1
	case _ => Fib2(n-1) + Fib2(n-2)
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


def Fibonacci_tailRecur2(n: Int): BigInt = {

	def fibHelper(x: Int, prev: BigInt=0, next: BigInt = 1): BigInt = x match {
		case 0 => prev
		case 1 => next
		case _ => fibHelper(x - 1, next, (next + prev))
	}
	
	fibHelper(n)
}


println(Fibonacci_Recur(5))
println(Fibonacci_Loop(5))
println(Fibonacci_tailRecur1(5))