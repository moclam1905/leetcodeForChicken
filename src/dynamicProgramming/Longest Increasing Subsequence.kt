package dynamicProgramming

fun lengthOfLIS(nums: IntArray): Int {
    val n = nums.size
    if (n == 0)
        return 0

    var maxLength = 1
    val dp = IntArray(n) { 1 }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
        maxLength = Math.max(maxLength, dp[i])
    }

    return maxLength
}


//binary search
fun lengthOfLIS1(nums: IntArray): Int {
    val listLIS = mutableListOf<Int>()

    for (num in nums) {
        val pos = nums.binarySearch(num).let { if (it < 0) -(it + 1) else it }
        if (pos >= listLIS.size) {
            listLIS.add(num)
        } else {
            listLIS[pos] = num
        }
    }

    return listLIS.size
}

fun main() {
    lengthOfLIS(intArrayOf(10))
}