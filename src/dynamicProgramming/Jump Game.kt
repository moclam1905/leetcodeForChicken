package dynamicProgramming

// Backtracking-based Greedy
fun canJump1(nums: IntArray): Boolean {
    var target = nums.size - 1

    for (i in nums.size - 1 downTo 0) {
        if (i + nums[i] >= target) {
            target = i
        }
    }


    return target == 0
}


//Greedy
fun canJump(nums: IntArray): Boolean {
    var maxReach = 0
    for (i in nums.indices) {
        if (i > maxReach) return false
        maxReach = Math.max(maxReach, i + nums[i])
        if (maxReach >= nums.size - 1)
            return true
    }

    return false
}

//DP
fun canJumpDP(nums: IntArray): Boolean {
    val length = nums.size
    val dp = BooleanArray(length) { false }
    dp[0] = true

    for (i in nums.indices) {
        if (dp[i]) {
            val maxStep = i + nums[i]
            for (j in i + 1..Math.min(maxStep, length - 1)) {
                dp[j] = true
            }
        }
    }

    return dp[length - 1]
}

