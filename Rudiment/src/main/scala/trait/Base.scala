object Base {
  abstract class Car {
    def model: String
    def topSpeedInKm: Int
    def topAccelerationInRpm: Int
    def brand /*(b: String)*/ : String

    override def toString: String = {
      val brand = getClass.getName

      brand + " " + model + " " + topSpeedInKm + " " + topAccelerationInRpm
    }
  }

  // java.util.Set[String]
}
