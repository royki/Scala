#### _Algebraic Data Types(ADT)__
- `A distinct set of possible types`
- `Intuition:`
	- `Days of the week`
	- `Binary light switches`

#### _Option_
- `Not a collection, more of a data container`
- `An ADT representing the existence of a value`
- **Some** `is the representation of a value`
- **None** `is the representation of the absence of a value`
- `Allows us to avoid null on the JVM`

```scala
> Option("Roy")
> Option[String] = Some(Jaime)
> res0.get 
> String = Jaime
> res0.getOrElse("Jane")
> String = Roy

> Option(null)
> Option[Null] = None
> res0.get 
> java.util.NoSuchElementException: None.get
> res0.getOrElse("Foo")
> String = Foo
```
- `Option allows to create APIs where the possible absence of value is encoded in the type system`
- `We can then perform behavior without asking whether or not the value is null in advance`

```scala
case class Customer(f: String = " ", m: Option[String] = None, l: String = " ")
> Customer("Martin", last = "Odersky")
Customer = Customer(Martin, None, Odersky)
```
