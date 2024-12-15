package slidingWindow


fun checkInclusion(s1: String, s2: String): Boolean {
    val n1 = s1.length
    val n2 = s2.length

    if (n1 > n2) return false

    val s1C = IntArray(26)
    val s2C = IntArray(26)

    for (i in 0..<n1) {
        s1C[s1[i] - 'a']++
        s2C[s2[i] - 'a']++
    }

    if (s1C.contentEquals(s2C))
        return true

    for (i in n1..<n2) {
        s2C[s2[i] - 'a']++
        s2C[s2[i - n1] - 'a']--

        if (s1C.contentEquals(s2C))
            return true
    }

    return false
}