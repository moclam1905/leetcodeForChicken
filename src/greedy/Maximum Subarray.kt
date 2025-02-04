package greedy

// Kadane
fun maxSubArray(nums: IntArray): Int {
    var currentMax = nums[0]
    var maxSum = nums[0]
    for (i in 1 until nums.size){
        currentMax = Math.max(currentMax, currentMax + nums[i])
        maxSum = Math.max(maxSum, currentMax)
    }
    return maxSum
}