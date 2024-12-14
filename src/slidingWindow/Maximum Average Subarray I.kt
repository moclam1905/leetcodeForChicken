package slidingWindow

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = 0.toDouble()

    for (i in 0..<k) {
        sum += nums[i]
    }

    var maxSum = sum

    for (i in k..<nums.size) {
        sum += nums[i] - nums[i - k]
        if (sum > maxSum) maxSum = sum
    }

    return maxSum / k
}