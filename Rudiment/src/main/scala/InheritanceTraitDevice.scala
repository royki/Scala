trait Device {
  def wattsPerSec: Int

  protected[this] var _isOn: Boolean = false

  def isOn: Boolean = _isOn
  protected[this] def isOn_=(newValue: Boolean): Unit = {
    _isOn = newValue
  }

  def isOff: Boolean = !isOn
  protected[this] def isOff_=(newValue: Boolean): Unit = {
    _isOn = !newValue
  }

  // def turnOn(): Unit
  // def turnOff(): Unit

  final def turnOn(): Unit = {
    if (isOff) {
      isOn = true

      actuallyOn()
    }
    else
      sys.error("On")
  }

  protected[this] def actuallyOn(): Unit

  final def turnOff(): Unit = {
    if (isOn) {
      isOff = true

      actuallyOff()
      totalEnergyConsumption()
    }
    else
      sys.error("Off")
  }

  protected[this] def actuallyOff(): Unit
  protected[this] def totalEnergyConsumption(): Unit
}

