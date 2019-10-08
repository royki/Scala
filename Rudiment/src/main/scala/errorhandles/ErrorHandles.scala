import Helpers._

object ErrroHandles extends App {

  println("-" * 75)

  showRed("Hello World")
  showGreen("Hello World")
  showYellow("Hello World")

  val file = new File(location  = "..\\src\\main\\scala\\errorhandles\\ErrorHandles.scala", name = "Main", extension = ".scala", content = "Hello World")

  val status = file.write()

  if (status == true)
    showGreen("All Good")
  else
    showRed("Hummm, XXX")

  println("-" * 75)
}
