package chapterthirteen

import scala.collection.immutable.Seq
import scala.collection.GenSeq
import scala.collection.immutable.Map
import scala.collection.GenMap
import scala.collection.immutable.Set

object Collections {

  def main(args: Array[String]): Unit = {
    val coll = Seq(1, 1, 2, 3, 5, 8)

    val list = convertCollectionToList(coll);
    val set = convertCollectionToSet(coll)

    println(s"class: ${list.getClass}, values: ${list}")
    println(s"class: ${set.getClass}, values: ${set}")

    println(s"Convert number to set: ${convertNumbersToSet(1234)}")

    val map = Map((1 -> "A"), (2 -> "B"))

    val lists = List(1, 2)
    println(appendToCollection(lists, 3, "append"))
    println(appendToCollection(lists, 3, "prepend"))

  }

  def convertCollectionToList(c: Seq[Int]): List[Int] = {
    c.toList
  }

  def convertCollectionToSet(c: Seq[Int]): Set[Int] = {
    c.to[Set]
  }

  def convertNumbersToSet(n: Int): Set[Int] = {
    if (n <= 0) {
      convertNumbersToSet(-n)
    } else if (n < 10) {
      Set(n)
    } else {
      convertNumbersToSet(n / 10) + (n % 10)
    }
  }

  def appendToCollection[A](coll: Seq[A], elem: A, caseElement: String): Seq[A] = {
    caseElement match {
      case "prepend" => elem +: coll
      case "append"  => coll :+ elem
    }
  }

  def addToMap[K, V](map: Map[K, V], elem: (K, V)): Map[K, V] = map + (elem._1 -> elem._2)

  def addToSet[K](set: Set[K], elem: K): Set[K] = set + elem

  def removeFromMap[K, V](map: Map[K, V], elem: K): Map[K, V] = map - (elem)
  
  def removeFromSet[K](set: Set[K], elem: K): Set[K] = set + elem
  
  
}