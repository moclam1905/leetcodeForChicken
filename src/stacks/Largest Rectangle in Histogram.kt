package stacks

fun largestRectangleArea(heights: IntArray): Int {
    val n = heights.size
    val stack = mutableListOf<Int>()
    var max =0

    // create a tmp column on the last heights for case stack still have items
    for (i in 0 ..n) {
        val crrHeight = if (i == n) 0 else heights[i]
        while (stack.isNotEmpty() && crrHeight < heights[stack.last()]){
            val top = stack.removeLast()
            val width  = if (stack.isEmpty()) i else i - stack.last() - 1
            max = Math.max(max, heights[top] *width)
        }
        stack.add(i)
    }

    return max

}

fun main() {
//    val heights1 = intArrayOf(2, 1, 5, 6, 2, 3)
//    println(largestRectangleArea(heights1)) // Output: 10

    val heights2 = intArrayOf(2, 4)
    println(largestRectangleArea(heights2)) // Output: 4
}