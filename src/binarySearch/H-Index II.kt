package binarySearch

fun hIndex(citations: IntArray): Int {
    val n =citations.size
    var l = 0
    var r = n -1

    while (l<=r) {
        val m = l + (r-l)/2
        if (citations[m] >= n - m) {
            r = m -1
        } else {
            l = m +1
        }
    }

    return n - l
}