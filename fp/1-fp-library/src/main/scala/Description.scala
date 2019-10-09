import fplibrary._

object Description {
  // ByName Parameter
  def create[A](a: => A): Description[A] = () => a

// ** It has to be `def` as it has the generic parameter
  def brokenCreate[A]: /* (=> A) */ A => Description[A] = a => () => a
}
