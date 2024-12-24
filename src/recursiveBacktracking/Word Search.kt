package recursiveBacktracking

fun exist(board: Array<CharArray>, word: String): Boolean {
    val m = board.size
    val n = board[0].size

    val visitedMatrix = Array(m) { BooleanArray(n) }

    for (i in 0..<m) {
        for (j in 0..<n) {
            if (dfsExist(board, word, i, j, 0, visitedMatrix))
                return true
        }
    }

    return false
}

fun dfsExist(
    board: Array<CharArray>,
    word: String,
    i: Int,
    j: Int,
    index: Int,
    visitedMatrix: Array<BooleanArray>
): Boolean {
    if (index == word.length)
        return true

    if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || visitedMatrix[i][j] || board[i][j] != word[index])
        return false

    visitedMatrix[i][j] = true

    val rs = dfsExist(board, word, i + 1, j, index + 1, visitedMatrix) ||
            dfsExist(board, word, i - 1, j, index + 1, visitedMatrix) ||
            dfsExist(board, word, i, j + 1, index + 1, visitedMatrix) ||
            dfsExist(board, word, i, j - 1, index + 1, visitedMatrix)

    visitedMatrix[i][j] = false

    return rs
}
