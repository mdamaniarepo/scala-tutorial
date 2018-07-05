package chapterthirteen

import scala.collection.mutable.HashMap
import scala.collection.mutable.LinkedHashSet
import scala.collection.mutable.LinkedList
import scala.collection.mutable.ListBuffer

object ExerciseCollections {

  def main(args: Array[String]): Unit = {
    indexes("mississippi")
    val word = "mississippi"
    val newMap = word.distinct.map( (c: Char) => Map(c -> word.zipWithIndex.filter(_._1 == c).foreach(x => x._2)))
    println("map: " + newMap)
  }

  def indexes(s: String): Unit = {
    val charactersMap = new HashMap[Char, LinkedHashSet[Int]]()
    val charIndexes = s.zipWithIndex.foreach((ci: (Char, Int)) => charactersMap(ci._1) = charactersMap.getOrElse(ci._1, new LinkedHashSet[Int]) + ci._2);
    println(charactersMap)

    val charactersMapImmutable = new scala.collection.immutable.HashMap[Char, List[Int]]()

    val lstBuff = ListBuffer(11, 13, 17, 19)
    println(removeSecondElement(lstBuff))
    println(removeSecondElementWithNewList(lstBuff))

    val words = List("ABC", "ADF", "BDF", "BCE")

    println(words.flatMap((x => Vector(x.toUpperCase, x.toLowerCase))))

    val map = words.groupBy(_.substring(0, 1).toUpperCase())

    println(map)
  }

  def charAndIndexesMap(ci: (Char, Int), coll: scala.collection.mutable.Map[Char, LinkedHashSet[Int]]): Unit = {
    coll(ci._1) = coll.getOrElse(ci._1, new LinkedHashSet[Int]) + ci._2
  }

  def removeSecondElement[N](lstBuff: ListBuffer[N]): ListBuffer[N] = {
    for (i <- lstBuff.indices.reverse; if (i % 2 != 0)) lstBuff.remove(i)
    lstBuff
  }

  def removeSecondElementWithNewList[N](lstBuff: ListBuffer[N]): List[N] = {
    val newList = for (i <- lstBuff.indices.reverse; if (i % 2 != 0)) yield lstBuff(i)
    newList.toList
  }

}