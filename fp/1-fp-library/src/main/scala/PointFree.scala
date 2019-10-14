package fplibrary

object PointFree {
  // Parametric Polymorphism
  //   val ac = compose(ab, bc)

  def comppose[A, B, C](ab: A => B, bc: B => C): A => C = a => {
    // Produce a C over here
    val b = ab(a)
    val c = bc(b)
    c
  }
  def composeKleisli[A, B, C](adb: A => Description[B], bdc: B => Description[C]): A => Description[C] = a => {
    // ** Produce Description[C]
    val db: Description[B] = adb(a)
    val b = db.apply()
    val dc = bdc(b)
    dc
  }

  def composeKleisli2[A, B, C, D[_]: Monad](adb: A => D[B], bdc: B => D[C]): A => D[C] = a => {
    // ** Produce D[C]
    val db: D[B] = adb(a)
    // val b = db.apply()
    // val dc = bdc(b)
    // dc
    val dc = Monad[D].flatMap(db)(bdc)
    dc
  }

  // def helper[B, C, D[_]](db: D[B], bdc: B => D[C]): D[C] = ???

  trait hasHelper[D[_]] {
    def helper[B, C](db: D[B])(bdc: B => D[C]): D[C]
  }

  /* trait Monad[C[_]] {
    def flatMap[A, B](ca: C[A])(acb: A => C[B]): C[B]
    @inline def bind[A, B](ca: C[A])(acb: A => C[B]): C[B] = flatMap(ca)(acb)
    @inline def >>=[A, B](ca: C[A])(acb: A => C[B]): C[B] = flatMap(ca)(acb)

  }

  object Monad {
    def apply[C[_]: Monad]: Monad[C] = implicitly[Monad[C]]
  } */

}
