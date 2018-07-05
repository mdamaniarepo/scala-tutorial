package chapterthirteen

import scala.collection.mutable.LinkedHashSet

object SetObject {
  
  def main(args: Array[String]): Unit = {
    val setData = Set(1,2,3,4)
    var newSet = addElementToSet(setData, 1)
    println(s"class: ${newSet.getClass}, data: ${newSet}")
    
    val weekdays = LinkedHashSet("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su")
    println(s"class: ${weekdays.getClass}, data: ${weekdays}")
    
    val greetings = Set("hello", "hi", "ola")
    val greetingsOther = Set("hi", "ola", "bye")
    val setElement = "ola"
    println(s"Set: ${greetings} contains element: ${setElement}: ${contains(greetings, setElement)}")
    println(s"Set: ${greetings} subset of element: ${greetingsOther}: ${subSetOf(greetings, greetingsOther)}")
    
    setOperations(greetings, greetingsOther)
  }
  
  def addElementToSet [N] (coll: Set[N], elem: N) : Set[N] = coll + elem
  
  def contains [N] (coll: Set[N], elem: N) : Boolean = coll contains elem
  
  def subSetOf [N] (coll: Set[N], thatColl: Set[N]) : Boolean = thatColl.subsetOf(coll)
  
  def setOperations[N] (coll: Set[N], thatColl: Set[N]) : Unit = {
    println(s"Union: ${coll union thatColl}")
    println(s"Intersect: ${coll intersect thatColl}")
    println(s"Diff: ${coll diff thatColl}")
    println(s"Diff: ${thatColl diff coll}")
  }
  
}