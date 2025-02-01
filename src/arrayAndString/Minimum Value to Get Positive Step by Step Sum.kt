package arrayAndString

fun minStartValue(nums: IntArray): Int {
    var minSum = 0
    var crrSum = 0
    for (i in nums){
        crrSum += i
        if (minSum > crrSum) {
            minSum = crrSum
        }
    }

    return if (minSum < 0) 1 - minSum else 1
}