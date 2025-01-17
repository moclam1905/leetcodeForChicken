package arrayAndString

fun moveZeroes(nums: IntArray): Unit {
    var non0Index = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[non0Index] = nums[i]
            non0Index ++
        }
    }

    for (j in non0Index until nums.size) {
        nums[j] = 0
    }
}