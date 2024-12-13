package binarySearch

fun findMin(nums: IntArray): Int {
    val n = nums.size
    var l = 0
    var r = n - 1

    while (l < r) {
        val m = l + ((r-l)/2)

        if (nums[m] > nums[r]) {
            l = m +1
        } else {
            r = m
        }
    }

    return nums[r]
}