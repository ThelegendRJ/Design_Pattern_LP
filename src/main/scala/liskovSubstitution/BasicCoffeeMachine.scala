//package liskovSubstitution
//
////extends with trait
//class BasicCoffeeMachine extends CoffeeMachine {
//  val coffee = "Powdered"
//
//  def serveCoffee(coffee:String): String = {
//    "Here is your freshly brewed coffee made from "+coffee+ " coffee"
//  }
//
//  def brewFilterCoffee(serving: String => String): String ={
//    println("coffee is in " +coffee+" form")
//    println("Brewing...")
//    serving(coffee)
//  }
//}
//object Main extends App{
//  val basic = new BasicCoffeeMachine()
//  val premium = new PremiumCoffeeMachine
//  val basicCoffeeCup = basic.brewFilterCoffee(basic.serveCoffee)
//  println(basicCoffeeCup)
//}