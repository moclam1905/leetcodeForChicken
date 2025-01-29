package slidingWindow

fun characterReplacement(s: String, k: Int): Int {
    val a = IntArray(26) {0}
    var l = 0
    var mF = 0
    var mW = 0
    for (r in s.indices) {
        a[s[r] - 'A']++
        mF = Math.max(mF, a[s[r] - 'A'])

        //var wL = r - l + 1
        while (r - l + 1 - mF > k) {
            a[s[l] - 'A']--
            l++
        }
        //wL = r - l + 1
        mW = Math.max(mW, r - l + 1)
    }

    return mW
}

fun main() {
    characterReplacement("AABABBA", 1)
}