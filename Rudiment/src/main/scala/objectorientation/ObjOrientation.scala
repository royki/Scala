// ... from previous part
// ** We ve lost the Dependency Inversion as well as type safety. Also whenever we ve a new device, we need to add the pattern match for that device
// ** To solve this, instead of passng 3 parameters in class `EnergyMeter`, make a seperate data structure using Scala `case class`, and they ll come as parameters & pass that ds to the `EnergyMeter` class

object ObjOrientation extends App {

  println("-" * 80)

  final case class Device(wattsPerSec: () => Int, turnDeviceOn: () => Unit, turnDeviceOff: () => Unit)

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
      device.turnDeviceOn()

      turnedOnAtMillis = System.currentTimeMillis // milliseconds since Jan 1, 1970 by convention
    }

    def stopMeasuring(): Unit = {
      device.turnDeviceOff()

      val durationInMillis = System.currentTimeMillis - turnedOnAtMillis
      val durationInSecs = durationInMillis.toDouble / 1000

      /* Use private val with `_` by convention*/
      // _wattsConsumendInTotal += wattsPerSec * durationInSecs

      /* `def wattsConsumendInTotal` - to get rid of `_` when used as private val */
      // wattsConsumendInTotal(wattsConsumendInTotal + (wattsPerSec * durationInSecs))

      /* To use similar as val use method name with `_` as `def wattsConsumendInTotal_`
        - now we can use method as val. Scala syntactic sugar */
      wattsConsumendInTotal += device.wattsPerSec() * durationInSecs

      // println(_wattsConsumendInTotal)
    }

    // Make a auxilury constructor for multipe device to pass device TV or Bulb directly to EnergyMeter *
    /*
      def this(device: Bulb) =
        this(
          wattsPerSec   = device.wattsPerSec,
          turnDeviceOn  = () => device.turnOn(),
          turnDeviceOff = () => device.turnOff()
      )
      */

    /*
      ** If we do this, we have a problem as device can be Bulb or TV at one time. To avoid this, make the device type as `Any`,
      But type `Any` doesn't have `turnOn` or `turnOff` methods. To have those, we can use of `asInstanceOf`, in the following way.

      As the auxillary constructor calls the primary constructor or some other constructors, We need to take this method out and put in suitable component.
      To do this, we need to make a companion object of EneryMeter and put this method there named as `apply`. This is actually `staticDispatch` in OOP programmatic term.

     ** Problem => We ve the Dependency Inversion but we lost type safety. Also whenever we ve a new device, we need to add the pattern match for that device
      */
    /*
      def this(device: Any) = {
       if(device.isInstanceOf[Bulb]) {
        val lightBulb: Bulb = device.asInstanceOf[Bulb]
        this(
          wattsPerSec   = device.wattsPerSec,
          turnDeviceOn  = () => device.turnOn(),
          turnDeviceOff = () => device.turnOff()
        )
       }
       else if(device.isInstanceOf[TV]) {
        val tv: TV = device.asInstanceOf[TV]
        this(
          wattsPerSec   = device.wattsPerSec,
          turnDeviceOn  = () => device.turnOn(),
          turnDeviceOff = () => device.turnOff()
        )
       } else {
         sys.error("Not a Device")
       }
      }
     */

  }

  /* We distibuted the staticDispatch in every device
    // ** Make the `DeviceListed` object as companion object for `EnergyMeter`, change the method name `staticDispatch` to `apply`
    object EnergyMeter /* DeviceListed */ {
      // * Now if we have, another device as `TV` or `Music`, how to pass then; use `Any`
      // ** Problem => We ve lost Dependency Inversion as well as type safety. Also whenever we ve a new device, we need to add the pattern match for that device
      def apply /* staticDispatch */ (device: Any): EnergyMeter = device match {
        case lightBulb: Bulb =>
          new EnergyMeter(
            wattsPerSec   = lightBulb.wattsPerSec,
            turnDeviceOn  = () => lightBulb.turnOn(),
            turnDeviceOff = () => lightBulb.turnOff()
          )
        case tv: TV =>
          new EnergyMeter(
            wattsPerSec   = tv.wattsPerSec,
            turnDeviceOn  = () => tv.turnOn(),
            turnDeviceOff = () => tv.turnOff()
          )
        case _ => sys.error("No Device Found")
      }
    }

    */

  // Class TV
  class TV {
    def toDevice: Device = Device(
      wattsPerSec   = () => this.wattsPerSec,
      turnDeviceOn  = () => this.turnOn(),
      turnDeviceOff = () => this.turnOff()
    )

    val wattsPerSec: Int = 500

    def turnOn(): Unit = {
      println("TV ON")
    }

    def turnOff(): Unit = {
      println("TV OFF")
    }
  }
  // Class Bulb
  class Bulb {
    def toDevice: Device = Device(
      wattsPerSec   = () => this.wattsPerSec,
      turnDeviceOn  = () => this.turnOn(),
      turnDeviceOff = () => this.turnOff()
    )

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
  val energyMeter = new EnergyMeter(tv.toDevice)

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

// ... To be Continued
// We're still passing through 3 functions with each device. How to get rid of this
