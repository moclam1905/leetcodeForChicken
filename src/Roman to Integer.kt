fun romanToInt(s: String): Int {
    val map = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10,
        'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
    )

    var sum = 0
    var prevValue = 0

    for (i in s) {
        val currValue = map.getValue(i)

        if (currValue > prevValue) {
            sum += currValue - prevValue * 2
        } else {
            sum += currValue
        }
        prevValue = currValue
    }

    return sum
}