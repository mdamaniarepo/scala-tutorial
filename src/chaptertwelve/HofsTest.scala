package chaptertwelve

import scala.math._

object HofsTest {

  def main(args: Array[String]): Unit = {
    val num = 10

    val fun = ceil _ //underscore turns method into function

    val f: (Double) => Double = ceil

    println(fun)
    println(f)

    val charAtFunc = (_: String).charAt(_: Int) // (String, Int) => Char

    val fCharAt: (String, Int) => Char = _.charAt(_)

    println(doubleEvaluation(6.66, fun))
    println(doubleEvaluation(7.111, f))

    println(stringEvaluation("Mayank", 2, charAtFunc))
    println(stringEvaluation("Mayank", 3, fCharAt))

    println((x: Double) => x * 3)

    println(valueAtOneQuarter(f))

    val hofFunction: (Double, (Double) => Double) => Double = doubleEvaluation

    val mulFactorBy = mulBy(5)

    println(mulFactorBy(8))

    println(valueAtOneQuarter(x => 3 * x)) // no need of double here

    println(valueAtOneQuarter(3 * _)) // as x occurs only once on RHS, replace it with _, A function that multiplies something by 3

    printTriangle(9, "s")

    println(evenNumbers(10).mkString(","))

    println(factorial(5))

    println("Mary had a little lamb".split(" ").sortWith(_.length < _.length).mkString("|"))

    // currying

    val mul = (x: Int, y: Int) => x * y

    println(mulOneAtATime(6)(7));
    println(addOneAtATime(6)(7));

    executeSomeBlock(() => println("Hello World"))
    executeSomeOtherBlock(println("Bye World"));
    
    var x = 10
    until(x == 0)({x -= 1; println(x)})

  }

  def doubleEvaluation(d: Double, f: (Double) => Double): Double = f(d)

  def stringEvaluation(s: String, i: Int, f: (String, Int) => Char): Char = f(s, i)

  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

  def mulBy(factor: Double): (Double) => Double = (x: Double) => x * factor

  def printTriangle(i: Int, s: String): Unit = (1 to i).map(s * _).foreach(println _)

  def evenNumbers(i: Int): Array[Int] = (1 to i).filter(_ % 2 == 0).toArray

  def factorial(i: Int): Int = (1 to i).reduce(_ * _)

  /*def mulOneAtATime(x: Int) : Int => Int = {
    y: Int => x * y
  }*/

  def mulOneAtATime(x: Int)(y: Int) = x * y

  def addOneAtATime(x: Int)(y: Int) = {
    x + y
  }

  def executeSomeBlock(block: () => Unit): Unit = {
    block()
  }

  def executeSomeOtherBlock(block: => Unit): Unit = {
    block
  }

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }
  
}

