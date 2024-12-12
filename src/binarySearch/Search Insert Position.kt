package binarySearch

fun searchInsert(nums: IntArray, target: Int): Int {
    val n = nums.size
    var l = 0
    var r = n - 1

    while (l <= r) {
        val m = (l + r) / 2

        if (nums[m] == target)
            return m
        else if (nums[m] < target)
            l = m + 1
        else
            r = m - 1
    }

    return l
}