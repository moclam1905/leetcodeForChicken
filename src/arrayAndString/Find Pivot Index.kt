package arrayAndString

fun pivotIndexV2(nums: IntArray): Int {
    val totalSum = nums.sum()
    var leftSum = 0
    for (i in nums.indices){
        val rightSum = totalSum -leftSum - nums[i]
        if (rightSum == leftSum) {
            return i
        }
        leftSum += nums[i]
    }

    return -1
}

fun pivotIndex(nums: IntArray): Int {
    val prefixSum = IntArray(nums.size +1)
    for (i in nums.indices){
        prefixSum[i +1] = prefixSum[i] + nums[i]
    }

    val totalSum = prefixSum[nums.size]

    for (i in nums.indices){
        val leftSum = prefixSum[i]
        val rightSum = totalSum - prefixSum[i+1]
        if (leftSum == rightSum)
            return i
    }

    return -1
}