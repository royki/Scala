val a = Array(1,2,3,4,5,6,7,8,9,10)
Array(8,2,6).map(a) // map() returing the value of index 8, 2 n 6 from Array a

val nset = Set("One", "Two", "Three", "Five")
Array("Six", "Two", "One").map(nset)

val nmap = Map("One" -> 1, "Two" -> 2, "Three" -> 3, "Five" -> 5)
Array( "Two", "One").map(nmap)