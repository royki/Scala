def Factorial(n: BigInt): BigInt = if (n > 1) n*(n-1) else 1

print("Enter a number :")
val n = readInt

print(s"The Factorial of $n ! : " + Factorial(n))

def Factorial_Recur(n: Int): Int = n match {
	case 0 => 1
	case 1 => 1
	case _ => n * Factorial_Recur(n-1)
}


def Factorial_tailRecur(n: Int): Int = {
	@tailrec
	def helper(n: Int, acc: Int): Int = n match {
		case 0 => 1
		case 1 => 1
		case _ => helper(n*acc, n-1)
	}
	helper(n,1)
}
