package binarySearch

fun searchArr(nums: IntArray, target: Int): Int {
    val index = findRotationIndex(nums)

    if (index == -1 || index == nums.size - 1) {
        return binarySearch(nums, target, 0, nums.size - 1)
    }

    return if (nums[0] <= target) {
        binarySearch(nums, target, 0, index)
    } else {
        binarySearch(nums, target, index + 1, nums.size - 1)
    }

}


private fun binarySearch(nums: IntArray, target: Int, l: Int, r: Int): Int {
    var lLocal = l
    var rLocal = r
    while (lLocal <= rLocal) {
        val m = lLocal + ((rLocal - lLocal) / 2)

        if (nums[m] == target) {
            return m
        } else if (nums[m] < target) {
            lLocal = m + 1
        } else {
            rLocal = m - 1
        }
    }

    return -1
}


fun findRotationIndex(nums: IntArray): Int {

    var left = 0
    var right = nums.size - 1
    while (left <= right) {

        val mid = (left + right) / 2
        if (mid == right) {
            return mid
        }
        if (nums[mid + 1] < nums[mid])
            return mid

        if (nums[left] <= nums[mid]) {
            left = mid + 1
        } else
            right = mid - 1
    }

    return -1
}

fun searchX(nums: IntArray, target: Int, l: Int, r: Int): Int {
    if (l > r)
        return -1

    val m = l + (r - l) / 2
    if (nums[m] == target)
        return m

    return if (nums[l] <= nums[m]) {
        if (nums[l] <= target && target <= nums[m]) {
            searchX(nums, target, l, m - 1)
        } else {
            searchX(nums, target, m + 1, r)
        }
    } else {
        if (nums[m] <= target && target <= nums[r]) {
            searchX(nums, target, m + 1, r)
        } else {
            searchX(nums, target, l, m - 1)
        }
    }
}

fun searchFinal(nums: IntArray, target: Int): Int {
    return searchX(nums, target, 0, nums.size - 1)
}