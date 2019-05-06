object MessagePassingWithClass extends App {
  println("-" * 50)

  // Companion object; it can access the private val from the Companion class
  // Companion object doesn't have access the `private[this]` val of Companion class
  object BankAccount {
    def f(b: BankAccount): Unit = {
      // println(b._balance)
    }
  }

  // Introduce `class`
  class BankAccount(private[this] val initialBalance: Int) { // default visibility is private[this]
    self =>

    // rename `private` val with `_balance`, general convention
    private[this] var _balance: Int = initialBalance

    // We are using OO style, so we don't need lambda expression any more, rather we can directly use regular `def`
    def withdraw(amount: Int): Unit = {
      if (this._balance >= amount) {
        this._balance = this._balance - amount
      }
      else {
        sys.error("Insufficient Balance")
      }
    }

    def deposit(amount: Int): Unit = {
      if (amount >= 1) {
        this._balance = self._balance + amount
      }
      else {
        sys.error("Amount should be >= 1")
      }
    }

    // getBalance : takes Unit as parameter and returns Int
    // val getBalance: () => Int = () => this.balance
    def getBalance(): Int = this._balance

    // How to return both withdraw and deposit function. To do that, we introduce `Symbol`
    /* // We don't need `dispatch` anymore as we are using the `class` signature.
    val dispatch: Symbol => Any = operation =>
      if (operation == 'withdraw)
        withdraw
      else if (operation == 'deposit)
        deposit
      else if (operation == 'getBalance)
        getBalance
      else
        sys.error(s"Unknow operation: $operation")

      // dispatch
      */
  }

  val account1 = new BankAccount(initialBalance = 100)
  // val withdraw1 = account1.dispatch('withdraw).asInstanceOf[Int => Unit]
  // val deposit1 = account1.dispatch('deposit).asInstanceOf[Int => Unit]
  // val getBalance1 = account1.dispatch('getBalance).asInstanceOf[() => Int]

  // val withdraw1 = account1.withdraw(_)
  // val deposit1 = account1.deposit(_)
  // val getBalance1 = account1.getBalance

  println("Initial Balance in the account1", account1)
  println

  // Can be used infix notation
  account1 withdraw 10
  // account1.withdraw(10)
  println(s"Balance after withdraw ${account1.getBalance()}")
  account1.withdraw(15)
  println(s"Balance after withdraw ${account1.getBalance()}")

  println

  account1.deposit(100)
  println(s"Balance after deposit ${account1.getBalance()}")
  account1.deposit(150)
  println(s"Balance after deposit ${account1.getBalance()}")
  println

  // We can't access or break the invarience as we use the `private` keyword
  // account1.balance = 1000
  // println(account1.balance)

  object MultipleBankTrasfer {
    // val MultipleBankTrasfer = new AnyRef {
    def makeTransfer(from: BankAccount, amount: Int, to: BankAccount): Unit = {
      // def getBalance(account: BankAccount): Int = {
      //   // account.dispatch('getBalance).asInstanceOf[() => Int]()
      //   account.getBalance()
      // }

      def showBothAccounts(): Unit = {
        // println(s"from: ${getBalance(from)}")
        // println(s"to: ${getBalance(to)}")

        println(s"from: ${from.getBalance()}")
        println(s"to: ${to.getBalance()}")
      }

      println("Before Transfer")
      showBothAccounts()

      // from.dispatch('withdraw).asInstanceOf[Int => Unit](amount)
      // to.dispatch('deposit).asInstanceOf[Int => Unit](amount)
      from.withdraw(amount)
      to.withdraw(amount)
      println

      println("After Transfer")
      showBothAccounts()
      println(s"Amount Transfered: ${amount}")
    }
  }
  val bankAccount1 /*: BankAccount*/ = new BankAccount(initialBalance = 50)
  val bankAccount2 /*: BankAccount*/ = new BankAccount(initialBalance = 10)

  MultipleBankTrasfer.makeTransfer(bankAccount1, 1, bankAccount2)

  println("-" * 50)
}

