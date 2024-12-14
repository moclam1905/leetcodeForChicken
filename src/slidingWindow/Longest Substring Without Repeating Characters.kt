package slidingWindow

fun lengthOfLongestSubstring(s: String): Int {
    val set = HashSet<Char>()
    var maxLength = 0
    var l = 0

    for (r in s.indices) {
        if (set.contains(s[r])) {
            set.remove(s[r])
            l++
        }
        maxLength = Math.max(maxLength, r - l + 1)
        set.add(s[r])
    }

    return maxLength
}