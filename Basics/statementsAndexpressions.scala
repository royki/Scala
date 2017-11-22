// Scala is a functional language
// In Scala pretty much everything is not decoration, is expression in Scala
// The statement is valid code that is put in that tells the language to do something. but it doesn't produce value. So statement has effects but they dont give back value.
// An expression produces a value

object StatementsAndExpressions extends Any {
	
	// expression
	val message = name + " is " + age + " years old"

	// the simplest expression is literal and they combine literal with operators
	val value = 22
	val age = 39
	value + age
	value.+(age)
	// integer type has min method
	value.min(age) 
	value min age
	
}