import scala.io.Source

object mnemonics extends App {

  // Read a fild of words

  val in = Source.fromFile("/host/Practice/Scala/Exc/Problems/linuxwords.txt")

  // Get words of each line

  val words = in.getLines.toList.filter(word => word.forall(chr => chr.isLetter))
  // println(words)

  // Define a Map of numbers to letters
  val mnem: Map[Char, String] = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")  
  // Invert the Map to get a Map of letters to digits  
  var charCode: Map[Char, Char] =
    for (
      (digit, str) <- mnem;
      ltr <- str
    ) yield ltr -> digit
  
  // println(charCode)
	

  // Maps a word to the digit string it can represent, e.g. "Java" -> "5282"
  // Define a function that returns the numbers of a given word
  def wordCode(word: String): String = {
    word.toUpperCase.map(charCode)
  }

  println(wordCode("Scala")) // 72252
  println(wordCode("Java")) // 5282

  def digitCode(digit: String): Seq[String] = {
  	digit.map(mnem)
  }
  
  println(digitCode(72252.toString)) // Vector(PQRS, ABC, ABC, JKL, ABC)
  println(digitCode(5282.toString)) // Vector(JKL, ABC, TUV, ABC)


  // Group all words of long list with the same number
  val wordsForNum: Map[String, Seq[String]] =
          words.groupBy(wordCode).withDefaultValue(Seq())
  
  println(wordsForNum("5282"))
  println(wordsForNum("72252"))

  // Return all ways to encode a number as a list of words
  // Function that receives a number and finds the words that match it
  def encode(number: String): Set[List[String]] = {
          if(number.isEmpty) Set(List())
          else {
          	for {
                  split <- 1 to number.length
                  word <- wordsForNum(number.take(split))
                  rest <- encode(number.drop(split))
                } yield word :: rest
          	}.toSet
  }

  def translate(number: String): Set[String] = {
          encode(number)map(n => n.mkString(" "))
  }

  // encode("7225247386").foreach(println)
  translate("7225247386").foreach(println)

}