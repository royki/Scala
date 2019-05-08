object TraitMain extends App {
  /*def main(args: Array[String]): Unit = {
    println("-" * 80)
    code(args)
    println("-" * 80)
  }*/

  println("-" * 80)
  code(args)
  println("-" * 80)

  def code(args: Array[String]): Unit = {

    // OrdinaryCar Car
    // OrdinaryCar with 3 Modifications applied; 1 from Base for `topSpeedInKm`, 1 from Core for `topSpeedInKm` & 1 from Core for `topAccelerationInRpm`
    final class BMW(override val model: String) extends Core.OrdinaryCar(model)
      with Modifications.Spoiler
      with Modifications.EngineControlUnit
      with Modifications.TurboCharger {
      // override def brand: String = "BMW"
    }

    // SportsCar
    // SportsCar with 1 Modifications applied;  only from Core for `topSpeedInKm`
    final class Lomborghini(override val model: String) extends Core.SportsCar(model)
      with Modifications.Spoiler
      with Modifications.ExtraUnit {
      // override def brand: String = "Lomborghini"
    }

    println(new BMW("M3-GTR"))
    println(new Lomborghini("Murcielago"))

    val firstLogThenIgnoreCase = new java.util.HashSet[String] with Modifications.CaseIgnorance with Modifications.Logging

    val firstIgnorCaseThenLog = new java.util.HashSet[String] with Modifications.Logging with Modifications.CaseIgnorance

    firstLogThenIgnoreCase.add("HI")
    firstLogThenIgnoreCase.remove("I")

    firstIgnorCaseThenLog.add("HI")
    firstIgnorCaseThenLog.remove("H")

    println(firstLogThenIgnoreCase.contains("HI") && firstIgnorCaseThenLog.contains("I"))
    println(executionStart)
    println(new java.util.Date(executionStart))
  }
}
