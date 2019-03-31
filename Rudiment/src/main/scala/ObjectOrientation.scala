// Discover the primary value that Object Oriented programming has to offer:
// Dependency Inversion or Inversion of Control (IoC) via Subtype Polymorphism and dynamic dispatch.

object ObjectOrientation extends App {

  println("-" * 80)

  /*
  def f(g: Int => String, h: String => String, i: String => Char): Unit = {
    val resultOfG: String = g(1337)
    val resultOfH: String = h(resultOfG)
    val resultOfI: Char = i(resultOfH)

    println(resultOfI)
  }

  def g(num: Int): String = {
    Console.RED + num.toString.reverse + Console.RESET
    // num.toString.reverse
  }

  def h(str: String): String = {
    str
  }

  def i(str: String): Char = {
    if (str.nonEmpty)
      str(0)
    else
      '?'
  }

  f(g, h, i)
*/

  /*
  class F(g: Int => String, h: String => String, i: String => Char) {
    def doStuff(): Unit = {
      val resultOfG: String = g(1337)
      val resultOfH: String = h(resultOfG)
      val resultOfI: Char = i(resultOfH)

      println(resultOfI)
    }
  }

  def g(num: Int): String = {
    Console.RED + num.toString.reverse + Console.RESET
    // num.toString.reverse
  }

  def h(str: String): String = {
    str
  }

  def i(str: String): Char = {
    if (str.nonEmpty)
      str(0)
    else
      '?'
  }

  val f = new F(g, h, i)
  f.doStuff()
*/

  class EnergyMeter(wattsPerSec: Int, turnDeviceOn: () => Unit, turnDeviceOff: () => Unit) {

    // private instance variable
    private[this] var turnedOnAtMillis: Long = 0
    private[this] var _wattsConsumendInTotal: Double = 0
    def wattsConsumendInTotal: Double = _wattsConsumendInTotal // getter or accessor
    private[this] def wattsConsumendInTotal_=(newValue: Double): Unit = { // setter or mutator
      _wattsConsumendInTotal = newValue
    }

    def startMeasuring(): Unit = {
      turnDeviceOn()

      turnedOnAtMillis = System.currentTimeMillis // milliseconds since Jan 1, 1970 by convention
    }

    def stopMeasuring(): Unit = {
      turnDeviceOff()

      val durationInMillis = System.currentTimeMillis - turnedOnAtMillis
      val durationInSecs = durationInMillis.toDouble / 1000

      // _wattsConsumendInTotal += wattsPerSec * durationInSecs
      // wattsConsumendInTotal(wattsConsumendInTotal + (wattsPerSec * durationInSecs))
      wattsConsumendInTotal += wattsPerSec * durationInSecs

      // println(_wattsConsumendInTotal)
    }
  }

  val wattsPerSecTV: Int = 500

  def turnOnTV(): Unit = {
    println("TV ON")
  }

  def turnOffTV(): Unit = {
    println("TV OFF")
  }

  val energyMeter = new EnergyMeter(
    wattsPerSec   = wattsPerSecTV,
    turnDeviceOn  = () => turnOnTV,
    turnDeviceOff = () => turnOffTV
  )

  energyMeter.startMeasuring()
  Thread.sleep(1000)
  energyMeter.stopMeasuring()
  println(energyMeter.wattsConsumendInTotal)

  println

  println("-" * 80)
}
