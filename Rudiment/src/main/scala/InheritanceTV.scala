// `turnOn`, `turnOff`, wattsPerSec are inheritated from `trait` or can be modified/override here as well
/*
class InheritanceTV extends Device {
  override val wattsPerSec: Int = 500

  override def turnOn(): Unit = {
    super.turnOn()
    println("TV is On")
  }

  private[this] def actuallyOn(): Unit = {
  	println("TV is On")
  }

  override def turnOff(): Unit = {
    super.turnOff()
    println("TV is Off")
  }
}
*/

class InheritanceTV extends Device {
  override val wattsPerSec: Int = 500

  // 1.`Template` pattern is a mix with `Subtype Polymorphism` & `Inheritance`

  override protected[this] def actuallyOn(): Unit = {
    // Using `Template` pattern /1.
    println("TV is On")
  }

  override protected[this] def actuallyOff(): Unit = {
    // Using `Template` pattern /1.
    println("TV is Off")
  }

  override protected[this] def totalEnergyConsumption(): Unit = {
    // Using `Template` pattern /1.
    println("Energy Consumption of TV : ")
  }
}
