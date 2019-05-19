object PatternMatch extends App {

  println("-" * 75)

  // Pattern Match on Data Structure

  final case class Person(name: String, age: Int) {
    // class Person(val name: String, val age: Int) { // not structural equality
    def isAdult: Boolean = age >= 18
  }

  val person: Person = Person(name = "Vyald", age = 31)
  val person2: Person = Person(name = "Maria", age = 27)

  val tuple = Tuple2(person, person2)

  def method(input: Any): Any = input match {

    // case `person`                         => "not structural equality"

    case `person`                         => "structural equality"

    case person: Person if person.isAdult => s"guard: ${person.isAdult}"

    case person: Person                   => person.name
  }

  def show(input: Any): Unit = println(method1(input))

  // show(person)
  // show(Person(name = "Vyald", age = 1)) // for structural equality
  // show(new Person(name = "Vyald", age = 1)) // for not structural equality

  //Constructor Pattern Match
  def method1(variable: Any): Any = variable match {
    // case p @ Person(n, a) => s"""|Matched $n who is $a years old.
    // 						 |This is "toString" implementation:
    // 						 |$p -> ${p.name}, ${p.age}""".stripMargin

    // Nested Pattern Match
    case p @ Person(n: String, a @ 2) if n.toLowerCase.startsWith("v") =>
      s"""|Matched $n who is $a years old.
  		  |${p.name}""".stripMargin

    // case Tuple2(f, s) => s"First person ${person.name}, Second person ${person2.name}"
    // case Tuple2(f @ Person(n: String, a @ 31), s) => s"First person ${person.name}, Second person ${person2.name}"
    case (f @ Person(n: String, a @ 31), s @ Person(n1: String, a1 @ 27)) => s"First person ${person.name}, Second person ${person2.name}"
  }

  // show(person)
  // show(person, person2)
  show(tuple)

  println("-" * 75)
}
