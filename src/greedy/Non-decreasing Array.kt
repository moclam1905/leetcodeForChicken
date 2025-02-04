package greedy

fun checkPossibility(nums: IntArray): Boolean {
    var w = 0
    for (i in 0 until nums.size -1) {
        if (nums[i] > nums[i + 1]) {
            w++
            if (w > 1)
                return false
            if (i > 0 && nums[i + 1] < nums[i - 1]) { // 1 3 3 2
                nums[i + 1] = nums[i] // 1 3 3 3
            } else { //1 4 3 3
                nums[i] = nums[i + 1] // 1 3 3 3
            }
        }
    }
    return true
}

fun main() {
    println(
        checkPossibility(intArrayOf(4,2,1))
    )
}