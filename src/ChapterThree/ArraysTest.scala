package ChapterThree

import scala.collection.mutable.ArrayBuffer

object ArraysTest {

  def main(args: Array[String]): Unit = {

    val nums = Array(1, 2, 3, 4, 5, 6, 7, 8)
    println("Loop numbers")
    for (i <- 0 until nums.length) println(nums(i))

    for (i <- nums) println(i)

    println("Loop numbers by 2")
    for (i <- 0 until nums.length by 2) println(nums(i))

    val stringArray = new Array[String](2)

    val stringArrayIntialized = Array("Hello", "Mayank") // no new operator required when initializing array
    for (i <- 0 until stringArrayIntialized.length) println(stringArrayIntialized(i))

    stringArrayIntialized(0) = "Bye"
    for (i <- 0 until stringArrayIntialized.length) println(stringArrayIntialized(i))

    // ArrayBuffers
    val buffers = new ArrayBuffer[Int];
    buffers += 1
    println(buffers)

    buffers += (1, 2, 3, 4, 5, 6)
    println(buffers)

    buffers.trimEnd(2)
    println(buffers)

    buffers.trimStart(2)
    println(buffers)

    println("Yield All")
    val result = forYield(Array(1, 2, 3, 5, 7)); for (i <- result) println(i)

    println("Yield Even")
    val resultEven = forYieldEven(Array(1, 2, 3, 4, 5, 6)); for (i <- resultEven) println(i)

    removeNegativeValuesFromArray(ArrayBuffer(1, -1, 2, -2));
    
  }

  def forYield(nums: Array[Int]): Array[Int] = {
    val result = for (i <- nums) yield 2 * i
    result
  }

  def forYieldEven(nums: Array[Int]): Array[Int] = {
    val result = for (i <- nums; if (i % 2 == 0)) yield 2 * i // if condition is also known as guard
    // this can be alternatively written as val result = for (i <- nums if i % 2 == 0) yield 2 * i
    result
  }

  def removeNegativeValuesFromArray(nums: ArrayBuffer[Int]): Unit = {
    val positiveNums = for (elem <- nums; if (elem > 0)) yield elem
    var numsCopy = ArrayBuffer(1, -1, 2, -2)

    println("Positive Numbers with Yield: " + positiveNums)

    val positionsToRemove = for (i <- nums.indices; if (nums(i) < 0)) yield i
    for (i <- positionsToRemove.reverse) nums.remove(i);
    println("Positive Numbers after remove: " + positionsToRemove + " Data: " + nums)

    val positionsToKeep = for (i <- numsCopy.indices; if (numsCopy(i) > 0)) yield i 
    println("Positions to keep: " + positionsToKeep) // (0,2)

    for (j <- positionsToKeep.indices) { (0,1)
      //println(positionsToKeep(j)) // (0, 2)
      //println(numsCopy(positionsToKeep(j)))
      numsCopy(j) = numsCopy(positionsToKeep(j))
    }

    numsCopy.trimEnd(numsCopy.length - positionsToKeep.length)
    println(numsCopy)
  }

}