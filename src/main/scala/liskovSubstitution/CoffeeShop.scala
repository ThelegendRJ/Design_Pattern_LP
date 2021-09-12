//Functional programming approach of LSP with same coffee example

package liskovSubstitution

class CoffeeShop {
  def serveCoffee(coffee:String, coffeetype: String => String): String = {
    println("Making your coffee...")
    coffeetype(coffee)
  }
  def basicCoffee(coffee:String): String ={
    println("Made from powered coffee....")
    "Here is your "+coffee+" coffee"
  }
  def premiumCoffee(coffee:String): String ={
    println("Freshly grinded and filtered....")
    "Here is your "+coffee+" coffee"
  }
}

object Main extends App{
  val shop = new CoffeeShop
  val cup = shop.serveCoffee("latte",shop.premiumCoffee)
  println(cup)
  val cup2 = shop.serveCoffee("latte",shop.basicCoffee)
  println(cup2)
}