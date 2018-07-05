package chapterfour

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.immutable.HashMap

object MapOperations {

  def main(args: Array[String]): Unit = {
    var map = new HashMap[Int, String]()
    map += (1 -> "Mayank")
    map += (2 -> "Amy")
    println(map)

    println(findInMap(map, 1)) // value found
    //println(findInMap(map, 3)) // exception thrown
    println(findInMapKeyValidation(map, 3))
    println(findWithGetOrElse(map, 3))

    println(printMap(map))
    
    println(switchMap(map))
    
    println(convertPropertiesToMap)

  }

  def findInMap(kv: Map[Int, String], key: Int): String = {
    kv(key)
  }

  def findInMapKeyValidation(kv: Map[Int, String], key: Int): String = {
    if (kv.contains(key)) findInMap(kv, key) else "KEY NOT FOUND"
  }

  def findWithGetOrElse(kv: Map[Int, String], key: Int): String = {
    kv.getOrElse(key, "KEY NOT FOUND");
  }

  def printMap(kv: Map[Int, String]): Unit = {
    println("Print key, value")
    for ((k, v) <- kv) {
      println("Key: " + k + ", Value: " + v)
    }
    
    println("Print key")
    for(i <- kv.keys) println(i)
    
    println("Print Values")
    for(i <- kv.values) println(i)
  }

  def switchMap(kv: Map[Int, String]): Map[String, Int] = {
    val switchedMap = for ((k, v) <- kv) yield (v,k)
    switchedMap
  }
  
  def convertPropertiesToMap() : scala.collection.mutable.Map[String, String] = {
    val propertiesMap: scala.collection.mutable.Map[String, String] = propertiesAsScalaMap(System.getProperties())
    propertiesMap
  }

}