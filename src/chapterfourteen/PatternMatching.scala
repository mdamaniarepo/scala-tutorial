package chapterfourteen

object PatternMatching {

  def main(args: Array[String]): Unit = {
    println("1+0=-1".toCharArray().foreach(checkPositivesAndNegatives))
    println("1+09-1".toCharArray().foreach(checkPositivesAndNegativesWithGuard))
    identifyType("S")
    identifyType(1)
    identifyType('C')
    
    // copyMethod in case classes
    
    val currency = Currency(100, "USD")
    val newValueCurrency = currency.copy(value = 110)
    val newUnitCurrency = newValueCurrency.copy(unit = "GBP");
    
    println(s"currency: ${currency}, newValue: ${newValueCurrency}, newUnitCurrency: ${newUnitCurrency}")
  }

  // no fall through problem, no break required.
  def checkPositivesAndNegatives(ch: Char): Int = {
    var sign: Int = 0
    ch match {
      case '+' => sign = 1
      case '-' => sign = 2
      case _   => sign = 0
    }
    println(s"Char: ${ch}, returned: ${sign}")
    sign
  }

  def checkPositivesAndNegativesWithGuard(ch: Char): Int = {
    var sign: Int = 0
    ch match {
      case c if (Character.isDigit(c)) => sign = Character.digit(c, 10) // using variable name 'c' in case
      case '+'                         => sign = 1
      case '-'                         => sign = -1
      case _                           => 0
    }
    println(s"Char: ${ch}, returned: ${sign}")
    sign
  }

  /**
   * It is important to pass variable name when you match against a type
   */
  def identifyType[T](obj: T): Unit = {
    obj match {
      case x: Int    => println("Int Type: " + x)
      case s: String => println("String Type: " + s)
      case _         => println("Unidentified type")
    }
  }
  
  
}