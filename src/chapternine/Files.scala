package chapternine

import scala.io.Source

object Files {

  def main(args: Array[String]): Unit = {
    val fileReader = new FileReader("D:\\Scala\\scala-workspace\\Scala-tutorial\\bin\\test.txt")
    println(fileReader.readFileAsString())
    println(fileReader.readFileLines().mkString("|"))
    fileReader.processEachLine()
    fileReader.peek
  }

  class FileReader(filePath: String) {

    def readFileAsString(): String = {
      val source = Source.fromFile(filePath, "UTF-8")
      val fileContentAsString = source.mkString
      source.close()
      fileContentAsString
    }

    def readFileLines(): Array[String] = {
      val source = Source.fromFile(filePath, "UTF-8")
      val linesArray = source.getLines().toArray
      source.close();
      linesArray
    }

    def processEachLine(): Unit = {
      val linesArray = readFileLines()
      var lineNumber = 0

      for (lines <- linesArray) {
        lineNumber += 1
        println(s"Line Number: ${lineNumber}, Line Content: ${lines}")
      }
    }

    def peek(): Unit = {
      val source = Source.fromFile(filePath, "UTF-8")
      val iter = source.buffered
      while (iter.hasNext) {
        if(iter.head.equals("H")) {
          println(iter.next());
        } else {
          iter.next()
        }
      }
      
      source.close()
    }

  }
}