package chaptereight

class Manager(override val id: String, override val name: String, val department: String) extends {override val allowedContacts = 2} with Employee(id, name) {
  
  override def employeeDepartment(): Unit = {
    println(s"Employee department is ${department}")
  }
  
}