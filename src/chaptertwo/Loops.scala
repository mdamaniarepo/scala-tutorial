package chaptertwo

object Loops {

  def main(args: Array[String]): Unit = {
    println("Welcome to loops in scala")
    println(factorial(5))
    println(factorialFor(6))
    loopCharacters("Hello")
    advancedLoop(3, 3);
    advancedLoopConditions(3, 3, "equals")
    println(defaultValueFunctions("Mayank"));

    println(defaultValueFunctions("Mayank", "<Hello, ", ">")); // overriding defaults
    println(defaultValueFunctions(left = "<<Hello ", s = "Mayank", right = " >>")); // no sequence in which parameters are defined
    println(defaultValueFunctions("Mayank", right = " >>>", left = "<<<Hello ")); // unamed first then named

    println(sumVariableArgs(1, 2, 3, 4, 5))
    println(sumVariableArgs(1 to 6: _*)) // seq
    println(recursiveSum(1 to 7: _*)) // seq

  }

  def factorial(n: Int): Int = {
    var r = 1
    var x = n
    println("input : " + x)
    while (x > 0) {
      r = x * r
      x -= 1
    }
    r
  }

  def factorialFor(n: Int): Int = {
    var r = 1
    println("input : " + n)
    for (i <- 1 to n) {
      r = r * i
    }
    r
  }

  def loopCharacters(s: String): Unit = {
    for (i <- 0 to s.length() - 1) {
      println(i)
    }

    for (i <- "World") {
      println(i)
    }
  }

  def advancedLoop(loopCount1: Int, loopCount2: Int): Unit = {
    for (i <- 1 to loopCount1; j <- 1 to loopCount2) {
      print(f"${10 * i + j}%3d");
    }
  }

  def advancedLoopConditions(loopCount1: Int, loopCount2: Int, condition: String): Unit = {
    println("\nadvancedLoopConditions");
    for (i <- 1 to loopCount1; j <- 1 to loopCount2; if i != j) {
      println(10 * i + j);
    }
  }

  /**
   * This functions are also called decorator functions
   */
  def defaultValueFunctions(s: String, left: String = "[ Hi ", right: String = " ]"): String = {
    left + s + right
  }

  def sumVariableArgs(n: Int*): Int = {
    var r = 0
    for (i <- n) {
      r = r + i
    }

    r
  }

  def recursiveSum(args: Int*): Int = {

    if (args.length == 0) 0

    else args.head + recursiveSum(args.tail:_*)

  }

}