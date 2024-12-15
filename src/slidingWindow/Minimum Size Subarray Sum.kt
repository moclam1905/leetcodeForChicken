package slidingWindow

import kotlin.math.min

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var l = 0
    var minL = Int.MAX_VALUE
    var sum = 0

    for (r in nums.indices) {
        sum += nums[r]
        while (sum >= target) {
            sum -= nums[l]
            minL = min(minL, r - l + 1)
            l++
        }
    }

    return if (minL == Int.MAX_VALUE) 0 else minL
}