package chapterten

trait ShortLogger extends ConsoleLogger {
  
  val maxLength = 15
  
  println("Short Logger Name: " + name)
  
  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else s"${msg.substring(0, maxLength)}...")
  }

}