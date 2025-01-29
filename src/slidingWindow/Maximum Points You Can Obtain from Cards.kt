package slidingWindow

import kotlin.math.max
import kotlin.math.min

fun maxScoreMin(cardPoints: IntArray, k: Int): Int {
    val n = cardPoints.size
    val total = cardPoints.sum()

    val windowSize = n - k
    var windowSum = 0
    var windowMinSum = Int.MAX_VALUE

    for (i in 0 until windowSize) {
        windowSum += cardPoints[i]
    }

    windowMinSum = windowSum

    for (i in windowSize until n){
        windowSum += cardPoints[i] - cardPoints[i - windowSize ]
        windowMinSum = min(windowSum, windowMinSum)
    }

    return total - windowMinSum
}

fun main() {
    println(maxScore(intArrayOf(1,2,3,4,5,6,1),3))
}

fun maxScore(cardPoints: IntArray, k: Int): Int {
    val n = cardPoints.size - 1
    var crrValue = 0
    for (i in 0 until k){
        crrValue += cardPoints[i]
    }
    var rs = crrValue
    for (i in 0 until k){
        crrValue -= cardPoints[k - i -1]
        crrValue += cardPoints[n-i]
        rs = max(rs, crrValue)
    }

    return rs
}