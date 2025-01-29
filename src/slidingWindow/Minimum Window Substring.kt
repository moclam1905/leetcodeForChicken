package slidingWindow

// T O = n, S O = 1
fun minWindow(s: String, t: String): String {
    if (s.isEmpty() || t.isEmpty()) return ""

    // count the char in target
    val tCount = IntArray(256)
    // count the char in current window
    val windowCount = IntArray(256)
    for (char in t) {
        tCount[char.code]++
    }

    var start = 0
    var minStart = 0
    var minLength = Int.MAX_VALUE
    var matched = 0

    for (end in s.indices) {
        val endChar = s[end].code
        windowCount[endChar]++

        // If this endChar contribute enough with tCount, increase matched
        if (tCount[endChar] > 0 && tCount[endChar] >= windowCount[endChar]) {
            matched++
        }

        while (matched == t.length) {

            // update min length of window
            if (end - start + 1 < minLength) {
                minLength = end - start + 1
                minStart = start
            }

            val startChar = s[start].code
            // decrease the size of window from left
            if (tCount[startChar] > 0 && tCount[startChar] == windowCount[startChar]) {
                matched--
            }
            windowCount[startChar]--
            start++
        }
    }

    return if (minLength == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLength)
}

fun main() {
    println(minWindowV2("ADOBECODEBANC", "ABC"))
}


// Brute force
fun minWindowV2(s: String, t: String): String {
    if (s.length < t.length) return ""

    val targetCount = t.groupingBy { it }.eachCount()
    var rs = ""
    var minL = Int.MAX_VALUE

    for (i in s.indices) {
        for (j in i + t.length - 1 until s.length) {
            val window = s.substring(i, j + 1)
            val windowCount = window.groupingBy { it }.eachCount()
            if (targetCount.all { (key, value) -> windowCount.getOrDefault(key, 0) >= value }) {
                if (j - i + 1 < minL) {
                    minL = j - i + 1
                    rs = window
                }
            }
        }
    }

    return rs
}
