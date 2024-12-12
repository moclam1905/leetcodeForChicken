package binarySearch

fun isPerfectSquare(num: Int): Boolean {
    var l = 1
    var r = num
    while (l <= r) {
        val m = l + ((r-l)/2)
        val s = m.toLong() * m.toLong()


        if (num.toLong() == s) {
            return  true
        } else if (num.toLong() > s ) {
            l = m + 1
        } else {
            r = m -1
        }
    }

    return false
}