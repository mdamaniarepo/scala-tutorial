package chapterten

object TestTraits {
  
  def main(args: Array[String]): Unit = {
    val doSomething = new {override val name = "Something1"} with DoSomething with TimestampLogger with ShortLogger {
      //override val name = "something1"
    }
    
    val doSomething1 = new DoSomething with ShortLogger with TimestampLogger {
      lazy val name = "something2"
    }
    
    doSomething.sayHi("Hello Dude.................................")
    
    doSomething1.sayHi("Hello Dude................")
    
    
    
  }
  
  
  abstract class DoSomething extends Logger {
    
     def sayHi(s: String): Unit = {
       info(s)
     }
     
  }
  
}