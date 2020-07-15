package advance

import scala.annotation.tailrec

object Recap extends App {
    val aCondition: Boolean = false
    val aConditionedVal = if (aCondition) 42 else 65

    // Code Block
    val aCodeBlock = {
        if (aCondition) 54
        56
    }

    //  Unit = void
    val theUnit = println("Hello, Scala")

    // functions
    def aFunction(x: Int): Int = x + 1

    // recursion: stack and tail
    @tailrec def factorial(n: Int, acc: Int): Int = {

        if (n <= 0) acc
        else factorial(n - 1, n * acc)
    }
    
    // object-orientation
    class Animal
    class Dog extends Animal

    // subtyping polymorphism
    val aDog: Animal = new Dog // OOP Polymorphism subtyping

    // abstract
    trait Carnivore {
        def eat(a: Animal): Unit
    }

    class Crocodile extends Animal with Carnivore {

      override def eat(a: Animal): Unit = println("crunch !")

    }

    // method notations
    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog

    // anonymous classes
    val aCarnivore = new Carnivore {

      override def eat(a: Animal): Unit = println("roar!")

    } 

    // generic
    abstract class MyList[+A] // variance and variance problems

    // singleton object & companions
    object MyList

    // case classes
    case class Person(name: String, age: Int)

    // exceptions & try/catch/finally
    val throwsException = throw new RuntimeException // Nothing
    val aPotentialFailure = try {
        throw new RuntimeException
    } catch {
        case e: Exception => "Caught exception"
    } finally {
        println("Logs")
    }

    // packaging & imports

    // funtional programming
    val incrementer = new Function1[Int, Int] {

      override def apply(v1: Int): Int = v1 + 1
        
    }
    incrementer(1)

    val anonymousIncrementer = (x: Int) => x + 1
    List(1, 2, 3).map(anonymousIncrementer)

    // map, flatMap, filter
    // for comprehension

    val paris = for {
        num <- List(1, 2, 3) // if condition
        char <- List('a', 'b', 'c')
    } yield s"$num" + "-" + char

    // Scala collections: Seq, Array, List, Vector, Maps, Tuples
    val aMap = Map(
        "Daniel" -> 121132,
        "Jess" -> 87887
    )

    // Options, Try
    val aOption = Some(2)

    // pattern matching
    val x = 2
    val order = x match {
        case 1 => "first"
        case 2 => "second"
        case 3 => "third"
        case _ => s"$x" + "th"
    }

    val bob = Person("Bob", 22)
    val greeting = bob match {
        case Person(n, _) => s"Hi, my name is $n"
    }
}