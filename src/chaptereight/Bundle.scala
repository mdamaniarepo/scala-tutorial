package chaptereight

import scala.collection.mutable.ArrayBuffer

class Bundle(description: String) {
  
  var items = new ArrayBuffer[SimpleItem]()
  
  def addItem(item: SimpleItem) : ArrayBuffer[SimpleItem] = {
    items += item
    items
  }
  
  def price() : Double = {
    var prices = for(i <- items) yield i.price
    prices.sum
  }
  
  def desscription() : String = description
}