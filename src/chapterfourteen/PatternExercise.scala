package chapterfourteen

object PatternExercise {
  
  def main(args: Array[String]): Unit = {
    println(swap((1,2)))
    
    println(swapArray(Array(1,2,3,4)).mkString(","))
    println(swapArray(Array(2,1)).mkString(","))
    println(swapArray(Array(2)).mkString(","))
  }
  
  
  def swap(pair: (Int, Int)) : (Int, Int) = {
    pair match {
      case (a,b) => (b,a)
    }
  }
  
  def swapArray(arr: Array[Int]) : Array[Int] = {
    arr match {
      case Array(o) => arr
      case Array(x, y, rest @ _*) => Array(y, x) ++ rest
    }
  }
}