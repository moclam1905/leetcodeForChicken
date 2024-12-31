package dynamicProgramming

fun maxSubArray(nums: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var crrSum = 0

    for (num in nums) {
        crrSum += num

        maxSum = Math.max(crrSum, maxSum)

        if (crrSum <0) {
            crrSum = 0
        }
    }

    return maxSum

}