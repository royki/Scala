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
  def compposeKleisli[A, B, C](
      adb: A => Description[B],
      bdc: B => Description[C]
  ): A => Description[C] = a => {
    // ** Produce Description[C]
    val db: Description[B] = adb(a)
    val b = db.apply()
    val dc = bdc(b)
    dc

  }
}
