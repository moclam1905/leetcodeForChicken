package graphs

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    if (grid.isEmpty())
        return 0

    val m = grid.size
    val n = grid[0].size
    var maxArea = 0
    for (i in 0..<m) {
        for (j in 0..<n) {
            if (grid[i][j] == 1) {
                maxArea = maxArea.coerceAtLeast(dfsMaxAreaOfIsland(grid, i, j))
            }
        }
    }

    return maxArea
}

fun dfsMaxAreaOfIsland(grid: Array<IntArray>, i: Int, j: Int): Int {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] == 0)
        return 0

    grid[i][j] = 0
    var area = 1

    area += dfsMaxAreaOfIsland(grid, i + 1, j)
    area += dfsMaxAreaOfIsland(grid, i - 1, j)
    area += dfsMaxAreaOfIsland(grid, i, j + 1)
    area += dfsMaxAreaOfIsland(grid, i, j - 1)

    return area

}