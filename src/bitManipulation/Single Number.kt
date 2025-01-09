package bitManipulation

fun singleNumber(nums: IntArray): Int {
    var rs = 0
    for (num in nums) {
        rs = rs xor num
    }

    return rs
}