package graphs

import java.util.PriorityQueue

fun minCostConnectPoints(points: Array<IntArray>): Int {
    val n = points.size
    if (n == 0)
        return 0

    val visited = BooleanArray(n)
    var count = 0
    var total = 0
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.offer(Pair(0, 0))

    while (queue.isNotEmpty() && count < n) {
        val (point, value) = queue.poll()

        if (visited[point]) continue

        visited[point] = true
        total += value
        count++

        for (i in 0..<n) {
            if (!visited[i]) {
                val crrValue = manhattanDistance(points[point], points[i])
                queue.offer(Pair(i, crrValue))
            }
        }
    }

    return if (count == n) total else -1
}

private fun manhattanDistance(p1: IntArray, p2: IntArray): Int {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])
}