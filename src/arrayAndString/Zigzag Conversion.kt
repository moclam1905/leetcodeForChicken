package arrayAndString

//Greedy + Two-Pointer Direction Control.
fun convert(s: String, numRows: Int): String {
    if (numRows == 1 || s.length <= numRows)
        return s

    var currentRow = 0
    var goDown = false
    val rs = MutableList(numRows) { StringBuilder() }

    for (c in s) {
        rs[currentRow].append(c)
        if (currentRow == 0 || currentRow == numRows - 1) // first row -> go down. last row back to -1 row
        {
            goDown = !goDown
        }

        currentRow += if (goDown) 1 else -1
    }

    return rs.joinToString("") { it.toString() }

}