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
}
