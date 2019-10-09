package object fplibrary {

  private type Thunk[A] = () => A
  type Description[A] = Thunk[A]

  private type RegularArrow[A, B] = A => B

  // ** Monads are there for the composition of KleisliArrows
  private type KleisliArrow[A, B, C[_]] = A => C[B]

  implicit final class InfixNotationForPoint[A, B](private val ab: A => B)
      extends AnyVal {
    def `;`[C](bc: B => C): A => C = PointFree.comppose(ab, bc)
    def `.`[C](bc: B => C): A => C = PointFree.comppose(ab, bc) // Haskell `dot`
    def `-->`[C](bc: B => C): A => C = PointFree.comppose(ab, bc)
  }

  implicit final class InfixNotationForPointFreeKleisli[A, B](
      private val adb: A => Description[B]
  ) extends AnyVal {
    def `;;`[C](bdc: B => Description[C]): A => Description[C] =
      PointFree.compposeKleisli(adb, bdc)
    def >=>[C](bdc: B => Description[C]): A => Description[C] =
      PointFree.compposeKleisli(adb, bdc) // Haskell `fish`
  }

}
