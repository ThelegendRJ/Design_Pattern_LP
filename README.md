# Functional Programming
### 1. Liskov Substitution Principle
> If **S** is a subtype of **T**, then objects of type **T** in a program may be replaced with objects of type **S** without altering any of the desirable properties of that program.



* When a child Class cannot perform the same actions as its parent Class, this can cause bugs.
* If you have a Class and create another Class from it, it becomes a parent and the new Class becomes a child. The child Class should be able to do everything the parent Class can do. This process is called Inheritance.
* The child Class should be able to process the same requests and deliver the same result as the parent Class or it could deliver a result that is of the same type.
## In Functional Programming
We create different functions to perform perticular tasks and we use -
* ***Function as a first class citizen***
  - When we treat a function as a value, we consider it a first-class function.
  - In general, a first-class function can be:
    - assigned to a variable
    - passed as an argument to other functions
    - returned as a value from other functions
* ***Higher Order Function***
  * A higher-order function has at least one of the following properties:
    1. Takes one or more functions as parameters
    2. Returns a function as a result
## Let's take A Look How We Can Impl It in Functional Programming
```scala
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
```
### Main method
```scala
object Main extends App{
  val shop = new CoffeeShop
  val cup = shop.serveCoffee("latte",shop.premiumCoffee)
  println(cup)
  val cup2 = shop.serveCoffee("latte",shop.basicCoffee)
  println(cup2)
}
```
### Output
```text
Making your coffee...
Freshly grind and filtered....
Here is your latte coffee

Making your coffee...
Made from powered coffee....
Here is your latte coffee
```
## Experience of functional Programming
In functional programming approach we code less but do more in programming or to execute a task.
### 2. Interface Segregation principle

> Clients should not be forced to depend on methods that they do not use.

We made functions related to coffee shop in CoffeeShop class and functions related to customer in Customer class
### Functional programming appraoch
### 1. CoffeeShop.scala
```scala
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
```
### Customer.scala
```scala
class Customer {
  def drinkCoffee(): Unit = {
    println("drinking coffee")
  }
  def payBill(amount:Int): Unit ={
    println("Bill paid of total: "+amount)
  }
}
```
### Main Method
```scala
object Main extends App{
  val shop = new CoffeeShop
  val rahul = new Customer
  val cup: Int = shop.coffeeServer("cappuccino",100,shop.coffeeMaker)
  rahul.payBill(cup)
}
```

### Output
```text
Here is your Coffee...
cappuccino
Your bill is of : 100/- only.
Bill paid of total: 100
```


### 3. Dependency Inversion
> - High-level modules should not depend on low-level modules. Both should depend on the abstraction.
> - Abstractions should not depend on details. Details should depend on abstractions.

- **High-level Module(or Class):** Class that executes an action with a tool.
- **Low-level Module (or Class):** The tool that is needed to execute the action
- **Abstraction:** Represents an interface that connects the two Classes

## Code implementation of DIP
### Coffeemaker.scala

```scala
trait CoffeeMaker {
  def makeCoffee(): String
}
```
### Cappuccino.scala
This class extends CoffeeMaker trait to make cappuccino coffee
```scala
class Cappuccino extends CoffeeMaker {
  override def makeCoffee(): String = {
    "Makes a Cappuccino"
  }
}
```
### Latte.scala
This class extends CoffeeMaker trait to make latte coffee
```scala
class Latte extends CoffeeMaker {
  override def makeCoffee(): String = {
    "Makes a Latte"
  }
}
```
### CoffeeServer.scala

```scala
class CoffeeServer {
  def serveCoffee(coffee:CoffeeMaker): Unit ={
    val cup = coffee.makeCoffee()
    println(cup)
  }
}
```
### main method
```scala
object Main extends App{
  val serve = new CoffeeServer
  serve.serveCoffee(new Cappuccino)
  serve.serveCoffee(new Latte)
}
```

### Output
```text
Makes a Cappuccino
Makes a Latte
```