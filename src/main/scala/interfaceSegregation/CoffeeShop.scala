package interfaceSegregation

class CoffeeShop{
  def bill(amount:Int): Unit ={
    println("Your bill is of : "+amount+"/- only.")
  }
  def coffeeServer(coffee:String, amount: Int,maker:(String,Int)=>Unit): Int ={
    println("Here is your Coffee...")
    maker(coffee,amount)
    amount
  }
  def coffeeMaker(coffee:String, price:Int): Unit ={
    println(coffee)
    bill(price)
  }
}



















//==========| Scroll Down to see SOLID OOPs approach |========================







//SOLID Approach
//class CoffeeShop extends CoffeeMaker {
//  override def makeCoffee(): Unit = {
//    println("Making coffee... ")
//  }
//}
//
//class Server extends CoffeeServer{
//  override def serveCoffee(): Unit = {
//    println("Serve coffee")
//  }
//}
//
//class Bill(amount:Int) extends Cashier{
//  override def makeBill(): Int = {
//    println("Making Bill...")
//    var price = amount
//    price
//  }
//}