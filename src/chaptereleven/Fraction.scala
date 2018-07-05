package chaptereleven

class Fraction(val n: Int, val d: Int) {

  def *(other: Fraction): Fraction = {

    new Fraction(n * other.n, d * other.d)
  }

}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
  
  def unapply(f: Fraction) : (Int,Int) = {
    if(f.d == 0) (0,0) else (f.n, f.d)
  }
}