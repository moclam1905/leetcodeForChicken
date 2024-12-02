fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val res: ArrayList<Int> = arrayListOf()
    if (matrix.isEmpty())
        return res

    var colStart = 0
    var colEnd = matrix[0].size - 1
    var rowStart = 0
    var rowEnd = matrix.size - 1

    while (colStart <= colEnd && rowStart <= rowEnd) {
        //Travel Right
        for (i in colStart..colEnd) {
            res.add(matrix[rowStart][i])
        }
        rowStart++

        //Travel Down
        for (i in rowStart..rowEnd) {
            res.add(matrix[i][colEnd])
        }
        colEnd--

        //Travel Left
        if (rowStart <= rowEnd) {
            for (i in colEnd downTo colStart) {
                res.add(matrix[rowEnd][i])
            }
        }

        rowEnd--

        //Travel Up
        if (colStart <= colEnd) {
            for (i in rowEnd downTo rowStart) {
                res.add(matrix[i][colStart])
            }
        }

        colStart++

    }

    return res


}
