package hashMapAndSet

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val charCount = IntArray(26)

    for (ch in magazine) {
        charCount[ch - 'a']++
    }

    for (ch in ransomNote) {
        if (charCount[ch - 'a'] > 0) {
            charCount[ch - 'a']--
        } else
            return false
    }
    return true
}