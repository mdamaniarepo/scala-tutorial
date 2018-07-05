package chapterfourteen

object OptionTest {
  
  
  
  def main(args: Array[String]): Unit = {
    val employeeScores = Map(("Mayank" -> 40), ("Sasmita" -> 100))
    mapGetWithMatch(employeeScores, "Mayank")
    mapGetWithMatch(employeeScores, "Amyra")
  }
  
  def mapGetWithMatch(map: Map[String, Int], key: String) = {
    val scores = map.get(key)
    scores match {
      case Some(value) => println(value)
      case None => println(scores)
    }
  }
  
}