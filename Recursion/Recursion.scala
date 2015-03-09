def printValue(n: Int): Int = {
  print(n)
  printValue(n)
}

def countDown(n: Int) {
  if (n >= 0 ) {
    println(n)
    countDown(n - 1)
  }
}

def countUp(n: Int) {
  if (n >= 0 ) {    
    countUp(n - 1)
    println(n)
  }
}

println("Enter a number")
println("====================")
val n = readInt
println("====================")
//printValue(n)
countDown(n)
println("====================")
countUp(n)
