package chapterfifteen

import java.io.IOException
import scala.annotation.varargs
import scala.annotation.tailrec

object Annotations {
  def main(args: Array[String]): Unit = {
    println(sum(2, 3))
    println(sum(2, 3, 4, 5, 6))

    //println(sum(1 to 100000)) // this throws stack overfloe error
    println(sum2(1 to 100000, 0))
    allDifferent(1, 2, 3)
    allDifferent("Please", "Get", "Lost")
  }

  /**
   * This is useful if the class is used from java
   * The compiler needs to know that the read method throws IOException else it will
   * refuse to catch it
   */
  @throws(classOf[IOException]) def read(fileName: String): Unit = {
    
  }

  /**
   * the java equivalent would be.
   *
   * public void read(String fileName) throws IOException
   *
   */

  /**
   * String* represents a variable argument
   *
   * the method is equivalent of
   *
   * def process(args: Seq[String])
   *
   * void process(String... args)
   */
  def process(s: String*): Unit = {

  }

  @varargs def sum(n: Int*): Int = {
    n.foldLeft(0)(_ + _)
  }

  /**
   * This method will not compile and give error if @tailrec is used
   *
   */
  def sum(seq: Seq[Int]): BigInt = seq.head + sum(seq.tail)

  @tailrec def sum2(seq: Seq[Int], partialSum: BigInt): BigInt = {
    if (seq.isEmpty) 
      partialSum 
    else 
      sum2(seq.tail, partialSum + seq.head)
  }
  
  def allDifferent[@specialized(Long, Double) T](x: T, y: T, z: T) : Unit = {
    println(s"x: ${x}, y: ${y}, z: ${z}")
  }

}