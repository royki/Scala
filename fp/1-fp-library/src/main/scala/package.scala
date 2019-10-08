package object fplibrary {

  private type Thunk[A] = () => A
  type Description[A] = Thunk[A]

  private type RegularArrow[A, B] = A => B
  // ** Monads are there for the composition of KleisliArrows
  private type KleisliArrow[A, B, C[_]] = A => C[B]

  implicit final class InfixNotationForPoint[A, B](private val ab: A => B)
    extends AnyVal {
    def `;`[C](bc: B => C): A => C = PointFree.comppose(ab, bc)
    def `.`[C](bc: B => C): A => C = PointFree.comppose(ab, bc) // Haskel
    def `-->`[C](bc: B => C): A => C = PointFree.comppose(ab, bc)
  }
}
