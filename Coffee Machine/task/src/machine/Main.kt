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
    var supplies = mutableListOf<Int>(0, 400, 540, 120, 9)
    var money: Int = 550
    var keepRunning: Boolean = true
    do {
        println("Write action (buy, fill, take, remaining, exit)")
        val selectedOption: String = readln()
        when (selectedOption) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                val input: String = readln()
                if (input != "back") {
                    when (input){
                        "1" -> {
                            money = buy(supplies, ESPRESSO_WATER_PER_CUP, ESPRESSO_MILK_PER_CUP, ESPRESSO_COFFEE_PER_CUP, money, ESPRESSO_PRICE)
                        }
                        "2" -> {
                            money = buy(supplies, LATTE_WATER_PER_CUP, LATTE_MILK_PER_CUP, LATTE_COFFEE_PER_CUP, money, LATTE_PRICE)
                        }
                        "3" -> {
                            money = buy(supplies, CAPPUCCINO_WATER_PER_CUP, CAPPUCCINO_MILK_PER_CUP, CAPPUCCINO_COFFEE_PER_CUP, money, CAPPUCCINO_PRICE)
                        }
                    }
                }
            }
            "fill" -> {
                fill("Write how many ml of water you want to add:", INDEX_WATER, supplies)
                fill("Write how many ml of milk you want to add:", INDEX_MILK, supplies)
                fill("Write how many grams of coffee beans you want to add:", INDEX_COFFEE, supplies)
                fill("Write how many disposable cups you want to add:", INDEX_CUP, supplies)
            }
            "take" -> {
                println("I gave you $$money")
                money = subtract(money,money)
            }
            "remaining" -> printCoffeeMachineStatus(supplies, money)
            "exit" -> keepRunning = false
        }
    } while (keepRunning)
    /*
    printCoffeeMachineStatus(water,milk,coffee,cups,money)


    when (selectedOption) {
         "buy" -> {
             println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
             val optionCoffee: Int = readln().toInt()
             when (optionCoffee) {
                 1 -> {
                     money = add(money, ESPRESSO_PRICE)
                     water = subtract(water, ESPRESSO_WATER_PER_CUP)
                     milk = subtract(milk, ESPRESSO_MILK_PER_CUP)
                     coffee = subtract(coffee, ESPRESSO_COFFEE_PER_CUP)
                     cups--
                 }
                 2 -> {
                     money = add(money, LATTE_PRICE)
                     water = subtract(water, LATTE_WATER_PER_CUP)
                     milk = subtract(milk, LATTE_MILK_PER_CUP)
                     coffee = subtract(coffee, LATTE_COFFEE_PER_CUP)
                     cups--
                 }
                 3 -> {
                     money = add(money, CAPPUCCINO_PRICE)
                     water = subtract(water, CAPPUCCINO_WATER_PER_CUP)
                     milk = subtract(milk, CAPPUCCINO_MILK_PER_CUP)
                     coffee = subtract(coffee, CAPPUCCINO_COFFEE_PER_CUP)
                     cups--
                 }
             }
        }
        "fill" -> {
            println("Write how many ml of water you want to add:")
            val inputWater: Int = readln().toInt()
            water = add(water, inputWater)
            println("Write how many ml of milk you want to add:")
            val inputMilk: Int = readln().toInt()
            milk = add(milk, inputMilk)
            println("How many grams of coffee beans you want to add:")
            val inputCoffee: Int = readln().toInt()
            coffee = add(coffee, inputCoffee)
            println("Write how many disposable cups you want to add:")
            val inputCups: Int = readln().toInt()
            cups = add(cups, inputCups)
        }
        "take" -> {
            println("I gave you $$money")
            money = subtract(money,money)
        }
    }
    printCoffeeMachineStatus(water,milk,coffee,cups,money)
    */
    /*
    println("Write how many ml of water the coffee machine has:")
    val availableWater: Int = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val availableMilk: Int = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val availableCoffee: Int = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val cups: Int = readln().toInt()
    val currentCupsFromWater: Int = availableWater / WATER_PER_CUP
    val currentCupsFromMilk: Int = availableMilk / MILK_PER_CUP
    val currentCupsFromCoffee: Int = availableCoffee / COFFEE_PER_CUP
    var minimumOfCups: Int = 0
    if (currentCupsFromWater <= currentCupsFromMilk && currentCupsFromWater <= currentCupsFromCoffee) {
        minimumOfCups = currentCupsFromWater
    } else if (currentCupsFromMilk <= currentCupsFromWater && currentCupsFromMilk <= currentCupsFromCoffee) {
        minimumOfCups = currentCupsFromMilk
    } else if (currentCupsFromCoffee <= currentCupsFromWater && currentCupsFromCoffee <= currentCupsFromMilk) {
        minimumOfCups = currentCupsFromCoffee
    }

    if(cups == minimumOfCups) {
        println("Yes, I can make that amount of coffee")
    } else if (cups > minimumOfCups) {
        println("No, I can make only $minimumOfCups cups of coffee")
    } else {
        println("Yes, I can make that amount of coffee (and even ${minimumOfCups - cups} more than that)")
    }
    */
}

fun printCoffeeMachineStatus(supplies: MutableList<Int>, money: Int) {
    println("The coffee machine has:")
    println("${supplies[INDEX_WATER]} ml of water")
    println("${supplies[INDEX_MILK]} ml of milk")
    println("${supplies[INDEX_COFFEE]} g of coffee beans")
    println("${supplies[INDEX_CUP]} disposable cups")
    println("$$money of money")
}

fun add(a: Int, b: Int) : Int {
    return a + b
}

fun subtract(a: Int, b: Int) :Int {
    return a - b
}

fun fill(label: String, index: Int, supplies: MutableList<Int>) {
    println(label)
    val supply: Int = readln().toInt()
    supplies[index] = add(supplies[index],supply)
}

fun buy(supplies: MutableList<Int>, water: Int, milk: Int, coffee: Int, money: Int, price: Int): Int {
    var cash: Int = money
    if (supplies[INDEX_WATER] - water < 0){
        println("Sorry, not enough water!")
    } else if (supplies[INDEX_MILK] - milk < 0) {
        println("Sorry, not enough milk!")
    } else if (supplies[INDEX_COFFEE] - coffee < 0) {
        println("Sorry, not enough coffee beans!")
    } else if (supplies[INDEX_CUP] - 1 < 0) {
        println("Sorry, not enough disposable cups!")
    } else {
        println("I have enough resources, making you a coffee!")
        supplies[INDEX_WATER] = subtract(supplies[INDEX_WATER],water)
        supplies[INDEX_MILK] = subtract(supplies[INDEX_MILK],milk)
        supplies[INDEX_COFFEE] = subtract(supplies[INDEX_COFFEE],coffee)
        supplies[INDEX_CUP] = subtract(supplies[INDEX_CUP],1)
        cash+= price
    }
    return cash
}

