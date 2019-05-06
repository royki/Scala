object MessagePassingStyle extends App {
  println("-" * 50)

  // `type` alias
  type accountSymbol = Symbol => Any

  def BankAccount(initialBalance: Int): accountSymbol /*(Int => Unit /*Int*/ )*/ = {
    var balance: Int = initialBalance

    val withdraw: Int => Unit /*Int*/ = amount => {
      if (balance >= amount) {
        balance = balance - amount
        // balance
      }
      else {
        sys.error("Insufficient Balance")
      }
    }

    // getBalance : takes Unit as parameter and returns Int
    val getBalance: () => Int = () => balance

    val deposit: Int => Unit /*Int*/ = amount => {
      if (amount >= 1) {
        balance = balance + amount
        // balance
      }
      else {
        sys.error("Amount should be >= 1")
      }
    }
    // How to return both withdraw and deposit function. To do that, we introduce `Symbol`

    val dispatch: accountSymbol /*(Int => Unit /*Int*/ )*/ = operation =>
      if (operation == 'withdraw)
        withdraw
      else if (operation == 'deposit)
        deposit
      else if (operation == 'getBalance)
        getBalance
      else
        sys.error(s"Unknow operation: $operation")

    dispatch
  }

  val account1 = BankAccount(initialBalance = 100)
  val withdraw1 = account1('withdraw).asInstanceOf[Int => Unit]
  val deposit1 = account1('deposit).asInstanceOf[Int => Unit]
  val getBalance1 = account1('getBalance).asInstanceOf[() => Int]

  println("Initial Balance in the account1", account1)
  println

  withdraw1(10)
  // println(s"Balance after withdraw ${getBalance1()}")
  withdraw1(15)
  // println(s"Balance after withdraw ${getBalance1()}")

  // println

  deposit1(100)
  // println(s"Balance after deposit ${getBalance1()}")
  deposit1(150)
  // println(s"Balance after deposit ${getBalance1()}")
  // println

  def makeTransfer(from: accountSymbol, amount: Int, to: accountSymbol): Unit = {
    def getBalance(account: accountSymbol): Int = {
      account('getBalance).asInstanceOf[() => Int]()
    }

    def showBothAccounts(): Unit = {
      println(s"from: ${getBalance(from)}")
      println(s"to: ${getBalance(to)}")
    }

    println("Before Transfer")
    showBothAccounts()

    from('withdraw).asInstanceOf[Int => Unit](amount)
    to('deposit).asInstanceOf[Int => Unit](amount)
    println

    println("After Transfer")
    showBothAccounts()
    println(s"Amount Transfered: ${amount}")

  }

  val bankAccount1 /*: accountSymbol*/ = BankAccount(initialBalance = 50)
  val bankAccount2 /*: accountSymbol*/ = BankAccount(initialBalance = 10)

  makeTransfer(bankAccount1, 1, bankAccount2)

  println("-" * 50)
}
