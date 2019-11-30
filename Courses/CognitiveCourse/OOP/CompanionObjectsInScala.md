`We can use keywords to limit the visibility of methods and fields in class instances`

- `public, the default`
- `private, limiting visibility only to yourself`
- `protected`

#### _Companion Objects_
- `If a Singleton object and a class share the same name and are located in the same source file, they are called
companion object`
- `A companion class can access private fields and methods inside of its companion object`
- `This is great way to separate static members (fields, constants and methods) that are related
to a specific instance of that class`

```scala
scala> object Hello {
     |   private val defaultMsg = "Hello"
     | }

 scala> class Hello(m: String = Hello.defaultMsg) {
     |   println(m)
     | }
```