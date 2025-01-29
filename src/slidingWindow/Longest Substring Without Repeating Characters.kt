package slidingWindow

fun lengthOfLongestSubstring(s: String): Int {
    val set = HashSet<Char>()
    var maxLength = 0
    var l = 0

    for (r in s.indices) {
        while (set.contains(s[r])) {
            set.remove(s[l])
            l++
        }
        maxLength = Math.max(maxLength, r - l + 1)
        set.add(s[r])
    }

    return maxLength
}

fun main() {
    println(lengthOfLongestSubstring("pwwkew"))
}