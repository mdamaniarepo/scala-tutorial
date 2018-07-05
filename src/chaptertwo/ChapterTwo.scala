package chaptertwo

object ChapterTwo {

  def main(args: Array[String]): Unit = {
    println("Welcome to scala chapter 2")
    println(ifTest(2));
    println(ifTestWithAny(3))
    println(ifTestWithAny(-3))
  }

  def ifTest(x: Integer): Integer = {
    if (x > 0) x else -1
  }

  def ifTestWithAny(x: Integer): Any = {
    var result =  if (x > 0) { "hello" } else { abs(x) }
    
    result
  }

  def abs(x: Integer): Integer = {
    if (x > 0) {
      x
    } else {
      -x
    }
  }

}