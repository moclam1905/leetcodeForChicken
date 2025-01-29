package slidingWindow

import kotlin.math.max
import kotlin.math.min

fun minimumDeletions(nums: IntArray): Int {
    val n = nums.size
    val minIdx = nums.indexOf(nums.minOrNull()!!)
    val maxIdx = nums.indexOf(nums.maxOrNull()!!)

    val left = min(maxIdx, minIdx)
    val right = max(maxIdx, minIdx)

    val deletionFromStartToFarthestElement = right +1
    val deletionFromEndToFarthestElement = n - left
    val deletionFromBothEndAndStart =left +1 + n - right

    return minOf(deletionFromBothEndAndStart, deletionFromEndToFarthestElement, deletionFromStartToFarthestElement)
}