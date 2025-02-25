package binarySearch

fun searchRange(nums: IntArray, target: Int): IntArray {
    val leftIndex = findBound(nums, target, true)
    if (leftIndex == -1) return intArrayOf(-1, -1)
    val rightIndex = findBound(nums, target, false)

    return intArrayOf(leftIndex, rightIndex)
}

fun findBound(nums: IntArray, target: Int, isLeft: Boolean): Int {
    var bound = -1
    var l = 0
    var r = nums.size -1 // don't use the lastIndex extension

    while (l <= r) {
        val mid = l + (r - l) / 2
        when {
            nums[mid] < target -> {
                l = mid + 1
            }

            nums[mid] > target -> {
                r = mid - 1
            }

            else -> {
                bound = mid
                // if found the first index, move left
                if (isLeft) {
                    r = mid - 1
                } else {
                    // if find the last index, move right
                    l = mid + 1
                }
            }
        }
    }

    return bound
}

fun main() {
    searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
}