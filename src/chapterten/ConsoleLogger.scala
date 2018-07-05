package chapterten

trait ConsoleLogger extends Logger {
  
  val name : String 
  
  def log (msg: String) : Unit = {
    println(s"Console log: ${msg}");
  }
}