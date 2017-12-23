#### _Class_
- `A class is a description of a Type`
- `Embodies state in an instance of a class`
- `Represents behavior for how that state can be transformed`
- `Is not concrete until it has been "instantiated" via a call to its constructor via "new" keyword`
- `Multiple instances of a class can exist`

```scala
scala> class Hello
defined class Hello

scala> new Hello()
res0: Hello = Hello@6d17914a

scala> res0.toString
res1: String = Hello@6d17914a
```

##### The primary constructor
- `Each class gets a primary constructor automatically`
- `Defins the "signature" of how to create an instance`
- `The body of the class is the implementation of the constructor`
```scala
scala> class Hello {
     |  println("Hello")
     | }
defined class Hello

scala> new Hello()
Hello
res2: Hello = Hello@71418a4a
```
#### _Class parameters_
- `Can pass values into an instance of a class using one or more parameters to constructor`
- `Must specify the type of the parameter`
- `The values are internally  visible for the life of the class instance`
- `They cannot be acccessed from outside of the class instance`
```scala
scala> class Hello (m: String){
     |  println(m)
     | }
defined class Hello

scala> new Hello("Hell, World")
Hell, World
res3: Hello = Hello@14ba7f15

scala> new Hello
<console>:13: error: not enough arguments for constructor Hello: (m: String)Hello.
Unspecified value parameter m.
       new Hello
       ^
```
#### Class parameters are not accessible

```scala
scala> class Hello(m: String)
defined class Hello

scala> new Hello("Hello, World")
res5: Hello = Hello@7097ead6

scala> res5.m
<console>:13: error: value m is not a member of Hello
       res5.m
            ^
```


