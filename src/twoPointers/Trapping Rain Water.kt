package twoPointers

// O(1)
fun trap(height: IntArray): Int {
    var leftIndex = 0
    var rightIndex = height.size - 1
    var result = 0
    var leftMax = height[leftIndex]
    var rightMax = height[rightIndex]

    while (leftIndex < rightIndex) {
        if (leftMax < rightMax) {
            leftIndex++
            leftMax = maxOf(height[leftIndex], leftMax)
            result += leftMax - height[leftIndex]
        } else {
            rightIndex--
            rightMax = maxOf(height[rightIndex], rightMax)
            result += rightMax - height[rightIndex]
        }
    }

    return result
}

//O(n)
fun trap2(height: IntArray): Int {
    val n = height.size
    val maxLeftArr = IntArray(n) { 0 }
    val maxRightArr = IntArray(n) { 0 }
    var maxLeftValue = 0
    var maxRightValue = 0

    for (i in 0..<n) {
        val j = n - i - 1
        maxLeftArr[i] = maxLeftValue
        maxRightArr[j] = maxRightValue

        maxLeftValue = maxOf(maxLeftValue, height[i])
        maxRightValue = maxOf(maxRightValue, height[j])

    }

    var sum = 0
    for (i in 0..<n) {
        val tmp = minOf(maxLeftArr[i], maxRightArr[i])
        sum += maxOf(0, tmp - height[i])
    }

    return sum
}