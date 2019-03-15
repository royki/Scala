// Sealed trait
sealed trait CC extends Any with Product with Serializable {
	import CC._

	def number: String

	// Companion method
	final def isValid: Boolean = isInstanceOf[Valid]
	final def isNotValid: Boolean = !isValid

	final override def toString: String = {
		val invalid = Console.RED + "Invalid" + Console.RESET
		if (isNotValid) {
			s""" $invalid credit card number "$number" """
		}
		else {
			val valid = Console.GREEN + "Valid" + Console.RESET
			val (payload, checkDigit) = split(number)
			s""" $valid credit card number "$number" with payload "$payload" and check digit "$checkDigit" """
		}
	}
}

// Companion object
object CC extends (String => CC) with (() => CC) {


	final case class Invalid private (number: String) extends AnyVal with CC /*CC*/
	object Invalid {
		private[CC] def apply(number: String): Invalid = {
			new Invalid(number)
		}
	}

	final case class Valid private (number: String) extends AnyVal with CC /*CC*/
	object Valid {
		private[CC] def apply(number: String): Valid = {
			new Valid(number)
		}
	}

	def apply(number: String): CC = {
		if(isValid(number))
			Valid(number)
		else Invalid(number)
	}

	private val checkDigitLength = 1
	private val MinimumLength = 13
	private val MaximumLength = 19

	private def isValid(number: String): Boolean = {
		number != null &&
		number.nonEmpty &&
		number.forall(Character.isDigit) &&
		(MinimumLength to MaximumLength).contains(number.length) &&
		doesMathCheckOut(number)
	}

	private def doesMathCheckOut(number: String): Boolean = {
		val (payload, checkDigit) = split(number)
		val sum = luhn(payload) + checkDigit
		sum % 10 == 0
	}


	private def luhn(payload: String): Int = {
		payload
		.reverse // String
		.map(_.toString.toInt) // IndexedSeq[Int]
		.zipWithIndex // IndexedSeq[(Int= Digit, Int= ZeroBasedIndex)] // 1st element has index zero
		.map {
			case (digit, index) =>
				if(index % 2 == 0)
					digit * 2
				else
					digit
			} // IndexedSeq[Int]
			.map {
				number => if(number > 9) number - 9
				else number
			} // IndexedSeq[Int = Digit]
			.sum
		}

		// Generate Valid number
		def apply(): Valid = {
			Valid(generatedNumber)
		}

		private def split(number: String):(String, Int) = {
			val payload = number.dropRight(checkDigitLength)
			val checkDigit = number.takeRight(checkDigitLength).toInt
			// payload -> checkDigit
			(payload, checkDigit)
		}

		private def generatedNumber: String = {
			val payload = {
				import scala.util.Random
				val min: Int = MinimumLength - checkDigitLength // 12
				val max: Int = MaximumLength - checkDigitLength // 18
				val length: Int = min + Random.nextInt((max - min) + 1) // 12 to 18
				//    12  + 0 until (6 + 1)
				def randomDigit: Int =
					Random.nextInt(10) // 0 to 9

				(1 to length) // FiniteRange
				.map(_ => randomDigit) // IndexedSeq[Int]
				.mkString // String
			}

			val checkDigit: Int =
				(10 - (luhn(payload) % 10)) % 10

			val number: String = payload + checkDigit

			if(isValid(number))
				number
			else
				// $COVERAGE-OFF$
			sys.error(s"Bug: Generated an Invalid Number: $number")
			// $COVERAGE-OFF$
		}
	}