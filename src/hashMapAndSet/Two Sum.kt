package hashMapAndSet

fun twoSum(nums: IntArray, target: Int): IntArray {
    val y = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val item = nums[i]
        val x = target - item

        if (y.containsKey(x)) {
            return intArrayOf(y[x]!!, i)
        }
        y[item] = i
    }


    return intArrayOf()
}