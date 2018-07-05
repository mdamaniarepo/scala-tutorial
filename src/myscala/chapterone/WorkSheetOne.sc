package myscala.chapterone

import scala.concurrent._
import java.time._
import ExecutionContext.Implicits.global

object WorkSheetOne {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val a = "Hello "                                //> a  : String = "Hello "
  val sum = 8.*(5).+(2) // similar to 8 * 5 + 2   //> sum  : Int = 42
  println(8 * 5 + 2)                              //> 42
  println(sum)                                    //> 42

  val ymax, xmax = 100                            //> ymax  : Int = 100
                                                  //| xmax  : Int = 100

  var greeting, message: String = null            //> greeting  : String = null
                                                  //| message  : String = null
  println(ymax, xmax, greeting, message);         //> (100,100,null,null)

  println("hello".intersect("world"))             //> lo

  println("hello" intersect "world")              //> lo

  println(1.to(10))                               //> Range 1 to 10

  println(a toUpperCase)                          //> HELLO 

  import scala.math._

  sqrt(9)                                         //> res0: Double = 3.0

  pow(2, 4)                                       //> res1: Double = 16.0

  def main(args: Array[String]): Unit = {
    println("Welcome to scala chapter 2")
    println(ifTest(2));
  }                                               //> main: (args: Array[String])Unit

  def ifTest(x: Integer): Integer = {
    if (x > 0) x else -1
  }                                               //> ifTest: (x: Integer)Integer

  Future {
    Thread.sleep(10000)
    println(s"This is the future at ${LocalTime.now}")
  }                                               //> res2: scala.concurrent.Future[Unit] = Future(<not completed>)

  println(s"This is the present at ${LocalTime.now}")
                                                  //> This is the present at 16:07:08.972

}