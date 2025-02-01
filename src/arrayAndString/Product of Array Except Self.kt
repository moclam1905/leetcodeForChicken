package arrayAndString

fun productExceptSelfV2(nums: IntArray): IntArray {
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

fun main() {
    println(
        productExceptSelf(intArrayOf(1,2,3,4))
    )
}

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val suffixMap = IntArray(n)
    suffixMap[0] =1
    for (i in 1 until n){
        suffixMap[i] = suffixMap[i -1] * nums[i -1]
    }

    var productSuffix = 1
    for (i in n -1 downTo 0){
        suffixMap[i] *= productSuffix
        productSuffix *= nums[i]
    }

    return suffixMap
}