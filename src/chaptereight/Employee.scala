package chaptereight

class Employee(val id: String, val name: String) {
  
  val allowedContacts = 1
  
  val contacts: Array[Contacts] = new Array[Contacts](allowedContacts)
  
  def employeeDepartment() : Unit = {
    println("Employee department is Employee")
  }
  
  def getAllowedContacts() : Array[Contacts] = {
    contacts
  }
  
}