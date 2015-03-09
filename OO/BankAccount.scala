class BankAccount(name: String, bal: Double) {
/*
	Scala has 3 basic types of visibilty.
	Bydefault it is public
	A def or val or var or any decoration inside a class
	that decoration is public. i.e. Any code has the access
	the members of that class
	** safeguard - in general rule, if we have var inside a class
	it should be declared as private
*/
	
/*  Simple rule of thumbs - 
	1. Any method that needs to be called from the outside is
	going to be public
	2. All vars should generally be private
	3. The arguments that passed into, that can be different type and then 
	do a converstion
*/
	//private var balance = (bal).toInt
	
	// **** Special Method ****
	private var lBalance = (bal).toInt

	// Special Method - property assignments *@#$%
	// In Scala to generate a public var, Scala generate two methods 

	def balance = lBalance
	def balance_= (newBal: Double) {
		//lBalance = newBal.toInt
		 if(newBal > balance) deposit(newBal - balance) 
		 else withDraw(balance - newBal)
	}

	def description: String = name+" $"+balance

	def deposit(amount: Double): Boolean = {
		if(amount >= 0) {
			lBalance += (amount*100).toInt
			true
		} else false
	}

	def withDraw(amount: Double): Boolean = {
		if(amount >= 0 && amount <= balance) {
			lBalance -= (amount*100).toInt
			true
		} else false
	}

	def isEmpty: Boolean = balance==0.0
}

val account = new BankAccount("ROY", 100)
println(account.description)
account.withDraw(0.9)
println(account.description)
account.withDraw(0.1)
if(account.isEmpty) println("Nil") else println("Some")
println(account.description)
//account.balance = -999.0
//println(account.description)
account.balance += 50
println(account.balance)