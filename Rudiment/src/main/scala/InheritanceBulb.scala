class InheritanceBulb extends Device {
  override val wattsPerSec: Int = 100

  override protected[this] def actuallyOn(): Unit = {
    // /1
    println("Bulb is On")
  }

  override protected[this] def actuallyOff(): Unit = {
    // /1
    println("Bulb is Off")
  }

  override protected[this] def totalEnergyConsumption(): Unit = {
    // Using `Template` pattern /1.
    println("Energy Consumption of Bulb : ")
  }
}

