package binarySearch

fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val n = matrix.size
    var lo = matrix[0][0]
    var hi = matrix[n-1][n-1]

    while (lo < hi) {
        val mid = lo + (hi - lo) /2
        val countLessEqual = countLessEqual(matrix, mid)
        if (countLessEqual < k) {
            lo = mid + 1
        } else {
            hi = mid
        }

    }
    return lo
}


fun countLessEqual(matrix: Array<IntArray>, mid: Int): Int {
    val n = matrix.size
    var count = 0
    var row = n -1
    var col = 0

    // start from bottom left
    // col = 0 is min value in row
    // row = n-1 is max value in row
    while (row >= 0 && col < n) {
        if (matrix[row][col] <= mid) {
            // if matrix[row][col] <= mid, so, all rows from 0 to row always <= mid
            count += row + 1
            col ++
        } else {
            row --
        }
    }
    return count
}

fun main() {
    kthSmallest(arrayOf(intArrayOf(1,  5,  9), intArrayOf(10, 11, 13), intArrayOf(12, 13, 15)), k = 8)
}