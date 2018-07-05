package chaptersix

object InchesToCentimeters extends UnitConversions {
  
  def convert(inches: Double) : Double = {
    val cms = inches * 2.5
    println(inches + " inches equals to " + cms + " centimeters" )
    cms
  }
  
}