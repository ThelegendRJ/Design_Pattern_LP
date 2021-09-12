//package liskovSubstitution
//
//class PremiumCoffeeMachine extends CoffeeMachine {
//  val coffee = "Beans"
//
//  def serveCoffee(coffee:String): String = {
//    "Here is your premium coffee made from "+coffee
//  }
//
//  def brewFilterCoffee(serving: String => String): String ={
//    println("coffee is in " +coffee+" form")
//    println("Grinding beans")
//    println("Brewing... Filtering...")
//    serving(coffee)
//  }
//}
//
//
