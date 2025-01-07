package arrayAndString

fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2)
        return nums.size

    var slow = 2
    for (fast in 2..<nums.size) {
        if(nums[fast] != nums[slow - 2]) {
            nums[slow] = nums[fast]
            slow ++
        }
    }

    return slow
}

