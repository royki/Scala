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

    // pass device TV or Bulb directly to EnergyMeter *
    /*def this(device: Bulb) =
      this(
        wattsPerSec   = device.wattsPerSec,
        turnDeviceOn  = () => device.turnOn(),
        turnDeviceOff = () => device.turnOff()
      )*/

    // private instance variable
    private[this] var turnedOnAtMillis: Long = 0
    private[this] var _wattsConsumendInTotal: Double = 0

    // getter or accessor
    def wattsConsumendInTotal: Double = _wattsConsumendInTotal

    // setter or mutator
    private[this] def wattsConsumendInTotal_=(newValue: Double): Unit = {
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

      /* Use private val with `_` by convention*/
      // _wattsConsumendInTotal += wattsPerSec * durationInSecs

      /* `def wattsConsumendInTotal` - to get rid of `_` when used as private val */
      // wattsConsumendInTotal(wattsConsumendInTotal + (wattsPerSec * durationInSecs))

      /* To use similar as val use method name with `_` as `def wattsConsumendInTotal_`
      - now we can use method as val. Scala syntactic sugar */
      wattsConsumendInTotal += wattsPerSec * durationInSecs

      // println(_wattsConsumendInTotal)
    }
  }

  // ** Make the `DeviceListed` object as companion object for `EnergyMeter`, change the method name `staticDispatch` to `apply`
  object EnergyMeter /* DeviceListed */ {
    // * Now if we have, another device as `TV` or `Music`, how to pass then; use `Any`
    def apply /* staticDispatch */ (device: Any): EnergyMeter = device match {
      // using pattern matching
      case lightBulb: Bulb =>
        // if (device.isInstanceOf[Bulb]) {
        val lightBulb: Bulb = device.asInstanceOf[Bulb]
        new EnergyMeter(
          wattsPerSec   = lightBulb.wattsPerSec,
          turnDeviceOn  = () => lightBulb.turnOn(),
          turnDeviceOff = () => lightBulb.turnOff()
        )
      // }
      case tv: TV =>
        // else if (device.isInstanceOf[TV]) {
        val tv: TV = device.asInstanceOf[TV]
        new EnergyMeter(
          wattsPerSec   = tv.wattsPerSec,
          turnDeviceOn  = () => tv.turnOn(),
          turnDeviceOff = () => tv.turnOff()
        )
      // }
      case _ => sys.error("No Device Found")
      // else sys.error("No Device Found")
    }
  }

  // how to use if we've multiple devices
  /*
  val wattsPerSecBulb: Int = 100

  def turnOnBulb(): Unit = {
    println("Bulb ON")
  }

  def turnOffBulb(): Unit = {
    println("Bulb OFF")
  }

  val energyMeter = new EnergyMeter(
    wattsPerSec   = wattsPerSecBulb,
    turnDeviceOn  = () => turnOnBulb,
    turnDeviceOff = () => turnOffBulb
  )
  */

  // wrapp the following functions and property with a `class`

  // TV
  class TV {
    val wattsPerSec: Int = 500

    def turnOn(): Unit = {
      println("TV ON")
    }

    def turnOff(): Unit = {
      println("TV OFF")
    }
  }
  // Bulb
  class Bulb {
    val wattsPerSec: Int = 100

    def turnOn(): Unit = {
      println("Bulb ON")
    }

    def turnOff(): Unit = {
      println("Bulb OFF")
    }
  }

  val lightBulb: Bulb = new Bulb
  val tv: TV = new TV

  /*
 val energyMeter = new EnergyMeter(
    wattsPerSec   = lightBulb.wattsPerSec,
    turnDeviceOn  = () => lightBulb.turnOn,
    turnDeviceOff = () => lightBulb.turnOff
  )
*/

  // pass device TV or Bulb directly to EnergyMeter. to do this - change in `EnergyMeter` class; added  `def this` method
  // val energyMeter = new EnergyMeter(tv)

  // To have multiple devices, we created object `staticDispatch`, to listed diveces as type `Any` and make instance of each device
  // val energyMeter = DeviceListed.staticDispatch(lightBulb)

  // ** As we make `DeviceListed` as companion object of `EnergyMeter` class, so we can use it directly the companion object
  val energyMeter = EnergyMeter.apply(lightBulb)

  energyMeter.startMeasuring()
  Thread.sleep(1000)
  energyMeter.stopMeasuring()
  println(energyMeter.wattsConsumendInTotal)

  println

  energyMeter.startMeasuring()
  Thread.sleep(1000)
  energyMeter.stopMeasuring()
  println(energyMeter.wattsConsumendInTotal)

  println("-" * 80)
}
