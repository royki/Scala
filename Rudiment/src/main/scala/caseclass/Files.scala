object Files {
  def apply(location: String, name: String, extention: String): String =
    s"$location/$name.$extention"

  def unapply(path: String): Option[(String, String, String)] = {
    if (path == null || path.isEmpty)
      None
    else {
      val lastIndexOfSlash = path.lastIndexOf("/")
      val lastIndexOfDot = path.lastIndexOf(".")

      val location = path.substring(0, lastIndexOfSlash) // until the last slash
      val name = path.substring(lastIndexOfSlash + 1, lastIndexOfDot) // between the last slash and the last dot
      val extention = path.substring(lastIndexOfDot + 1) // after the last dot

      Some(
        (
          location, name, extention
        )
      )
    }
  }
}

case class Files(location: String, name: String, extention: String) {
  override def toString: String = (s"$location/$name.$extention")
}

// Another `unapply`
object IsLocationLongerThan20Characters {
  def unapply(path: String): Boolean = path.length > 20
}
