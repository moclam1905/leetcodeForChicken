package arrayAndString

// Kadane
fun maxSubarraySumCircular(nums: IntArray): Int {
    var totalSum = nums[0]
    var crrMaxSum = nums[0]
    var maxSum = nums[0]
    var crrMinSum = nums[0]
    var minSum = nums[0]

    for (i in 1 until nums.size){
        totalSum += nums[i]

        crrMaxSum = Math.max(crrMaxSum + nums[i], nums[i])
        maxSum = Math.max(maxSum, crrMaxSum)

        crrMinSum = Math.min(crrMinSum + nums[i], nums[i])
        minSum = Math.min(minSum, crrMinSum)
    }

    return if (maxSum >0) {
        Math.max(maxSum, totalSum - minSum)
    } else {
        maxSum
    }
}

fun main() {
    println(maxSubarraySumCircular(intArrayOf(1,-6,-7,4)))
}