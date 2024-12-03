package hashMapAndSet

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length)
        return false
    val mappedS = HashMap<Char,Int>()
    val mappedT = HashMap<Char,Int>()

    for (ch in s) {
        mappedS[ch] = mappedS.getOrDefault(ch, 0) + 1
    }

    for (ch in t) {
        mappedT[ch] = mappedT.getOrDefault(ch, 0) + 1
    }

    return mappedS == mappedT
}