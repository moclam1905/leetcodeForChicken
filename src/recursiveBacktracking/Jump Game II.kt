package recursiveBacktracking

fun jump(nums: IntArray): Int {
    var maxReach = 0
    var crrEnd = 0
    var count = 0

    // until nums.size -1 cause "the minimum number of jumps to reach nums[n - 1]"
    for (i in 0 until nums.size -1) {
        maxReach = Math.max(maxReach, i + nums[i])
        if (i == crrEnd) {
            count++
            crrEnd = maxReach
        }
    }

    return count
}