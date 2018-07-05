package chaptereight

class BankAccount(initialBalance: Double, transactionFee: Double) extends CheckingAccount(initialBalance, transactionFee) {

  def currentBalance = balance

  var freeTransactions = 0

  override def deposit(amount: Double): Double = {
    applyTransactionFee
    super.deposit(amount)
  }

  override def withdraw(amount: Double): Double = {
    applyTransactionFee
    super.withdraw(amount)
  }
  
  def earnMontlyInterest: Double = {
    freeTransactions = 0
    super.deposit(currentBalance * 0.2)
  }

  def applyTransactionFee: Unit = {
    freeTransactions += 1
    if (freeTransactions > 3) {
      super.withdraw(transactionFee)
    }
  }
}
