package arrayAndString

fun removeElement(nums: IntArray, `val`: Int): Int {
    var l = 0
    var r = nums.size

    while (l < r) {
        if (nums[l] == `val`) {
            nums[l] = nums[r- 1]
            r--
        } else {
            l++
        }
    }
    return r
}