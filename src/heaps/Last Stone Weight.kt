package heaps

import java.util.*

fun lastStoneWeight(stones: IntArray): Int {
    if(stones.size == 1) return stones[0]

    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

    for (s in stones) {
        maxHeap.offer(s)
    }

    while (maxHeap.size > 1) {
        val largest = maxHeap.poll()
        val nextLargest = maxHeap.poll()
        val diff = largest - nextLargest

        if (diff > 0) {
            maxHeap.offer(diff)
        }
    }

    return maxHeap.peek() ?: 0

}