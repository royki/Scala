def fib(n: Int): Int = if(n < 2) 1 else fib(n-1)+fib(n-2)

for (n <- 30 to 15 by -1) println(fib(n))

println(for (n <- 30 to 15 by -1 par) yield (fib(n)))

var i = 0
//for(j <- 1 to 1000000) i+=1
for(j <- 1 to 1000000 par) i+=1
println(i)