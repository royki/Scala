package advance

object AdvancePattenMatching extends App {
    val numbers = List(1)
    val description = numbers match {
        case head :: Nil => println(s"the only elemet is $head")
        case _ =>
    }
}