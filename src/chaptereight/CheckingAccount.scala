package chaptereight

class CheckingAccount(initialBalance: Double, transactionFee: Double) {
  var balance = initialBalance
  
  def deposit(amount: Double): Double = {
    balance += amount
    balance
  }

  def withdraw(amount: Double): Double = {
    balance -= amount
    balance
  }

}