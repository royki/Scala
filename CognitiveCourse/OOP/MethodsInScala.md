#### _Method_
- `A method describes behavior within a class`
- `Are something that can be called to do work`
- `Where transformations to internal state can take place`
- `May take parameters as inputs and may return a single value`
- `Should specify their return type`
 - `More correctness`
 - `Faster compilation`

```scala
scala> def hello = "Hello"
hello: String

scala> def echo(msg: String): String = msg
echo: (msg: String)String
```

##### _Why Methods instead of Fields_
- `Methods can look like fields`
- `Methods are evaluated at the time they are called`
- `Methods are re-evaluated every time they are called`
- `Fields are only evaluated at the time the class is constructed and if immutable, then only one time`

#### _Infix Notation_
- `Methods are called on an instance of a class`
- `Scala permits methods to be called witn "." or parentheses, if the method takes only one argument`
- `This is flexible syntax that supports powerful DSLs`

```scala
scala> "Martin Odersky".split(" ")
res11: Array[String] = Array(Martin, Odersky)

scala> "Martin Odersky" split " "
res12: Array[String] = Array(Martin, Odersky)
```