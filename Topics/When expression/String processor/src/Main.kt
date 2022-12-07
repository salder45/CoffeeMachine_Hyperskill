fun main() {
    val s1: String = readln()
    val op: String = readln()
    val s2: String = readln()
    when (op) {
        "equals" -> {
            if (s1 == s2) {
                println("true")
            } else {
                println("false")
            }
        }
        "plus" -> println("$s1$s2")
        "endsWith" -> {
            if (s1.endsWith(s2)) {
                println("true")
            } else {
                println("false")
            }
        }
        else -> println("Unknown operation")
    }
}