package arrayAndString

fun sumOddLengthSubarrays(arr: IntArray): Int {
    var totalSum = 0
    val n = arr.size
    for (i in 0 until n) {
        for (j in i until n) {
            val length = j - i + 1
            if (length % 2 == 1) {
                for (k in i..j) {
                    totalSum += arr[k]
                }
            }
        }
    }

    return totalSum
}

fun sumOddLengthSubarraysV2(arr: IntArray): Int {
    var totalSum = 0
    val n = arr.size
    for (i in arr.indices) {
        val start = i + 1
        val end = n - i
        val numOfSubArray = ((start * end) + 1) / 2
        totalSum += numOfSubArray * arr[i]
    }

    return totalSum
}

fun main() {
    println(sumOddLengthSubarraysV2(intArrayOf(1, 4, 2, 5, 3)))
}