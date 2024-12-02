import kotlin.math.max
import kotlin.math.min

fun mergeAlternatelyOld(word1: String, word2: String): String {
    val lWord1 = word1.length
    val lWord2 = word2.length

    val finalWord = StringBuilder()
    for (i in 0..max(lWord1, lWord2)) {
        finalWord.append((word1.getOrNull(i) ?: "")).append((word2.getOrNull(i) ?: ""))
    }

    return finalWord.toString()
}

fun mergeAlternately(word1: String, word2: String): String {
    val lWord1 = word1.length
    val lWord2 = word2.length
    val minL = min(lWord1, lWord2)

    val finalWord = StringBuilder(lWord1 + lWord2)

    for (i in 0..<minL) {
        finalWord.append(word1[i])
        finalWord.append(word2[i])
    }

    if (lWord1 > lWord2) {
        finalWord.append(word1.substring(minL))
    } else if (lWord1 < lWord2) {
        finalWord.append(word2.substring(minL))
    }

    return finalWord.toString()
}


