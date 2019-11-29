// ... from previous part
// We're still passing through 3 functions with each device. How to get rid of this
// In OOP, Dynamic Dispatch solves this issue. Subtype Polymorphism i.e. a type can have differnt forms. Here `Device` can be a `Bulb` or a `TV`.
// Sometime it is called Dynamic Dispatch as well as the compiler dispatch the type at run time for us dynamically.

object ObjOrientationDynamicDispatch extends App {

  println("-" * 80)

  // final case class Device(wattsPerSec: () => Int, turnDeviceOn: () => Unit, turnDeviceOff: () => Unit)

  // Make the Device DS as a class and have those parameter as method var, like this way.
  // We can make class `Device` as abstract and remove those `sys.error`. By doing this, we can avoid the error msg as well as protect the Device to be instantiated.
  // We can make class `Device` a trait instead of `abstract class`. `trait` & `abstract class` are same with some features difference.
  // If we have something abstract, we can start as a `trait`

  //   abstract class Device {
  trait Device {
    /*
        var wattsPerSec: () => Int = () => {
            sys.error("Assign a value first")
        }
        var turnDeviceOn: () => Unit = () => {
            sys.error("Assign a value first")
        }
        var turnDeviceOff: () => Unit = () => {
            sys.error("Assign a value first")
        }
    */

    /*
    def wattsPerSec: Int = {
      sys.error("Assign a value first")
    }

    def turnOn(): Unit = {
      sys.error("Assign a value first")
    }

    def turnOff(): Unit = {
      sys.error("Assign a value first")
    }
    */
    def wattsPerSec: Int
    def turnOn(): Unit
    def turnOff(): Unit

  }

  class EnergyMeter(device: Device) {

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
      device.turnOn()

      turnedOnAtMillis = System.currentTimeMillis
    }

    def stopMeasuring(): Unit = {
      device.turnOff()

      val durationInMillis = System.currentTimeMillis - turnedOnAtMillis
      val durationInSecs = durationInMillis.toDouble / 1000

      wattsConsumendInTotal += device.wattsPerSec * durationInSecs
    }
  }

  // We distibuted the staticDispatch in every device

  // Class TV
  class TV extends Device {
    /* def toDevice: Device = {
        val device = new Device
        device.wattsPerSec   = () => this.wattsPerSec
        device.turnDeviceOn  = () => this.turnOn()
        device.turnDeviceOff = () => this.turnOff()

        device
      } */

    override val wattsPerSec: Int = 500

    override def turnOn(): Unit = {
      println("TV ON")
    }

    override def turnOff(): Unit = {
      println("TV OFF")
    }
  }
  // Class Bulb
  class Bulb extends Device {
    /* def toDevice: Device = {
        val device = new Device
        device.wattsPerSec   = () => this.wattsPerSec
        device.turnDeviceOn  = () => this.turnOn()
        device.turnDeviceOff = () => this.turnOff()

        device
        } */

    override val wattsPerSec: Int = 100

    override def turnOn(): Unit = {
      println("Bulb ON")
    }

    override def turnOff(): Unit = {
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
  val energyMeter = new EnergyMeter(lightBulb)

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
