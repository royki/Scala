#### _Field_
- `A value encapsulated within an instance of a class`
- `Represents the state of an instance, and therefore of an application at a given time`
- `Is accessible to the outside world, unless specified otherwise`

#### _Fields_ vs _Parameters_
- `Parameters are passed to a class and are only visible within a class`
- `Fields exist in the body of the class, and are accessible to outsiders`

#### _Immutable_ _Fields_ `-> creating by "val" keyword, cannot be changed`

```scala
scala> class Hello {
     |  val m: String = "Hello"
     | }
defined class Hello

scala> (new Hello).m
res7: String = Hello

Mutable Fields -> creating by "var" keyword, can be changed
scala> class Hello {
     |  var m: String = "Hello"
     | }
defined class Hello

scala> val h = new Hello
h: Hello = Hello@448c4742

scala> h.m = "Hello, World!"
h.m: String = Hello, World!
```
###### Immutable Fields cannot be changed and therefore "theadsafe" in a multithread environment, such as JVM
###### Mutable Fields can be useful, but require diligence to ensure that multiple threads cannot update the field at the same time

##### _Use Immutable Fields by default_
- `It is easier to reason about immutable fields and classes that only contain immutable fields`
- `Scala makes all class parameters immutable by default`

##### _Specify Types_
- `Scala has "type inference"`
- `It is good to be specific about types anyway`

```scala
scala> class Hello {
     |  val m = "Hello" // Doesn't specify what val "m" is . 
     | }
defined class Hello

scala> (new Hello).m
res7: String = Hello
```

#### _Promoting Class Parameters_
- `To make a parameter passed to a class constructor into a publicly visible field, add the "val" keyword in front of it`
- `Scala compiler will generate an accessor methof and other class instances can now ask for current state of the promoted field`

```scala
scala> class Hello(val m: String)
defined class Hello

scala> val h = new Hello("Hello, World!")
h: Hello = Hello@464d25b2

scala> h.m
res8: String = Hello, World!
```