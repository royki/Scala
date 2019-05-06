object InheritanceEnergyMeter extends App {

  class EnergyMeter(device: Device) {

    private[this] var turnedOnAtMills: Long = 0

    private[this] var _wattsConsumedInTotal: Double = 0
    def wattsConsumedInTotal: Double = _wattsConsumedInTotal
    private[this] def wattsConsumedInTotal_=(newValue: Double): Unit = {
      _wattsConsumedInTotal = newValue
    }

    def startMeasuring(): Unit = {
      device.turnOn()

      turnedOnAtMills = System.currentTimeMillis
    }

    def stopMeasuring(): Unit = {
      device.turnOff()

      val durationInMills = System.currentTimeMillis - turnedOnAtMills
      val durationInSec = durationInMills.toDouble / 1000

      wattsConsumedInTotal += device.wattsPerSec + durationInSec
    }
  }

  val bulb = new InheritanceBulb()
  val tv = new InheritanceTV()

  val meter = new EnergyMeter(tv)

  meter.startMeasuring
  Thread.sleep(1000)
  meter.stopMeasuring
  println(meter.wattsConsumedInTotal)

  println

  meter.startMeasuring
  Thread.sleep(1000)
  meter.stopMeasuring
  println(meter.wattsConsumedInTotal)

}
