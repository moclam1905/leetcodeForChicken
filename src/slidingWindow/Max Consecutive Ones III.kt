package slidingWindow

fun longestOnes(nums: IntArray, k: Int): Int {
    var l = 0
    var zeroCount  = 0
    var maxLength = 0
    for(r in nums.indices) {
        if (nums[r] == 0)
            zeroCount ++

        while (zeroCount > k) {
            if (nums[l] == 0)
                zeroCount --
            l++
        }
        maxLength = Math.max(maxLength, r - l + 1)
    }

    return maxLength
}