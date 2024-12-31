package dynamicProgramming

fun rob(nums: IntArray): Int {
    if (nums.isEmpty())
        return 0
    if (nums.size == 1)
        return nums[0]

    var prev2 = 0
    var prev1 = 0
    for (num in nums) {
        val crr = Math.max(num + prev2, prev1)
        prev2 = prev1
        prev1 = crr
    }

    return prev1
}