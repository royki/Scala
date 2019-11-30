//For loop as Statement 
for( i <- 1 to 10) println(i)

//For loop as Expression: yield
val evenSquares = for(i <- 2 to 20 by 2) yield i*i

//Multiple yield in for loop
for( i <- 1 to 10; j <- 1 to 10) yield (i,j ,i*j) 


//Nexting for loop
for( i <- 1 to 10) yield for(j <- 1 to 10) yield (i,j ,i*j) 

for {
	i <- 1 to 10
	j <- 1 to 10
} yield (i,j ,i*j) 



