package dynamicProgramming

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val m = text1.length
    val n = text2.length

    val dp = Array(m) { IntArray(n) { 0 } }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (text1[i] == text2[j]) {
                dp[i][j] = if (i > 0 && j > 0) dp[i - 1][j - 1] + 1 else 1
            } else {
                dp[i][j] = Math.max(if (i > 0) dp[i - 1][j] else 0, if (j > 0) dp[i][j - 1] else 0)
            }
        }
    }

    return dp[m - 1][n - 1]
}

//fun main() {
//    longestCommonSubsequence("gators", "agars")
//}