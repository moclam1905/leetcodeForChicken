fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty())
        return true

    var indexS = 0

    for (c in t) {
        if (s[indexS] == c) {
            indexS++
        }
        if (indexS == s.length) return true
    }

    return false
}