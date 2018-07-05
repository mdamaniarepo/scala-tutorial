package chapterfourteen

case object Nothing extends Amount {
  
  def main(args: Array[String]): Unit = {
    matchAmount(Dollar(1))
    matchAmount(Currency(1, "USD"))
    matchAmount(this)
  }
  
  def matchAmount(amount: Amount) : Unit = {
    amount match {
      case Dollar(v) => println(v);
      case Currency(_, unit) => println(unit);
      case Nothing => println("Nothing");
    }
  }
}