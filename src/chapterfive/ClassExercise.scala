package chapterfive

import scala.beans.BeanProperty

object ClassExercise {

  def main(args: Array[String]): Unit = {

    val counter = new Counter()
    counter.increment
    println(counter.current)

    val bankAccount = new BankAccount()
    bankAccount.deposit(100)
    bankAccount.withdraw(50)
    println(bankAccount.balance);

    val t1 = new Time(12, 0);
    val t2 = new Time(13, 5);
    println(t1.before(t2));

    val t3 = new Time(11, 5);
    println(t1.beforeOptimized(t3))
    println(t3.beforeOptimized(t1))

  }

  class Counter {

    private var value = Int.MaxValue

    def increment = {
      if (value == Int.MaxValue) {
        value
      } else {
        value += 1
      }
    }

    def current = value

  }

  class BankAccount {
    private var _balance = 0.0

    def deposit(amount: Double): Double = {
      _balance += amount
      _balance
    }

    def withdraw(amount: Double): Double = {
      _balance -= amount
      _balance
    }

    def balance = _balance
  }

  class Time(val hours: Int, val minutes: Int) {
    var isBefore = false

    def before(other: Time): Boolean = {
      if (hours < other.hours) {
        isBefore = true
      } else if (minutes < other.minutes) {
        isBefore = true
      } else {
        isBefore
      }

      isBefore
    }

    def beforeOptimized(other: Time): Boolean = {
      println(timeInMinutes + ":" + other.timeInMinutes)
      timeInMinutes < other.timeInMinutes
    }

    def timeInMinutes = (hours * 60) + minutes - 1
  }

  class Student {
    @BeanProperty var name = null

    @BeanProperty var id: Long = 0
  }

  class Person(var age: Int) { 
    age = if (age < 0) 0 else age
  }
}
