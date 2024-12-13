package binarySearch

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val indexRow = getPotentialRow(matrix, target)
    if (indexRow != -1) {
        return binarySearchRow(indexRow, matrix, target)
    }

    return false
}

fun getPotentialRow(matrix: Array<IntArray>, target: Int): Int {
    var l = 0
    var h = matrix.size - 1

    while (l <= h) {
        val m = l + (h - l) / 2
        if (matrix[m][0] <= target && matrix[m][matrix[0].size - 1] >= target)
            return m
        else if (matrix[m][0] < target) {
            l = m + 1
        } else {
            h = m - 1
        }
    }

    return -1

}

fun binarySearchRow(row: Int, matrix: Array<IntArray>, target: Int): Boolean{
    var l = 0
    var r = matrix[row].size -1
    while (l<=r) {
        val m = l +(r - l)/2
        if (matrix[row][m] == target)
            return true
        else if (matrix[row][m] < target) {
            l = m +1
        } else {
            r = m - 1
        }
    }

    return false
}