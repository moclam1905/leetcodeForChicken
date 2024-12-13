package binarySearch

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var l = 1
    var r = piles.max()
    var rs = r

    while (l < r) {
        val m = l + (r - l) / 2
        val hour = hourCanEat(piles, m)

        if (hour <= h) {
            rs = rs.coerceAtMost(m)
            r = m
        } else {
            l = m + 1
        }
    }

    return rs
}

fun hourCanEat(piles: IntArray, m: Int): Int {
    var h = 0
    for (p in piles) {
        h += (p + m - 1) / m
    }
    return h
}