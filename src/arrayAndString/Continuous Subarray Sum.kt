package arrayAndString

fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val hashMap = mutableMapOf<Int, Int>()
    hashMap[0] = -1
    var crrSum = 0
    for (i in nums.indices) {
        crrSum += nums[i]

        crrSum %= k
        if (hashMap.containsKey(crrSum)) {
            if (i - hashMap[crrSum]!! >= 2)
                return true
        } else {
            hashMap[crrSum] = i
        }
    }

    return false
}

fun main() {
    println(
        checkSubarraySum(intArrayOf(23,2,6,4,7), 6)
    )
}