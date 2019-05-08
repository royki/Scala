object Modifications {

  // Extends from Base Car
  trait Spoiler extends Base.Car {
    abstract override def topSpeedInKm: Int = (super.topSpeedInKm * 1.02).toInt
  }

  // Extends from Core OrdinaryCar
  trait EngineControlUnit extends Core.OrdinaryCar {
    override def topSpeedInKm: Int = (super.topSpeedInKm * 1.5).toInt
  }

  // Extends from Core OrdinaryCar
  trait TurboCharger extends Core.OrdinaryCar {
    override def topAccelerationInRpm: Int = (super.topAccelerationInRpm * 1.25).toInt
  }

  // Extends from Core SportsCar
  trait ExtraUnit extends Core.SportsCar {
    override def topSpeedInKm: Int = (super.topSpeedInKm * 1.25).toInt
    override def topAccelerationInRpm: Int = (super.topAccelerationInRpm * 1.5).toInt
  }

  // Trait Interception
  // Set Exmple
  trait CaseIgnorance extends java.util.Set[String] {
    abstract override def add(element: String) =
      super.add(element.toLowerCase)

    abstract override def contains(element: Any) = {
      super.contains(element.asInstanceOf[String].toLowerCase)
    }

    abstract override def remove(element: Any) = {
      super.remove(element.asInstanceOf[String].toLowerCase)
    }
  }

  trait Logging extends java.util.Set[String] {
    abstract override def add(element: String) = {
      println(s"Add: $element")
      super.add(element)
    }

    abstract override def remove(element: Any) = {
      println(s"Remove: $element")
      super.remove(element)
    }
  }
}
