package recursiveBacktracking

fun letterCombinations(digits: String): List<String> {
    val rs: MutableList<String> = arrayListOf()
    if (digits.isEmpty())
        return rs
    val hashMap = HashMap<Char, String>()

    hashMap['2'] = "abc"
    hashMap['3'] = "def"
    hashMap['4'] = "ghi"
    hashMap['5'] = "jkl"
    hashMap['6'] = "mno"
    hashMap['7'] = "pqrs"
    hashMap['8'] = "tuv"
    hashMap['9'] = "wxyz"


    backTrackingLetterCombinations(digits, StringBuilder(), hashMap, rs, 0)

    return rs

}

fun backTrackingLetterCombinations(
    digits: String, tmp: StringBuilder, hashMap: HashMap<Char, String>, rs: MutableList<String>, index: Int
) {
    if (index == digits.length) {
        rs.add(tmp.toString())
        return
    }

    val charCurr = hashMap[digits[index]]
    if (charCurr != null) {
        for (c in charCurr) {
            tmp.append(c)
            backTrackingLetterCombinations(digits, tmp, hashMap, rs, index + 1)
            tmp.deleteCharAt(tmp.length - 1)
        }


    }
}
