package bitManipulation

fun convertToBase7(num: Int): String {
    if (num == 0) return "0"
    val isNegative = num <0
    var n = Math.abs(num)
    var rs = StringBuilder()

    while (n >0) {
        rs.append(n%7)
        n /= 7
    }

    if (isNegative) rs.append("-")
    return rs.reverse().toString()
}