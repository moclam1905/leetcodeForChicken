package dynamicProgramming

import kotlin.math.max

//bottom up
fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
    val n = nums.size
    val m = multipliers.size
    val dp = Array(m + 1) { IntArray(m + 1) }

    for (i in m - 1 downTo 0) {
        for (left in i downTo 0) {
            val multiple = multipliers[i]
            val right = n - 1 - (i - left)

            dp[i][left] = max(
                multiple * nums[left] + dp[i + 1][left + 1],
                multiple * nums[right] + dp[i + 1][left]
            )
        }
    }

    return dp[0][0]

}

fun main() {
    println(maximumScoreV1(intArrayOf(1, 2, 3, 4), intArrayOf(3, 2)))
}
// https://junminlee3.medium.com/how-to-solve-the-maximum-score-from-performing-multiplication-operations-problem-d28ce76dde6e

fun maximumScoreV1(nums: IntArray, multipliers: IntArray): Int {
    val n = nums.size
    val m = multipliers.size
    val dp = Array(m + 1) { IntArray(m + 1) }

    return getScore(dp, nums, multipliers, m, n, 0, 0)

}

private fun getScore(
    dp: Array<IntArray>, nums: IntArray, multipliers: IntArray, m: Int, n: Int, i: Int, left: Int
): Int {
    if (i == m) return 0

    val right = n - 1 - (i - left)
    val multiple = multipliers[i]

    if (dp[i][left] == 0) {
        dp[i][left] = max(
            multiple * nums[left] + getScore(dp, nums, multipliers, m, n, i + 1, left + 1),
            multiple * nums[right] + getScore(dp, nums, multipliers, m, n, i + 1, left)
        )
    }

    return dp[i][left]
}