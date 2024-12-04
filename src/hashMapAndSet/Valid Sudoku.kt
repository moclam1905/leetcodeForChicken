package hashMapAndSet

fun isValidSudoku(board: Array<CharArray>): Boolean {
    //matrix 9x9
    // Travel all rows
    for (i in 0..<9) {
        val set = HashSet<Char>()
        for (j in 0..<9) {
            val currValue = board[i][j]
            if (!set.add(currValue) && currValue != '.')
                return false
        }
    }

    // Travel all columns
    for (i in 0..<9) {
        val set = HashSet<Char>()
        for (j in 0..<9) {
            val currValue = board[j][i]
            if (!set.add(currValue) && currValue != '.')
                return false
        }
    }

    //Travel on sub-boxes 3x3
    // get the first item 0,0 0,3 0,6 ...
    val subBoxes = arrayOf(
        intArrayOf(0, 0), intArrayOf(0, 3), intArrayOf(0, 6),
        intArrayOf(3, 0), intArrayOf(3, 3), intArrayOf(3, 6),
        intArrayOf(6, 0), intArrayOf(6, 3), intArrayOf(6, 6)
    )

    for (sb in subBoxes) {
        val set = HashSet<Char>()
        for (i in sb[0]..<sb[0] + 3) {
            for (j in sb[1]..<sb[1] + 3) {
                val currValue = board[i][j]
                if (!set.add(currValue) && currValue != '.')
                    return false
            }
        }
    }

    return true
}