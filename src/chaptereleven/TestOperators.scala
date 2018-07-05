package chaptereleven

object TestOperators {
  
  def main(args: Array[String]): Unit = {
    val fraction = Fraction(2, 5) * Fraction(2, 5) 
    
    println(s"Numerator: ${fraction.n}, Denominator: ${fraction.d}")
    
    val a = Fraction.unapply(fraction)
    
    println(a._1 + "," +  a._2)
  }
  
}