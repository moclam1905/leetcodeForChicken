package slidingWindow
import java.util.ArrayDeque
import kotlin.math.max

fun longestSubarray(nums: IntArray, limit: Int): Int {
    val maxDeque = ArrayDeque<Int>()
    val minDeque = ArrayDeque<Int>()

    var rs = 0
    var l = 0
    for (r in nums.indices){
        while (maxDeque.isNotEmpty() && nums[maxDeque.peekLast()] < nums[r])
            maxDeque.removeLast()
        maxDeque.addLast(r)

        while (minDeque.isNotEmpty() && nums[minDeque.peekLast()] > nums[r])
            minDeque.removeLast()
        minDeque.addLast(r)

        while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit){
            if (maxDeque.peekFirst() == l)
                maxDeque.removeFirst()
            if (minDeque.peekFirst() == l)
                minDeque.removeFirst()

            l++
        }

        rs = max(rs, r -l +1)
    }

    return rs
}

fun main() {
    println(longestSubarray(intArrayOf(10,1,2,4,7,2),5))
}