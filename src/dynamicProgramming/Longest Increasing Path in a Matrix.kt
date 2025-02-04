package dynamicProgramming

//dfs
fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty()) return 0

    val m = matrix.size
    val n = matrix[0].size
    var rs = 0
    val memo = Array(m) {IntArray(n)}
    for (i in 0 until m) {
        for (j in 0 until  n) {
            rs = Math.max(rs, dfsLongestIncreasingPath(matrix, i, j, memo, m, n))
        }
    }

    return rs

}

fun dfsLongestIncreasingPath(matrix: Array<IntArray>,i: Int, j: Int, memo: Array<IntArray>, m: Int, n: Int): Int {
    if (memo[i][j] != 0) return memo[i][j]

    var maxLen = 1

    for (dir in directions) {
        val x = i + dir[0]
        val y = j + dir[1]

        if (x in 0 until  m && y in 0 until n && matrix[x][y] > matrix[i][j]) {
            maxLen = Math.max(maxLen, 1 + dfsLongestIncreasingPath(matrix, x, y, memo, m, n))
        }
    }

    memo[i][j] = maxLen
    return maxLen

}


private val directions = arrayOf(
    intArrayOf(0,1),
    intArrayOf(0,-1),
    intArrayOf(1,0),
    intArrayOf(-1,0),
)

fun main() {
    longestIncreasingPath(arrayOf(intArrayOf(9,9,4), intArrayOf(6,6,8), intArrayOf(2,1,1)))
}