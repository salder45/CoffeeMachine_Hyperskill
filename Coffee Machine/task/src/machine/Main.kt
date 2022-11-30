package machine

const val WATER_PER_CUP: Int = 200
const val MILK_PER_CUP: Int = 50
const val COFFEE_PER_CUP: Int = 15
fun main() {
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

    /*
    println("Starting to make a coffee")
    println("Grinding coffee beans")
    println("Boiling water")
    println("Mixing boiled water with crushed coffee beans")
    println("Pouring coffee into the cup")
    println("Pouring some milk into the cup")
    println("Coffee is ready!")
    */
}
