package chapterseventeen

import java.time._
import scala.concurrent._
import ExecutionContext.Implicits.global
import sun.applet.Main

class ScalaFuture {

  Future {
    Thread.sleep(10000)
    println(s"This is the future at ${LocalTime.now}")
  }
  println(s"This is the present at ${LocalTime.now}")

  def executeConcurrentFuture(): Unit = {
    Future { for (i <- 1 to 100) { print("A"); Thread.sleep(10) } }
    Future { for (i <- 1 to 100) { print("B"); Thread.sleep(10) } }
    Thread.sleep(10000)
  }
  
}