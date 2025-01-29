package slidingWindow

fun smallestRangeII(nums: IntArray, k: Int): Int {
    if (nums.isEmpty()) return 0

    nums.sort()

    val n = nums.size
    var rs = nums[n -1] - nums[0]

    for (i in 0 until n -1) {
        val maxCrr = Math.max(nums[i]+k, nums[n-1] - k)
        val minCrr = Math.min(nums[0]+k, nums[i+1] - k)

        rs = Math.min(rs, maxCrr- minCrr)
    }

    return rs

}

fun main() {
    println(
        smallestRangeII(intArrayOf(1,3,6), 3)
    )
}