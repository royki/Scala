// In scala `Maybe` is already implemented. And it is called `Option`

sealed abstract class Maybe[+A] {
  def isEmpty: Boolean
  def get: A
}

// Companion object
object Maybe {
  def apply[A](value: A): Maybe[A] =
    if (value == null)
      NotReally
    else
      SureThing(value)
  def empty[A]: Maybe[A] = NotReally
}

final case class SureThing[+A](value: A) extends Maybe[A] {
  override def get: A = value
  override def isEmpty: Boolean = false
}

case object NotReally extends Maybe[Nothing] {
  override def get: Nothing = throw new NoSuchElementException
  override def isEmpty: Boolean = true

}
