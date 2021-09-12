package interfaceSegregation

class Customer {
  def drinkCoffee(): Unit = {
    println("drinking coffee")
  }
  def payBill(amount:Int): Unit ={
    println("Bill paid of total: "+amount)
  }
}

object Main extends App{
  val shop = new CoffeeShop
  val rahul = new Customer
  val cup: Int = shop.coffeeServer("cappuccino",100,shop.coffeeMaker)
  rahul.payBill(cup)
}