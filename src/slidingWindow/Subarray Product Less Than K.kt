package slidingWindow

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    if (k <= 1)
        return 0
    var count = 0
    var p = 1
    var l = 0
    for (r in nums.indices){
        p *= nums[r]
        while (p >= k) {
            p /= nums[l]
            l ++
        }

        count += r - l +1
    }
    return count
}

fun main() {
    println(numSubarrayProductLessThanK(intArrayOf(1,1,1), 1))
}