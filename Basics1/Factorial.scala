def Factorial(n: BigInt): BigInt = if (n > 1) n*(n-1) else 1

print("Enter a number :")
val n = readInt

print(s"The Factorial of $n ! : " + Factorial(n))