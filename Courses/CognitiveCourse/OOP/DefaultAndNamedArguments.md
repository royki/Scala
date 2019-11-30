#### _Default Arguments_
- `Allow the developer to specify a value to use for a constructor or method when none is passed by the caller
and omit values that are frequently the same`
- `Reduce boilerplate in application source code because you don't have to "overload" methods with different signatures`

```scala
scala> def name(f: String = " ", l: String = " "): String = f + " " + l
name: (f: String, l: String)String

scala> name("Martin")
res13: String = "Martin  "
```

#### *Best Practice
`If you have a mixture of default arguments and those that don't have a default value, put the arguments
without defaults first`

```scala
scala> def name(f: String, l: String, m: String = ""): String = f +" "+ m +" " +l
name: (f: String, l: String, m: String)String
```

#### _Named Arguments_
- `Leading arguments can be omitted if they have default values`
- `You can specify only the values you want to pass`

```scala
scala> name(f="Martin", l="Odersy")
res15: String = Martin  Odersy
```

