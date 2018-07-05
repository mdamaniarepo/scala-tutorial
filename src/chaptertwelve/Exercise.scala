package chaptertwelve

import scala.collection.mutable.ArrayBuffer
import scala.collection.GenSeq

object Exercise {
  
  def main(args: Array[String]): Unit = {
    println(values(x => x * x, -5, 5).mkString("|"))
    
    println(Array(1,5,3,2,8,0,7, 20).reduceLeft(greaterThan(_, _)))
    
    println(factorial(6))
    println(factorialFoldLeft(5))
    println(factorialFoldLeft(0))
    
    println(largest(x => 10 * x - x * x, 1 to 10))
    println(largestIndex(x => 10 * x - x * x, 1 to 10))
    
    val pairs = (1 to 10) zip (11 to 20)
    println(pairs)
    println(pairs.map(adjustToPair(_ * _)))
    
    println(adjustToPair(_ * _)(6,7))
    
    val stringArray = Array("Hello", "World")
    val intArray = Array(5, 5)
    
    println(stringArray.corresponds(intArray)(compareLength(_, _)))
    
    println(correspondsWithoutCurrying(stringArray, intArray, compareLength(_, _)))
  }
  
  def values(f: (Int) => Int, low: Int, high: Int) : Array[(Int, Int)] = {
    var computedValues = for(i <- low to high) yield (i, f(i))
    computedValues.toArray
  }
    
  def greaterThan(x: Int, y: Int) : Int = if(x > y) x else y

  def factorial(i: Int): Int = (1 to i).reduceLeft(_ * _)
  
  def factorialFoldLeft(i: Int): Int = (1 to i).foldLeft(1)(_ * _)
  
  def largest(f: (Int) => Int, inputs: Seq[Int]) = inputs.map(f).max
  
  def largestIndex(f: (Int) => Int, inputs: Seq[Int]) = inputs.map(f).zip(inputs).max._2
  
  def adjustToPair(f: (Int, Int) => Int) (pair: (Int, Int)) = f(pair._1, pair._2)
  
  def compareLength(s: String, i: Int) : Boolean = s.length() == i
  
  def correspondsWithoutCurrying[A, B](thisSeq: GenSeq[A], otherSeq: GenSeq[B], f: (A,B) => Boolean) : Boolean = {
    val i = thisSeq.iterator
    val j = otherSeq.iterator
    while (i.hasNext && j.hasNext)
      if (!f(i.next(), j.next()))
        return false

    !i.hasNext && !j.hasNext
  }
}