package twoPointers

import kotlin.math.abs

fun sortedSquares(nums: IntArray): IntArray {
    var i = 0
    var j = nums.size -1
    val list = arrayListOf<Int>()

    while (i<= j){
        if (abs(nums[j]) <= abs(nums[i])){
            list.add(nums[j] * nums[j])
            j--
        } else {
            list.add(nums[i] * nums[i])
            i++
        }
    }

    return list.sorted().toIntArray()
}

fun sortedSquares1(nums: IntArray): IntArray {
    val n = nums.size
    var i = 0
    var j = n - 1
    var k = n - 1
    val list = IntArray(n)

    while (i<= j){
        val lValue = nums[i] * nums[i]
        val rValue = nums[j] * nums[j]

        if (rValue >= lValue) {
            list[k] = rValue
            j--
        } else {
            list[k] = lValue
            i++
        }
        k--
    }

    return list
}

