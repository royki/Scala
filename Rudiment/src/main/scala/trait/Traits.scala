// Trait - 1] Add Functionalities; 2] Modify Functionalities 3] Intercept Functionalities

object Traits extends App {
  println("-" * 80)

  trait Pet {
    def allowedToSleepInBed: Boolean
    def notallowedToSleepInBed: Boolean = !allowedToSleepInBed
  }

  class Animal

  class Cat extends Animal with Pet {
    val allowedToSleepInBed: Boolean = true
  }

  class Turtle extends Animal with Pet {
    def allowedToSleepInBed: Boolean = false
  }

  def show(pet: Pet): Unit = {
    println(pet.notallowedToSleepInBed)
  }

  // show(new Cat)
  // show(new Turtle)

  val path = "/home/croy/Scala/Rudiment/src/main/scala/trait/Traits.scala"

  trait TimeStamp {
    val creationTime: String = {
      val formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")

      java.time.LocalDateTime.now.format(formatter)
    }
  }

  // class FileWithTimeStamp(path: String) extends java.io.File(path) with TimeStamp (1)

  // val file = new FileWithTimeStamp(path) (1)
  // val file = new java.io.File(path)
  // println(file.getName)
  // println(file.creationTime)

  // create a class on-fly and instantiate only class by using anonymous function instead of creating a class (1)

  // val file: java.io.File with TimeStamp = new java.io.File(path) with TimeStamp

  // `type` alias
  type FileWithTimeStamp = java.io.File with TimeStamp
  val file: FileWithTimeStamp = new java.io.File(path) with TimeStamp

  def showFileName(file: FileWithTimeStamp /*java.io.File*/ ): Unit = {
    println(file.getName)
  }

  def showcreationOfFileTime(timeStamp: FileWithTimeStamp /*TimeStamp*/ ): Unit = {
    println(timeStamp.creationTime)
  }

  showFileName(file)
  showcreationOfFileTime(file)

  println("-" * 80)
}
