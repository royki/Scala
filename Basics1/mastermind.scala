import scala.Random

type Color = Int
type Game = List[Int] => (Int, Int)

/* Question: why would writing
 * 
 *     def rgen = new Random
 *
 * be a bad idea?
 */
val rgen = new Random

/* Computes the set of all possible secret codes of length numPegs
 * containing colors (0 until numColors), using a for-comprehension.
 */
def initialSpace(numPegs: Int, numColors: Int): Set[List[Int]] = {
    if (numPegs == 0) Set(List())
    else for { code  <- initialSpace(numPegs - 1, numColors)
               color <- (0 until numColors) }
         yield color :: code
}

/* Returns the Mastermind rating of "guess" c1 with respect to "code" c2,
 * or, equivalently, "guess" c2 with respect to "code" c1.  These game
 * role terms are actually meaningless.
 */
def rate(c1: List[Color], c2: List[Color]): (Int, Int) = {
    val exact = (c1 zip c2) count (pair => pair._1 == pair._2)
    val mins = Set(c1:_*).toList.map(c => c1.count(c==) min c2.count(c==))
    val sum = mins.foldRight(0)(_+_)
    return (exact, sum - exact)
}

/* Picks a random secret code and returns a partially-applied version of
 * the rate function which may be used to compare guesses against the
 * secret code.  Note that the code itself never escapes from the scope of
 * startGame (except via println).
 */
def startGame(numPegs: Int, numColors: Int): Game = {
    val code = List.tabulate(numPegs, x => rgen.nextInt(numColors))
    println("Secret code: " + code)
    (guess: List[Color]) => {
        println("You guessed: " + guess)
        rate(code, guess)
    }
}

/* Picks the next guess randomly from the space of possible guesses.
 */
def nextGuess(space: Set[List[Int]]) =
    space.toList(rgen.nextInt(space.size))

/* The main search loop.  Recursively calls itself until the guess space
 * is empty.  Arm's length recursion would be required to return the final
 * guess; instead, this implementation relies on the game function to
 * print guesses along the way.
 */
def iterate(game: Game, space: Set[List[Int]]) {
    if (space.size > 0) {
        val guess = nextGuess(space)
        val rating = game(guess)
        val filtered = (space - guess).filter(rate(_, guess) == rating)
        iterate(game, filtered)
    }
}

/* The main entry point.  E.g., playGame(4, 6) will conduct an instance of
 * the traditional Mastermind game.
 */
def playGame(numPegs: Int, numColors: Int) =
    iterate(startGame(numPegs, numColors),
            initialSpace(numPegs, numColors))
