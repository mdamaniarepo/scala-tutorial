package chaptertwelve

object ControlAbstractions {

  def main(args: Array[String]): Unit = {
    doSomeConnection { () => println("Connect to DB") }
    doSomeOperation(_ + _, 5, 5)
    doSomeConnectionByName(println("Connect to HornetQ"))
  }

  def doSomeConnection(block: () => Unit): Unit = {
    println("Initalizing Connection")
    block()
    println("Connected")
  }

  def doSomeOperation(block: (Int, Int) => Int, num: Int, otherNum: Int): Unit = {
    println("Start Operation")
    println(s"function: ${block}, value: ${block(num, otherNum)}")
    println("End Operation")
  }

  def doSomeConnectionByName(block: => Unit): Unit = {
    println("Initalizing Connection")
    block // This is call by name
    println("Connected")
  }

}