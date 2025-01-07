package arrayAndString

fun removeDuplicates1(nums: IntArray): Int {
    val n = nums.size
    if (n == 0)
        return  0

    var s = 1
    for (i in 1..<n) {
        if (nums[i] == nums[i-1]) {
            s ++
        }
    }

    return s
}

fun removeDuplicates1ver2(nums: IntArray): Int {
    if (nums.size <= 1)
        return nums.size

    var slow = 1
    for (fast in 1..<nums.size) {
        if(nums[fast] != nums[slow - 1]) {
            nums[slow] = nums[fast]
            slow ++
        }
    }

    return slow
}