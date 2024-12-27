package graphs

import java.util.LinkedList
import java.util.Queue

fun orangesRotting(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var fresh = 0
    var time = 0


    for (i in 0..<m) {
        for (j in 0..<n) {
            if (grid[i][j] == 1)
                fresh += 1
            if (grid[i][j] == 2) {
                queue.offer(Pair(i, j))
            }

        }
    }

    if (fresh == 0) return 0

    val directions = listOf(
        Pair(0, 1),
        Pair(0, -1),
        Pair(1, 0),
        Pair(-1, 0)
    )

    while (queue.isNotEmpty()) {
        val size = queue.size
        var applyThisRound = false
        for (k in 0..<size) {
            val (i, j) = queue.poll()

            for (d in directions) {
                val newI = i + d.first
                val newJ = j + d.second


                if (newI in 0..<m && newJ in 0..<n && grid[newI][newJ] == 1
                ) {
                    fresh -= 1
                    grid[newI][newJ] = 2
                    queue.offer(Pair(newI, newJ))
                    applyThisRound = true
                }
            }
        }
        if (applyThisRound) {
            time++
        }
    }
    return if (fresh == 0) time else -1
}