package slidingWindow

fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    var crrSum = 0L
    var maxValue = 0L
    var l = 0
    val hs = HashSet<Int>()

    for (r in nums.indices) {
        while (hs.contains(nums[r])){
            hs.remove(nums[l])
            crrSum-=nums[l]
            l++
        }

        hs.add(nums[r])
        crrSum += nums[r]

        if (r - l +1 == k){
            maxValue = Math.max(maxValue, crrSum)

            hs.remove(nums[l])
            crrSum-=nums[l]
            l++
        }
    }

    return maxValue
}

fun main() {
    println(maximumSubarraySum(intArrayOf(1,5,4,2,9,9,9), 3))
}