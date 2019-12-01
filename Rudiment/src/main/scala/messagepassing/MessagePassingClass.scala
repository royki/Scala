object MessagePassingClass extends App {
  println("-" * 50)

  // `type` alias
  type accountSymbol = Symbol => Any

  // BankAccount returns sometime Int => Unit or sometime () => Int, To handle this situation, use `Symbole` as `Symnot => Any`
  // def BankAccount(initialBalance: Int): accountSymbol /* Symbol => Any */ /*(Int => Unit /*Int*/ )*/ = {
  class BankAccount(initialBalance: Int) {
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
    // `deposit` & `withdraw` functions return Unit. But `getBalance` returns Int. To solve this, we introduce the type `Any` in return type of `bankAccount`

    val dispatch: accountSymbol /*(Int => Unit /*Int*/ )*/ = operation =>
      if (operation == 'withdraw)
        withdraw
      else if (operation == 'deposit)
        deposit
      else if (operation == 'getBalance)
        getBalance
      else
        sys.error(s"Unknow operation: $operation")

    // dispatch
  }

  val account1 = new BankAccount(initialBalance = 100)
  val withdraw1 = account1.dispatch('deposit).asInstanceOf[Int => Unit]
  val deposit1 = account1.dispatch('deposit).asInstanceOf[Int => Unit]
  val getBalance1 = account1.dispatch('getBalance).asInstanceOf[() => Int]

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

  def makeTransfer(from: BankAccount, amount: Int, to: BankAccount): Unit = {
    def getBalance(account: BankAccount): Int = {
      account.dispatch('getBalance).asInstanceOf[() => Int]()
    }

    def showBothAccounts(): Unit = {
      println(s"from: ${getBalance(from)}")
      println(s"to: ${getBalance(to)}")
    }

    println("Before Transfer")
    showBothAccounts()

    from.dispatch('withdraw).asInstanceOf[Int => Unit](amount)
    to.dispatch('deposit).asInstanceOf[Int => Unit](amount)
    println

    println("After Transfer")
    showBothAccounts()
    println(s"Amount Transfered: ${amount}")

  }

  val bankAccount1 /*: accountSymbol*/ = new BankAccount(initialBalance = 50)
  val bankAccount2 /*: accountSymbol*/ = new BankAccount(initialBalance = 10)

  makeTransfer(bankAccount1, 1, bankAccount2)

  println("-" * 50)
}
