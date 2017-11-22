val scope = "Scopes in scala are defined in curly braces"
val decorations= 
	- Object => type class
	- var => variable
	- val => variable
	- def => method
	- Trait
	- Type

val thing = {
	println("In the block")
	5
}	

val thing1 = {
	val thing2 = 21
	println("In the block")
	thing1
}