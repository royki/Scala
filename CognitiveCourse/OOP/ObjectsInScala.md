#### _Objects_
- `The Singleton Pattern`
- `Defines a single instance of a class that cannot be recreated within a single JVM instance`
- `Can be directly accessed via its name`

```scala
scala> object Hello {
     |  def m = "Hello"
     | }
defined object Hello
scala> Hello.m
res16: String = Hello
```
##### _Usefulness_
- `Many languages permit the definition of "static" fields and methods`
- `These are globally available within the runtime, such as JVM`
- `They are not related to specific instances of a class`

##### _When are Scala Objects used?_
- `Class Factories`
- `Utility methods`
- `Constant definitions`

```scala
object Hello {
	val oneHourInMinutes: Int = 60

	def createTimeFromMinutes(minutes: Int) = 
		new Time(minutes / oneHourInMinutes, minutes % oneHourInMinutes)

	def main(args: Array[String]): Unit = {
		printl("Hello")
	}
}
```
