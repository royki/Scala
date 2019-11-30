//while loop is few construction that is not an expression; it is 
// a statement only. we can't use val a = while(){} like this.


def countUp(highestValue: Int) = {
	var i = 0
	while(i <= highestValue){
		println(i)
		i+=1
	}
}

def buildList():List[String] = {
	var line = readLine()
	var lst  =  List[String]()
	while(line != "quit"){
		lst ::= line 
		line = readLine()
	}
	lst.reverse
}

countUp(10)
println("Enter words on a separate lines. Type \"quit\" when done." )
val words = buildList()
println(words)
