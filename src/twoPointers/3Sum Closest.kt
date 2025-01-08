package twoPointers
fun threeSumClosest(nums: IntArray, target: Int): Int {
     nums.sort()

    var rsSum = nums[0] + nums[1] + nums[2]
    for (i in 0 until  nums.size -2) {
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            val crrSum = nums[i] + nums[l] + nums[r]

            if (Math.abs(target - crrSum) < Math.abs(target - rsSum)) {
                rsSum = crrSum
            }

            if (crrSum < target)
                l++
            else
                r--
        }
    }
    return rsSum
}
