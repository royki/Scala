import fplibrary._

final case class IO[+A](unsafeRun: () => A /* Description[A] */) extends AnyVal

object Description {
  
  // private type Thunk[A] = () => A
  // type Description[A] = Thunk[A]

  // ByName Parameter
  def create[A](a: => A): Description[A] = () => a

// ** It has to be `def` as it has the generic parameter
  def brokenCreate[A]: /* (=> A) */ A => Description[A] = a => () => a

  implicit val M: Monad[Description] = new Monad[Description] {
    final override def flatMap[A, B](ca: Description[A])(acb: A => Description[B]): Description[B] = Description.create {
      val a = ca.apply()
      val cb = acb(a)
      val b = cb.apply()
      b
    }
  }
}
