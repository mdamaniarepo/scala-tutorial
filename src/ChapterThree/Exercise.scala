package ChapterThree

import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import java.util.TimeZone

object Exercise {

  def main(args: Array[String]): Unit = {
    val randomNums: Array[Int] = randomNumbers(5);
    println(randomNums.mkString(","));

    swapsAdjacentElements(Array(1, 2, 3, 4, 5));
    swapUsingForYeild(Array(1, 2, 3, 4, 5))
    positiveNegative(Array(1, -1, 3, 0, -3, 2, -2))
    removeDuplicates(Array(1, 1, 3, 0, 3, 2, 2))
    someMethod(ArrayBuffer(1, -1, 3, 0, -3, 2, -2))
    removeFirstNegative(ArrayBuffer(-1, 2, -3, 4, 5))
    removeFirstNegative(ArrayBuffer(-1, 2, -3, 4, 5))
    allTimeZonesInAmerica
  }

  def randomNumbers(n: Int): Array[Int] = {
    val nums: Array[Int] = new Array[Int](n)
    for (i <- 0 until n) {
      nums(i) = Random.nextInt(10);
    }

    nums
  }

  def swapsAdjacentElements[B <: Int](elems: Array[B]): Array[B] = {
    for (i <- elems.indices; if i % 2 == 1) {
      val temp = elems(i - 1)
      elems(i - 1) = elems(i)
      elems(i) = temp
    }

    println(elems.mkString("|"))
    elems
  }

  def swapUsingForYeild(elems: Array[Int]): Array[Int] = {
    val positionsToSwap = for (i <- elems.indices; if i % 2 == 1) yield i
    for (j <- positionsToSwap.indices) {
      val temp = elems(positionsToSwap(j) - 1)
      elems(positionsToSwap(j) - 1) = elems(positionsToSwap(j))
      elems(positionsToSwap(j)) = temp
    }

    println(elems.mkString(","))
    elems
  }

  def positiveNegative(elems: Array[Int]): Array[Int] = {
    var b = new ArrayBuffer[Int]()
    for (i <- elems; if (i > 0)) b += i
    for (i <- elems; if (i <= 0)) b += i
    println(b.mkString(","))
    b.toArray
  }

  def removeDuplicates(elems: Array[Int]): Array[Int] = {
    var distinctValues = elems.distinct
    println("removed dups: " + distinctValues.mkString(","))
    distinctValues.toArray
  }

  def someMethod(a: ArrayBuffer[Int]): Unit = {
    var first = true
    var n = a.length
    var i = 0

    while (i < n) {
      if (a(i) >= 0)
        i += 1
      else {
        if (first) {
          first = false
          i += 1
        } else {
          a.remove(i)
          n -= 1
        }
      }
    }

    println(a.mkString(","))
  }

  def removeFirstNegative(a: ArrayBuffer[Int]): Unit = {
    var negativeElementsIndexes = for (i <- a.indices; if (a(i) < 0)) yield i
    negativeElementsIndexes = negativeElementsIndexes.reverse.dropRight(1)
    println(negativeElementsIndexes.mkString(","))
    for (i <- negativeElementsIndexes) a.remove(i)
    println("After removing all negatives but first: " + a.mkString(","))
  }

  def allTimeZonesInAmerica() = {
    val timezones = for(timezone <- TimeZone.getAvailableIDs; if timezone.startsWith("America/")) yield timezone.replace("America/", "")
    println(timezones.sorted.mkString("|"))
    println(timezones.sortWith(_ > _).mkString("|"))
  }
}