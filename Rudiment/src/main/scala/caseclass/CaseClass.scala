object CaseClass extends App {

  println("-" * 75)

  println("In-built `case class` from Scala API")
  val hs = Homosapiens("Bob", 27, true)
  println(hs.name)
  println(hs.age)
  println(hs.isMale)
  println("class instance: " + hs)
  println("Companion object: " + Homosapiens)
  println(Homosapiens.isInstanceOf[Function3[_, _, _, _]])
  val hsFactory: (String, Int, Boolean) => Homosapiens = Homosapiens
  println(hs == Homosapiens("Bob", 27, true))
  println(hs.copy(age = 31))

  val persons: Set[Homosapiens] =
    Set(
      hs,
      Homosapiens("HM1", 25, true),
      Homosapiens("HM2", 26, true),
      Homosapiens("HM4", 28, true),
      Homosapiens("HM5", 29, true)
    )
  println(persons.contains(Homosapiens("Bob", 27, true)))

  println(hs.isInstanceOf[Product])
  println(hs.productPrefix)
  println(hs.productElement(0))
  println(hs.productArity)
  println(hs.productIterator.mkString(","))
  println

  hs match {
    case Homosapiens(a, b, c) => println("Pattern match works")
  }

  println(Console.RED + ("-" * 74) + Console.RESET)

  println("Implementing similar `case class` like Scala API")
  val human = Human("Alice", age = 26, false)

  println(human.name)
  println(human.age)
  println(human.isFemale)
  println("class instance: " + human)
  println("Companion object: " + Human)
  println(Human.isInstanceOf[Function3[_, _, _, _]])
  val humanFactory: (String, Int, Boolean) => Human = Human.apply // If Function3 is not defined
  println(human == Human("Alice", 26, false))
  println(human.copy(age = 30))

  val humans: Set[Human] =
    Set(
      human,
      Human("HM1", 25, true),
      Human("HM2", 26, true),
      Human("HM4", 28, true),
      Human("HM5", 29, true)
    )
  println(humans.contains(Human("Alice", 26, false)))
  println(human.isInstanceOf[Product])
  println(human.productPrefix)
  println(human.productElement(0))
  println(human.productArity)
  println(human.productIterator.mkString(","))
  println
  human match {
    case Human(a, b, c) => println("Pattern match works")
  }

  println("-" * 75)

  /*println(Some(13337))
  println(None)

  println(Some(null))
  println(Option(null))

  println(Option.empty[String])
  println(Option.empty)
  println(None)*/

  // Return type of `find` is Option
  // println(Set("Bob", "Alice").find(_ == "Bob"))
  // println(Set("Bob", "Alice").find(_ == "Franck"))
  val implicitFile: String = "/home/croy/Scala/Rudiment/src/main/scala/caseclass/CaseClass.scala"

  val explicitFile: String = Files(
    location  = "/home/croy/Scala/Rudiment/src/main/scala/caseclass",
    name      = "CaseClass",
    extention = "scala"
  )

  // println(implicitFile)
  // println(explicitFile)

  implicitFile match {
    case Files(l, n, e) =>
      println(s"Location: $l")
      println(s"Name: $n")
      println(s"Extention: $e")
  }

  explicitFile match {
    case IsLocationLongerThan20Characters() => println("Y")
    case Files(l, n, e) =>
      println(s"Location: $l")
      println(s"Name: $n")
      println(s"Extention: $e")
  }

  val f3: (String, Int, Boolean) => Unit =
    (str, int, bool) => {
      println(int)
    }

  val f1: ((String, Int, Boolean)) => Unit = f3.tupled

  val per: Human = Human("Bob", age    = 27, isMale = true)

  f1(
    Human
      .unapply(per) // Return type is Option[String, Int, Boolean]
      .get // (String, Int, Boolean)

  )
}

