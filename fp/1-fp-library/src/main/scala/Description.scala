import fplibrary._

object Description {
  // ByName Parameter
  def create[A](a: => A): Description[A] = () => a
}
