const val EMPTY_VALUE = "EMPTY"
const val FULL_VALUE = "FULL"
fun main() {
    val (x1, y1) = readln().split(' ')
    val (x2, y2) = readln().split(' ')
    val (x3, y3) = readln().split(' ')
    val rows = mutableListOf<String>(EMPTY_VALUE, EMPTY_VALUE, EMPTY_VALUE, EMPTY_VALUE, EMPTY_VALUE)
    val columns = mutableListOf<String>(EMPTY_VALUE, EMPTY_VALUE, EMPTY_VALUE, EMPTY_VALUE, EMPTY_VALUE)
    for (indexY in 1..5) {
        if ("$indexY" == y1 || "$indexY" == y2 || "$indexY" == y3 ) {
            columns[indexY - 1] = FULL_VALUE
        }
    }
    for (indexX in 1..5) {
        if ("$indexX" == x1 || "$indexX" == x2 || "$indexX" == x3) {
            rows[indexX - 1] = FULL_VALUE
        }
    }
    printList(rows)
    printList(columns)
}

fun printList(list: MutableList<String>) {
    var printableList: String = ""
    for (index in 0 until list.size) {
        if (list[index] != FULL_VALUE) {
            printableList += index + 1
            if (index + 1 == list.size) {
                continue
            }
            printableList += " "
        }
    }
    println(printableList.trim())
}