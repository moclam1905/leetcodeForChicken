package heaps

import java.util.*

fun findKthLargest(nums: IntArray, k: Int): Int {
    if(nums.size == 1) return nums[0]
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    for (s in nums) {
        maxHeap.add(s)
    }
    var rs = 0
    for (i in 0..<k) {
        rs = maxHeap.poll()
    }

    return rs
}

// min heap
fun findKthLargestV2(nums: IntArray, k: Int): Int {
    if(nums.size == 1) return nums[0]
    val minHeap = PriorityQueue<Int>()

    for (n in nums) {
        if (minHeap.size < k) {
            minHeap.add(n)
        } else {
            if (n > minHeap.peek()) {
                minHeap.poll()
                minHeap.add(n)
            }
        }
    }

    return minHeap.peek()
}