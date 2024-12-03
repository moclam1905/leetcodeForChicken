package arrayAndString

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size

    val resul = IntArray(n) {1}
    var leftValue = 1
    var rightValue = 1

    for (i in nums.indices) {
        resul[i] *= leftValue
        leftValue *= nums[i]

        resul[n-i-1] *= rightValue
        rightValue *= nums[n-i-1]
    }

    return resul
}