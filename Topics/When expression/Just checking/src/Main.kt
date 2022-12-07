fun main() {
    val input: Int = readln().toInt()
    when {
        input == 2 -> println("Yes!")
        input > 4 -> println("Unknown number")
        else -> println("No!")
    }
}