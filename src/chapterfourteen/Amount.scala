package chapterfourteen

abstract class Amount {

}

/**
 * case classes are special classes that are otimized for pattern matching
 * 
 */
case class Dollar(value: Double) extends Amount {

}

case class Currency(value: Double, unit: String) extends Amount