package twoPointers

fun maxArea(height: IntArray): Int {
    var maxResult = 0
    var l = 0
    var r = height.size - 1

    while (l < r) {
        maxResult = maxOf(maxResult, (r - l) * minOf(height[l], height[r]))
        if (height[r] >= height[l]) {
            l++
        } else {
            r--
        }
    }

    return maxResult
}
