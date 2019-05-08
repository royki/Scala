object Core {
  class OrdinaryCar(override val model: String) extends Base.Car {
    override def topSpeedInKm: Int = 220
    override def topAccelerationInRpm: Int = 8000
    override def brand /*(b: String)*/ : String = ""
  }

  class SportsCar(override val model: String) extends Base.Car {
    override def topSpeedInKm: Int = 300
    override def topAccelerationInRpm: Int = 11000
    override def brand /*(b: String)*/ : String = ""
  }

  // java.util.HashSet[String]
}
