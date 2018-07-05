package chapterten

trait TimestampLogger extends ConsoleLogger {
  
  println("Timestamp Logger Name: " + name)
  
  override def log(msg: String) : Unit = {
    super.log(s"${java.time.Instant.now()} $msg")
  }
  
}