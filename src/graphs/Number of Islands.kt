package graphs

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty())
        return 0

    val m = grid.size
    val n = grid[0].size
    var c = 0
    for (i in 0..<m) {
        for (j in 0..<n) {
            if (grid[i][j] == '1') {
                c++
                dfsNumIslands(grid, i, j)
            }
        }
    }

    return c
}

fun dfsNumIslands(grid: Array<CharArray>, i: Int, j: Int) {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] == '0')
        return

    grid[i][j] = '0'

    dfsNumIslands(grid, i + 1, j)
    dfsNumIslands(grid, i - 1, j)
    dfsNumIslands(grid, i, j + 1)
    dfsNumIslands(grid, i, j - 1)

}