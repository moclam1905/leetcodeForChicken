package heaps

import java.util.*


fun kClosestV2(points: Array<IntArray>, k: Int): Array<IntArray> {
    val heap = PriorityQueue<IntArray>(compareBy { it[0] * it[0] + it[1] * it[1] }).apply {
        addAll(points)
    }

    val rs = Array(k) { IntArray(2) }
    for (i in 0..<k) {
        rs[i] = heap.poll()
    }


    return rs
}

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val queue = PriorityQueue<IntArray>() { b, a -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]) }
    for (point in points) {
        queue.add(point)
        if (queue.size > k) {
            queue.poll()
        }
    }
    return queue.toTypedArray()
}

