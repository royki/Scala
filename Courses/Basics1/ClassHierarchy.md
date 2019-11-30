#### _Abstract Class_
```scala
abstract class IntSet {
    def includes(x: Int): IntSet
    def contains(x: Int): Boolean
}
```
- Abstract classes can contain members which are missing an implementation (ex: `incl`, `contains`)
- No instances of an abstract class can be created with the operator new.
- IntSet is called `superclass` of `Emply` and `NonEmpty`
- `Empty` and `NonEmpty` are `subclasses` of `IntSet`
- In Scala, any user-defined class extends another class.
- If no superclass is given, the standard class Object in the Java package `java.lang` is assumed.
- The direct or indirect superclasses of a class C are called `base classes`
    + So the `base classes` of `NonEmpty` are `IntSet` and `Object`

```scala 
/*
 Implementing sets as Binary Tree 
 - a tree for the empty set, 
 - a tree consisting of an integer and two sub-trees.
 - (The invarient we need to maintain - each node, the nodes on the right hand side of the root node, all have integer values that are higher than the root node; whereas the nodes in lefthand are lower than the root node)

 * Persistent data structures
*/

class Empty extends IntSet {
    
    def includes(x: Int): IntSet = new nonEmpty(x, new Empty, new Empty)
    
    def contains(x: Int): Boolean = false    
    
    override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    
    def includes(x: Int): IntSet = {
        if(x < elem) new NonEmpty(elem, left includes x, right)
        else if (x > elem) new NonEmpty(elem, left, right includes x)
        else this
    }

    def contains(x: Int): Boolean = {
        if(x < elem) left contains x
        else if(x > elem) right contains x
        else true
    }

    override def toString = "{" + left + elem + right + "}"
}

val t1 = new NonEmpty(3, new Empty, new Empty)
val t2 = t1 includes 4
```
- It is possible to redefine an existing,non-abstract definition in a subclass by `override`
```scala
abstract class Base {
    def foo = 1
    def bar: Int
}

class Sub extends Base {
    override def foo = 2
    def bar = 23
}
```
- We can express this case better with an object definition
- This defines a `singleton object` named `Empty`
- No other Empty instances can be (or need to be) created.
- Singleton objects are values, so Empty evaluates to itself.

```scala
object Empty extends IntSet {
    
    def contains(x: Int  ): Boolean = false
    def includes(x: Int  ): IntSet = new NonEmpty(x, Empty, Empty)

}
```
