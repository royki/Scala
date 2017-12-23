#### _Thread Safety_
- `The JVM has a well-defined memory model with specific guarantees`
- `There are two concerns:`
	- Synchronize-With: `Who is able to change state and in what order(locks)`
	- Happens-Before: `When to publish changes on one thread to all other threads(memory barriers)`

	#### _Names_ vs _Values_
	```scala
	val p = new Person("Martin", "Odersky")
	    ↑				  ↑
	   Name             Value
	```

| Name\Value   |      Mutable  |  Immutable |
|----------|:-------------:|------:|
| `var` |    😞 (worst case)  |    🙄 (snapshots)  |
| `val` |    😕 (locks)  |    😊 (pure immutability)  |

😥 

##### _The Left side of the Equals Sign_
- `Represents a pointer to the current value`
- `We want this to be "final" as much as pssible, using a "val"`
- `Reassignment to a new value is possible when using a "var"`

##### _The Right side of the Equals Sign_	
- `Represents the value of the current state`
- `This should be always immutable, meaning that the class instance contains only fields that are defined as "val"`
- `If not, we must protect the state and who can change it using Mutually Exclusive Locks`

##### _Using a `var` for Snapshots_
- `Allows us to keep the value on the right side of the equals immutable, but still change the current state by replacing what the "var" points to with another instance`
- `The "@volatile" annotation must be used when we follow the snapshot strategy, to ensure that all threads see the udates`
- `The case class "copy()" method will help to do this`

```scala
scala> case class Author(f: String = " ", l: String = " ")
defined class Author

scala> @volatile var author = Author("Martin", "Odersky")
author: Author = Author(Martin,Odersky)

scala> author = author.copy(l = "Scala Creator")
author: Author = Author(Martin,Scala Creator)
```

