package chaptereight

object Test {

  def main(args: Array[String]): Unit = {
    val employee = new Employee("1", "Employee")
    val manager = new Manager("2", "Manager", "Management")
    val ba = new BusinessAnalyst("3", "BA", "Business Development")

    val employees = Array(employee, manager, ba, null);
    printDepartments(employees)
    printClassTypes(employees)

    val account = new BankAccount(500, 2)
    println(s"inital Balance: ${account.currentBalance}")
    account.deposit(100)
    account.deposit(100)
    account.deposit(100)
    account.withdraw(50)
    account.earnMontlyInterest
    println(s"After montly interest: ${account.currentBalance}");
    account.deposit(100)
    account.deposit(100)
    account.deposit(100)
    account.withdraw(50)
    println(s"After withdraw: ${account.currentBalance}");
  }

  def printDepartments(employees: Array[Employee]): Unit = {
    for (e <- employees; if (e != null)) {
      e.employeeDepartment()
      println(s"Allowed Contacts: ${e.getAllowedContacts().length}");
    }

  }

  def printClassTypes(employees: Array[Employee]): Unit = {
    for (e <- employees) {
      e match {
        case e: BusinessAnalyst => println("BA")
        case e: Manager         => println("Manager")
        case e: Employee        => println("Employee")
        case _                  => println("none")
      }
    }
  }
}