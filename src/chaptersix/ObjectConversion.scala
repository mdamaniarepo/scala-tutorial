package chaptersix

object ObjectConversion {
  
  def main(args: Array[String]): Unit = {
    
    inchesToCentimeters(3)
    gallonsToLiters(5)
    milesToKilometers(10)
  }
  
  def inchesToCentimeters(inches: Double) : Double = {
    val cms = inches * 2.5
    println(inches + " inches equals to " + cms + " centimeters" )
    cms
  }
  
  def gallonsToLiters(gallons: Double): Double = {
    val litres = gallons * 4.8
    println(gallons + " gallons equals to " + litres + " litres" )
    litres
  }
  
  def milesToKilometers(miles: Double): Double = {
    val kms = miles * 1.6
    println(miles + " miles equals to " + kms + " kms" )
    kms
  }
  
}