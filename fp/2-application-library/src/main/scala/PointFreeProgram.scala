import fplibrary._

// ** Only unit of computation is Function

object PointFreeProgram {

  def createDescription(args: Array[String]): Description[Unit] =
    Description.create(
      // val result: Unit = display(
      //   hypens(())
      // )

      // display(
      //   question(result)
      // )

      // display(question(display(hypens(()))))

      // val input: String = prompt()
      // val integerAmount: Int = convertStringToInt(input)
      // val positiveAmount: Int = ensureAmountIsPositive(integerAmount)
      // val balance: Int = round(positiveAmount)
      // val message: String = createMessage(balance)

      // val input: String = prompt()
      // val integerAmount: Int = convertStringToInt(prompt())
      // val positiveAmount: Int =
      //   ensureAmountIsPositive(convertStringToInt(prompt()))
      // val balance: Int =
      //   round(ensureAmountIsPositive(convertStringToInt(prompt())))
      // val message: String = createMessage(
      //   round(ensureAmountIsPositive(convertStringToInt(prompt())))
      // )

      // display(
      //   createMessage(
      //     round(ensureAmountIsPositive(convertStringToInt(prompt(()))))
      //   )
      // )
      display(
        hypens(
          display(
            createMessage(
              round(
                ensureAmountIsPositive(
                  convertStringToInt(
                    prompt(display(question(display(hypens(args)))))))))))))

  private def hypens(input: Any): String = "-" * 50
  private def question(input: Any): String = "Enter the amount to deposit"

  // Side effect (Writing to Console)
  private def display(input: Any): Unit = {
    println(input)
  }

  // Side effect (Reading from Console)
  private def prompt(input: Any): String = {
    scala.io.StdIn.readLine
  }

  // Potential side effect (throwing - NumberFormatException)
  private def convertStringToInt(input: String): Int = {
    input.toInt
  }

  private def ensureAmountIsPositive(amount: Int): Int = {
    if (amount < 1) 1
    else amount
  }

  @scala.annotation.tailrec
  private def round(amount: Int): Int = {
    if (isDivisibleBy100(amount)) amount
    else round((amount + 1))
  }

  private def isDivisibleBy100(amount: Int): Boolean = amount % 100 == 0

  private def createMessage(balance: Int): String =
    s"The deposit Amount is USD $balance"
}
