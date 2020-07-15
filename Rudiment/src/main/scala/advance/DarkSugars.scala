package advance

import scala.util.Try

object DarkSugars extends App {

    // #1 - Method with single param
    def singleArgMethod(arg: Int): String = s"$arg"
    // call this single arg method in the following way
    val description = singleArgMethod {
        // some complex code
        42
    }
    // example
    val aTryInstance = Try {
        throw new RuntimeException
    }

    List(1, 2, 3).map { x =>
        x + 1
    }


    // #2 - Single abstract method (Instances of trait with Single Method can be reduced to Lambdas)
    trait Action {
        def act(x: Int): Int
    }

    val anInstance: Action = new Action {
      override def act(x: Int): Int = x + 1        
    }

    val aFunkInstance: Action = (x: Int) => x + 1

    // example: Runnables
    val aThread = new Thread(new Runnable {
      override def run(): Unit = println("Hello, Scala")
    })

    val aSweeterThread = new Thread(() => println("Sweeter, Scala"))

    abstract class AnAbstractType {
        def implemented: Int = 23
        def f(a: Int): Unit
    }

    val AnAbstractInstance: AnAbstractType = (a: Int) => println("Sweeeet")

    // #3 - :: & #:: 

    // scala spec: last char decides associativity of method
    val prependedList = 2 :: List(3, 4)

    class MyStream[T] {
        def -->:(value: T): MyStream[T] = this        
    }

    val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

    // #4 - multi-word method naming
    class Teens(name: String) {
        def `and then said`(gossip: String): Unit = println(s"$name said $gossip")
    }

    val lil = new Teens(name = "Lilly")
    lil `and then said` "Scala is so Sweet"

    // #5 - infix types (generics)
    class Composite[A, B]
    val composite: Composite[Int, String] = ???
    val compositeG: Int Composite String = ???

    class -->[A, B]
    val towards: Int --> String = ???

    // #6 - update() [much like apply()]
    val anArray = Array(1, 2, 3)
    anArray(2) = 7 // rewritten to anArray.update(2, 7)
    // used in mutable collections

    // #7 - setters (for mutable containers)
    class aMutable {
        private var internalMember: Int = 0 // private for OO encapsulation
        def member: Int = internalMember // getter
        def member_=(value: Int): Unit = internalMember = value  // setter
    }

    val aMutableContainer = new aMutable
    aMutableContainer.member = 42 // rewritten as aMutableContainer.member_=(42)
}