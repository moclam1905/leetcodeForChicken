package recursiveBacktracking

fun generateParenthesis(n: Int): List<String> {
    val rs: MutableList<String> = arrayListOf()
    backTrackingGenerateParenthesis(0, 0, rs, "", n)

    return rs

}

fun backTrackingGenerateParenthesis(open: Int, close: Int, rs: MutableList<String>, tmp: String, n: Int) {
    // only add open if open < n
    // only add clise if close < open, cause () if add close -> ()) is wrong
    if (close == open && close + open == n * 2) {
        rs.add(tmp)
        return
    }

    if (open < n) {
        backTrackingGenerateParenthesis(open + 1, close, rs, "$tmp(", n)
    }

    if (close < open) {
        backTrackingGenerateParenthesis(open, close + 1, rs, "$tmp)", n)
    }
}