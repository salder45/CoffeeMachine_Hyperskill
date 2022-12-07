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


fun main() {
    var money: Int = 550
    var water: Int = 400
    var milk: Int = 540
    var coffee: Int = 120
    var cups: Int = 9
    printCoffeeMachineStatus(water,milk,coffee,cups,money)
    println("Write action (buy, fill, take)")
    val selectedOption: String = readln()
    when (selectedOption) {
         "buy" -> {
             println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
             val optionCoffee: Int = readln().toInt()
             when (optionCoffee) {
                 1 -> {
                     money = add(money, ESPRESSO_PRICE)
                     water = substract(water, ESPRESSO_WATER_PER_CUP)
                     milk = substract(milk, ESPRESSO_MILK_PER_CUP)
                     coffee = substract(coffee, ESPRESSO_COFFEE_PER_CUP)
                     cups--
                 }
                 2 -> {
                     money = add(money, LATTE_PRICE)
                     water = substract(water, LATTE_WATER_PER_CUP)
                     milk = substract(milk, LATTE_MILK_PER_CUP)
                     coffee = substract(coffee, LATTE_COFFEE_PER_CUP)
                     cups--
                 }
                 3 -> {
                     money = add(money, CAPPUCCINO_PRICE)
                     water = substract(water, CAPPUCCINO_WATER_PER_CUP)
                     milk = substract(milk, CAPPUCCINO_MILK_PER_CUP)
                     coffee = substract(coffee, CAPPUCCINO_COFFEE_PER_CUP)
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
            money = substract(money,money)
        }
    }
    printCoffeeMachineStatus(water,milk,coffee,cups,money)
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

fun printCoffeeMachineStatus(water: Int, milk: Int, coffee: Int, cups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$coffee g of coffee beans")
    println("$cups disposable cups")
    println("$$money of money")
}

fun add(a: Int, b: Int) : Int {
    return a + b
}

fun substract(a: Int, b: Int) :Int {
    return a - b
}

