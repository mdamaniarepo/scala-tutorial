package ChapterThree

object ArrayOperations {

  def main(args: Array[String]): Unit = {
    println(sum(Array(1, 7, 2, 3)));
    sort(Array(1, 7, 2, 3));
  }

  def sum(nums: Array[Int]): Int = {
    val sum = nums.sum
    sum
  }

  def sort(nums: Array[Int]): Array[Int] = {
    var sortedNums: Array[Int] = nums.sorted // original array will not change
    printArray("Sorted Array Ascending", sortedNums);
    
    sortedNums = nums.sortWith(_ > _)
    printArray("Sorted Array Descending", sortedNums);
    
    sortedNums 
  }
  
  def printArray[B] (message: String, elems: Array[B]): Unit = {
    println(message + elems.mkString("<", " | ", ">"))
  }

}