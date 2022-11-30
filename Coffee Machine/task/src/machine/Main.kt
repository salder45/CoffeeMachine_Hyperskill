package machine

fun main() {
    println("Write how many cups of coffee you will need:")
    val cups: Int = readln().toInt()
    val water: Int = 200
    val milk: Int = 50
    val coffee: Int = 15
    println("For $cups cups of coffee you will need:")
    println("${cups * water} ml of water")
    println("${cups * milk} ml of milk")
    println("${cups * coffee} gr of coffee beans")
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
