package myscala.chapterone

import scala.concurrent._
import java.time._
import ExecutionContext.Implicits.global

object WorkSheetOne {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(182); 
  println("Welcome to the Scala worksheet");$skip(21); 

  val a = "Hello ";System.out.println("""a  : String = """ + $show(a ));$skip(48); 
  val sum = 8.*(5).+(2);System.out.println("""sum  : Int = """ + $show(sum ));$skip(21);  // similar to 8 * 5 + 2
  println(8 * 5 + 2);$skip(15); 
  println(sum);$skip(25); 

  val ymax, xmax = 100;System.out.println("""ymax  : Int = """ + $show(ymax ));System.out.println("""xmax  : Int = """ + $show(xmax ));$skip(41); 

  var greeting, message: String = null;System.out.println("""greeting  : String = """ + $show(greeting ));System.out.println("""message  : String = """ + $show(message ));$skip(42); 
  println(ymax, xmax, greeting, message);$skip(40); ;

  println("hello".intersect("world"));$skip(39); 

  println("hello" intersect "world");$skip(22); 

  println(1.to(10));$skip(27); 

  println(a toUpperCase)

  import scala.math._;$skip(36); val res$0 = 

  sqrt(9);System.out.println("""res0: Double = """ + $show(res$0));$skip(14); val res$1 = 

  pow(2, 4);System.out.println("""res1: Double = """ + $show(res$1));$skip(114); 

  def main(args: Array[String]): Unit = {
    println("Welcome to scala chapter 2")
    println(ifTest(2));
  };System.out.println("""main: (args: Array[String])Unit""");$skip(69); 

  def ifTest(x: Integer): Integer = {
    if (x > 0) x else -1
  };System.out.println("""ifTest: (x: Integer)Integer""");$skip(96); val res$2 = 

  Future {
    Thread.sleep(10000)
    println(s"This is the future at ${LocalTime.now}")
  };System.out.println("""res2: scala.concurrent.Future[Unit] = """ + $show(res$2));$skip(56); 

  println(s"This is the present at ${LocalTime.now}")}

}
