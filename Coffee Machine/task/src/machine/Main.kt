package machine

const val ESPRESSO_WATER_PER_CUP: Int = 250
const val ESPRESSO_MILK_PER_CUP: Int = 0
const val ESPRESSO_COFFEE_PER_CUP: Int = 16
const val ESPRESSO_PRICE: Int = 4
const val LATTE_WATER_PER_CUP: Int = 350
const val LATTE_MILK_PER_CUP: Int = 75
const val LATTE_COFFEE_PER_CUP: Int = 20
const val LATTE_PRICE: Int = 7
const val CAPPUCCINO_WATER_PER_CUP: Int = 200
const val CAPPUCCINO_MILK_PER_CUP: Int = 100
const val CAPPUCCINO_COFFEE_PER_CUP: Int = 12
const val CAPPUCCINO_PRICE: Int = 6
const val INDEX_WATER = 1
const val INDEX_MILK = 2
const val INDEX_COFFEE = 3
const val INDEX_CUP = 4

fun main() {
    val coffeeMachine = CoffeeMachine(400, 540, 120, 9, 550)
    var keepRunning: Boolean = true
    do {
        println("Write action (buy, fill, take, remaining, exit)")
        when (readln()) {
            "buy" -> {
                var type: CoffeeType = CoffeeType.NULL
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                val input: String = readln()
                if (input != "back") {
                    when (input){
                        "1" -> { type = CoffeeType.ESPRESSO
                        }
                        "2" -> { type = CoffeeType.LATTE
                        }
                        "3" -> { type = CoffeeType.CAPPUCCINO
                        }
                    }
                    if (type != CoffeeType.NULL) {
                        coffeeMachine.buy(type.water, type.milk, type.coffee, type.price)
                    }
                }
            }
            "fill" -> {
                println("Write how many ml of water you want to add:")
                val water: Int = readln().toInt()
                println("Write how many ml of milk you want to add:")
                val milk: Int = readln().toInt()
                println("Write how many grams of coffee beans you want to add:")
                val coffee: Int = readln().toInt()
                println("Write how many disposable cups you want to add:")
                val cups: Int = readln().toInt()
                coffeeMachine.add(water, milk, coffee, cups, 0)
            }
            "take" -> {
                println("I gave you $${coffeeMachine.money}")
                coffeeMachine.subtract(0, 0, 0, 0, coffeeMachine.money)
            }
            "remaining" -> coffeeMachine.printCoffeeMachineStatus()
            "exit" -> keepRunning = false
        }
    } while (keepRunning)
}

class CoffeeMachine(var water:Int, var milk: Int, var coffee: Int, var cups: Int, var money: Int) {
    fun printCoffeeMachineStatus() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
    }

    fun add(water:  Int, milk: Int, coffee: Int, cups: Int, money: Int) {
        this.water += water
        this.milk += milk
        this.coffee += coffee
        this.cups += cups
        this.money += money
    }

    fun subtract(water: Int, milk: Int, coffee: Int, cups: Int, money: Int) {
        this.water -= water
        this.milk -= milk
        this.coffee -= coffee
        this.cups -= cups
        this.money -= money
    }
    fun buy(water: Int, milk: Int, coffee: Int, price: Int) {
        if (this.water - water < 0) {
            println("Sorry, not enough water!")
        } else if (this.milk - milk < 0) {
            println("Sorry, not enough milk!")
        } else if (this.coffee - coffee < 0) {
            println("Sorry, not enough coffee beans!")
        } else if (this.cups - 1 < 0) {
            println("Sorry, not enough disposable cups!")
        } else {
            subtract(water, milk, coffee, 1, 0)
            add(0, 0, 0, 0, price)
        }
    }
}

enum class CoffeeType(val water:Int, val milk:Int, val coffee: Int, val price:Int) {
    ESPRESSO(250,0,16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6),
    NULL(0, 0, 0, 0)
}

