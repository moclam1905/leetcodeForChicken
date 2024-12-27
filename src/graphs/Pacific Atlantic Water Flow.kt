package graphs

import java.util.LinkedList
import java.util.Queue

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    if (heights.isEmpty() || heights[0].isEmpty()) return emptyList()

    val m = heights.size
    val n = heights[0].size

    val rs = mutableListOf<List<Int>>()

    val pacificMatrixVisited = Array(m) { BooleanArray(n) }
    val atlanticMatrixVisited = Array(m) { BooleanArray(n) }

    val pacificQueue: Queue<Pair<Int, Int>> = LinkedList()
    val atlanticQueue: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 0..<m) {
        pacificQueue.offer(Pair(i, 0))
        pacificMatrixVisited[i][0] = true
    }
    for (j in 0..<n) {
        pacificQueue.offer(Pair(0, j))
        pacificMatrixVisited[0][j] = true
    }


    for (i in 0..<m) {
        atlanticQueue.offer(Pair(i, n - 1))
        atlanticMatrixVisited[i][n - 1] = true
    }
    for (j in 0..<n) {
        atlanticQueue.offer(Pair(m - 1, j))
        atlanticMatrixVisited[m - 1][j] = true
    }

    bfsQueuePacificAtlantic(heights, pacificMatrixVisited, pacificQueue)
    bfsQueuePacificAtlantic(heights, atlanticMatrixVisited, atlanticQueue)

    for (i in 0..<m) {
        for (j in 0..<n) {
            if (pacificMatrixVisited[i][j] && atlanticMatrixVisited[i][j]) {
                rs.add(listOf(i, j))
            }
        }
    }

    return rs

}

fun bfsQueuePacificAtlantic(heights: Array<IntArray>, visited: Array<BooleanArray>, queue: Queue<Pair<Int, Int>>) {
    val directions = listOf(
        Pair(0, 1),
        Pair(0, -1),
        Pair(1, 0),
        Pair(-1, 0)
    )

    while (queue.isNotEmpty()) {
        val (i, j) = queue.poll()

        for (dir in directions) {
            val newI = i + dir.first
            val newJ = j + dir.second

            if (newI in heights.indices && newJ in heights[0].indices &&
                !visited[newI][newJ] && heights[newI][newJ] >= heights[i][j]
            ) {
                visited[newI][newJ] = true
                queue.offer(Pair(newI, newJ))
            }
        }
    }
}