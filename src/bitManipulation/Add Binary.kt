package bitManipulation

fun addBinary(a: String, b: String): String {
    val rs = StringBuilder()
    var i = a.length -1
    var j = b.length -1
    var carry = 0

    while (i>=0 || j >= 0 || carry > 0) {
        val bitA = if (i>=0) a[i] - '0' else 0
        val bitB = if (j>=0) b[j] - '0' else 0

        val sum = bitA + bitB + carry
        rs.append(sum%2)
        carry = sum /2

        i--
        j--
    }

    return rs.reverse().toString()
}