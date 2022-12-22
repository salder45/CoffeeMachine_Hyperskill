const val ABCD = "abcdefghijkmnlopqrstuvwxyz"
fun main() {
    val word: String = readln()
    var notUsedLetters: String = ""
    for (letter in ABCD) {
        if (word.contains(letter)) {
            continue
        }
        notUsedLetters += letter

    }
    println(notUsedLetters)
}