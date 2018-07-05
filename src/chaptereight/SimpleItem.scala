package chaptereight

class SimpleItem(val itemPrice: Double, val itemDescription: String) extends Item {
  
  override val price = itemPrice
  
  override val description = itemDescription
  
}