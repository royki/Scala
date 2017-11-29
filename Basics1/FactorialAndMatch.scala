def Factorial(n: BigInt): BigInt = {
	if( n > 1) n* Factorial(n-1) else 1
}

def readIntWithDefault(default: Int) : Int = try {
	readInt
} catch {
	case e: NumberFormatException => default
}

val Zero = BigInt(0)
val One = BigInt(1)

// match 
def FactorialAndMatch(n: BigInt): BigInt = n match {
	case Zero => 1
	case One => 1
	case _ =>  n * FactorialAndMatch(n-1)
}


println("Enter a number")
	val n = readIntWithDefault(-1)
	if(n >= 0){
		println( n + "! = " + FactorialAndMatch(n))  
} else {
  	 println("Enter a number")
}
