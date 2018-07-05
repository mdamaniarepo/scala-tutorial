package chapterfour

object TupleOperations {
  
  def main(args: Array[String]): Unit = {
    val t = (1, 3.14, "pie")
    println(t._1 + "" + t._2 + "" + t._3)
    
    val(first, second, third) = t
    
    println(first + "|" + second + "|" + third);
    
    val (one, two, _) = t
    println(one + "|" + two);
    
    val s = "Bengaluru India"
    println(s.partition(_.isLower))
    
    val symbols = Array(2, 10, 2)
    val counts = Array(2, 10, 2)
    
    val pairs = symbols.zip(counts)
    println(pairs.mkString("|"))
    
    val pairsProduct = for((k,v) <- pairs) yield k * v
    println(pairsProduct.mkString("|"));
  }
  
}