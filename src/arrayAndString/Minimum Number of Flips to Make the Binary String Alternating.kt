package arrayAndString

//Sliding Window algorithm combined with Comparison with Alternating Patterns to find the minimum number of Flips
fun minFlips(s: String): Int {
    val n = s.length
    val doubleS = s + s

    var flipFirst0 = 0
    var flipFirst1 = 0
    for (i in 0 until n){
        val e0 = if (i %2 ==0) '0' else '1'
        val e1 = if (i %2 !=0) '1' else '0'
        if (doubleS[i] != e0) flipFirst0++
        if (doubleS[i] != e1) flipFirst1++
    }

    var minRs = Math.min(flipFirst0, flipFirst1)

    for (i in n until doubleS.length){
        val out = i - n
        val eOut0 = if (out %2 ==0) '0' else '1'
        val eOut1 = if (out %2 !=0) '1' else '0'
        if (doubleS[out] != eOut0) flipFirst0--
        if (doubleS[out] != eOut1) flipFirst1--

        val enI0 = if (i % 2 == 0) '0' else '1'
        val eIn1 = if (i % 2 != 0) '1' else '0'
        if (doubleS[i] != enI0) flipFirst0++
        if (doubleS[i] != eIn1) flipFirst1++

        minRs = minOf(minRs, flipFirst1, flipFirst0)
    }

    return minRs

}
