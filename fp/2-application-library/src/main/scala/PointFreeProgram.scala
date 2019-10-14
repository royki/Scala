import fplibrary._

// ** Only unit of computation is `Function`

object PointFreeProgram {

  // def createDescription(args: Array[String]): Description[Unit] =
  // lazy val createDescription: Array[String] => Description[Unit] = args =>
  //   Description.brokenCreate(

  // val result: Unit = display(
  //   hyphens(())
  // )

  // display(
  //   question(result)
  // )

  // display(question(display(hyphens(()))))

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

  // ** Scala has built-in `eta` expression that turns `def` into `function`
  /*   display(
        hyphens(
          display(
            createMessage(
              round(
                ensureAmountIsPositive(
                  convertStringToInt(
                    prompt(display(question(display(hyphens(args)))))
                  )
                )
              )
            )
          )
        )
      )
    ) */

  import  Description._
  lazy val createDescription: Array[String] => Description[Unit] =
    ignoreArgs andThen
    hyphens `-->`
    displayKleisli >=>
    question `-->`
    displayKleisli >=>
    promptKleisli >=>
    convertStringToInt `-->`
    ensureAmountIsPositive `-->`
    round `-->`
    createMessage `-->`
    displayKleisli >=>
    hyphens `-->`
    displayKleisli /* >=>
    Description.brokenCreate */

  private lazy val ignoreArgs: Array[String] => Unit = _ => ()

  // ** Rewriting `def` to turn into function manually

  // private def hyphens(input: Any): String = "-" * 50
  // private lazy val hyphens: Any => String = _ => "-" * 50
  private lazy val hyphens: Any => String = input => "-" * 50

  // private def question(input: Any): String = "Enter the amount to deposit"
  // private lazy val question: Any => String = _ => "Enter the amount to deposit"
  private lazy val question: Any => String = input =>
    "Enter the amount to deposit"

  // Side effect (Writing to Console)
  /* private def display(input: Any): Unit = {
    println(input)
  } */
  private lazy val display: Any => Unit = input => {
    println(input)
  }

  private lazy val displayKleisli: Any => Description[Unit] = input => Description.create {
      println(input)
  }

  // Side effect (Reading from Console)
  /* private def prompt(input: Any): String = {
    scala.io.StdIn.readLine
  } */
  // private lazy val prompt: Any => String = _ => scala.io.StdIn.readLine
  private lazy val prompt: Any => String = input => scala.io.StdIn.readLine

  private lazy val promptKleisli: Any => Description[String] = input =>
    Description.create(scala.io.StdIn.readLine)

  // Potential side effect (throwing - NumberFormatException)
  /* private def convertStringToInt(input: String): Int = {
    input.toInt
  } */
  private def convertStringToInt: String => Int = input => input.toInt

  /* private def ensureAmountIsPositive(amount: Int): Int = {
    if (amount < 1) 1
    else amount
  } */
  private lazy val ensureAmountIsPositive: Int => Int =
    amount => if (amount < 1) 1 else amount

  /* @scala.annotation.tailrec
  private def round(amount: Int): Int = {
    if (isDivisibleBy100(amount)) amount
    else round((amount + 1))
  } */

  private lazy val round: Int => Int = amount => {
    if (isDivisibleBy100(amount)) amount
    else round((amount + 1))
  }

  // private def isDivisibleBy100(amount: Int): Boolean = amount % 100 == 0
  private lazy val isDivisibleBy100: Int => Boolean = amount =>
    amount % 100 == 0

  /* private def createMessage(balance: Int): String =
    s"The deposit Amount is USD $balance" */
  private lazy val createMessage: Int => String = balance =>
    s"The deposit Amount is USD $balance"
}
