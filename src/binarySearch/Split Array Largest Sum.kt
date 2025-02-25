package binarySearch

fun splitArray(nums: IntArray, k: Int): Int {
    // left value is max value in nums
    var left = nums.maxOrNull() ?: 0
    // right value is sum of all value in nums
    var right = nums.sum()
    var rs = 0
    while (left <= right){
        val mid = left + (right - left)/2
        // Check if nums can be split to <= k pieces, each piece <= mid value ?
        // If valid => can decrease ( cause need to minimize of max value for each pieces
        if (canSplit(nums, k, mid)) {
            rs = mid
            right = mid -1
        } else {
            left = mid +1
        }
    }
    return rs
}

fun canSplit(nums: IntArray, k: Int, max: Int): Boolean {
    var pieces = 1 // at least 1 piece
    var crrSum = 0
    for (num in nums){
        if (crrSum + num > max) {
            // start new piece
            pieces ++
            // reset crrSum
            crrSum = num
            if (pieces > k) return false
        } else {
            crrSum += num
        }
    }

    return true
}

fun main() {
    splitArray(intArrayOf(7,2,5,10,8), 2)
}