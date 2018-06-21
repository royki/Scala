// Sequence of collections has one type parameter.
// Maps have two type parameter.

val nmap = Map(1 -> "A", 2 -> "B", 3 -> "C", 4 -> "D")
nmap(2)
nmap.apply(2)
nmap + (5 -> "E")
nmap - (1)

// Iterating Through Maps

val n = (1 to 100).map(i => i.toString -> i) // Gives sequence of tuple
// In sequence of tuple, we can use toMap
(1 to 100).map(i => i.toString -> i).toMap
// Maps generally doesn't preserve order
val m = n.take(5)
// Pattern match
for((k,v) <- m) println(k+ " "+ v)

//Map on Map
n.map( t => t._1*2 -> t._2*2) // arguments is a map also

// If arguments in map is one argument, it ll return iterable list
n.map( t => t._1*2)

// Filter on map
n.filer( t => t._2 < 5)
n.filer( t => t._1 < "5")


