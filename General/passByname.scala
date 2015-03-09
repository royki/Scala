def buildList(n: Int, x: Double):List[Double] = {
	if(n < 1) Nil else x :: buildList(n-1, x)
}

println(buildList(5, 80))
println(buildList(5, math.random))
// Here x build a function x()=> Double; here function takes a zero arguments and gives it back a double
def buildListF(n: Int, x:() => Double): List[Double] = {
	if(n < 1) Nil else x() :: buildListF(n-1, x)
}

//def makeRandom = math.random
println(buildListF(5, ()=> math.random))

def buildListN(n: Int, x: => Double): List[Double] = {
	if(n < 1) Nil else x :: buildListN(n-1, x)
}

println(buildListN(5, math.random))

var i = 0

/*buildList(5, {i += 1, math.random})
buildListF(5, {i += 1, math.random})
buildListN(5, {i += 1, math.random})
*/