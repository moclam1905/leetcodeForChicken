package arrayAndString

fun reverseWordsV2(s: String): String {
    return s.trim().split("\\s+".toRegex()).reversed().joinToString(" ")
}

fun main() {
    println(reverseWords("a good   example"))
}

fun reverseWords(s: String): String {
    val wordList = mutableListOf<String>()
    var word = StringBuilder()

    for (c in s) {
        if (c != ' ') {
            word.append(c)
        } else {
            if (word.isNotEmpty()){
                wordList.add(word.toString())
                word = StringBuilder()
            }
        }
    }

    if (word.isNotEmpty()) wordList.add(word.toString())

    return wordList.reversed().joinToString(" ")
}