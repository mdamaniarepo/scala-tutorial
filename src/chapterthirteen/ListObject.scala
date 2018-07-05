package chapterthirteen

object ListObject {

  def main(args: Array[String]): Unit = {
    val emptyList: List[Int] = Nil

    val lists = List(1, 2)
    printListsHeadAndTail(lists)
    
    val newList = addToList(lists, 9);
    
    println(s"Sum of elements in list: ${newList} is ${sum(newList)}")
    
    val oneMoreList = addToList(newList, 10)
    println(s"Sum of elements in list: ${oneMoreList} is ${sum(oneMoreList)}")
    
    println(s"Sum of elements in list: ${oneMoreList} is ${oneMoreList.sum}")
  }

  def printListsHeadAndTail[N](lists: List[N]) =
    println(s"head: ${lists.head}, classType head: ${lists.head.getClass()}, tail: ${lists.tail}, classType head: ${lists.tail.getClass}")

  def addToList[N](lists: List[N], elem: N): List[N] = {
    val newList = elem :: lists
    printListsHeadAndTail(newList)
    newList
  }
  
  def sum(lists: List[Int]) : Int = {
    if(lists == Nil) 0 else lists.head + sum(lists.tail)
  }
  
  def sumItWell(lists: List[Int]) : Int = {
    lists match {
      case Nil => 0
      case head::tail => head + sumItWell(tail)
    }
  }

}