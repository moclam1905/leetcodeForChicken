package slidingWindow

fun minDeletions(s: String): Int {
    val sCount = IntArray(26)
    val set = mutableSetOf<Int>()
    var deletion = 0
    for (c in s) {
        sCount[c -'a']++
    }

    for (c in sCount){
        var crrC = c
        while (crrC >0 && crrC in set) {
            crrC--
            deletion++
        }

        set.add(crrC)
    }

    return deletion
}

fun main() {
    println(minDeletions("aaabbbcc"))
}