package chapterfour

import scala.collection.immutable.Map
import scala.collection.immutable.HashMap
import scala.collection.JavaConversions.propertiesAsScalaMap

object MapExercise {

  def main(args: Array[String]): Unit = {
    val gizmosMap = Map("Iphone" -> 700, "Ipad" -> 300, "Ipod" -> 100)
    println(discountedGizmos(gizmosMap));
    println(countRepeatingWords("Hello"));
    println(countRepeatingWordsImmutableMap("Mayank"));
    println(countRepeatingWordsSorted("Mayank"))
    println(countRepeatingWordsTree("Mayank"))
    printSystemProperties
    println(minmax(Array(8, 9, 5,2,9,10)))
    println(lteqgt(Array(8, 9, 5,2,9,10), 5 ))
  }

  def discountedGizmos(gizMap: Map[String, Int]): Map[String, Int] = {
    val discountedMap = for ((k, v) <- gizMap) yield k -> v / 100 * 90
    discountedMap
  }

  def countRepeatingWords(fileContent: String): scala.collection.mutable.Map[String, Int] = {
    val wordCountMap = new scala.collection.mutable.HashMap[String, Int]()
    for (i <- fileContent) {
      wordCountMap(i.toString()) = wordCountMap.getOrElse(i.toString(), 0) + 1
    }
    wordCountMap
  }

  def countRepeatingWordsImmutableMap(fileContent: String): Map[String, Int] = {
    var wordCountMap = new HashMap[String, Int]()
    for (i <- fileContent) {
      wordCountMap = wordCountMap + (i.toString() -> (wordCountMap.getOrElse(i.toString(), 0) + 1))
    }
    wordCountMap
  }

  def countRepeatingWordsSorted(fileContent: String): scala.collection.mutable.SortedMap[String, Int] = {
    val wordCountMap = scala.collection.mutable.SortedMap[String, Int]()
    for (i <- fileContent) {
      wordCountMap(i.toString()) = wordCountMap.getOrElse(i.toString(), 0) + 1
    }
    wordCountMap
  }

  def countRepeatingWordsTree(fileContent: String): scala.collection.mutable.TreeMap[String, Int] = {
    val wordCountMap = scala.collection.mutable.TreeMap[String, Int]()
    for (i <- fileContent) {
      wordCountMap(i.toString()) = wordCountMap.getOrElse(i.toString(), 0) + 1
    }
    wordCountMap
  }

  def printSystemProperties(): Unit = {
    val propertiesMap: scala.collection.mutable.Map[String, String] = propertiesAsScalaMap(System.getProperties())
    val longestKey = (for ((k, v) <- propertiesMap) yield k.length).max
    println("Longest Key: " + longestKey)
    for ((k, v) <- propertiesMap) {
      println(k + " | " + v ) 
    }
  }
  
  def minmax (values: Array[Int]) : (Int, Int) = {
    val min = values.min
    val max = values.max
    (min, max)
  }
  
  
  def lteqgt(values: Array[Int], v: Int) : (Int, Int, Int) = {
    val max = for(i <- values; if (i > v)) yield i
    val min = for(i <- values; if (i == v)) yield i
    val equal = for(i <- values; if (i < v)) yield i
    (min.length, equal.length, max.length)
  }

}