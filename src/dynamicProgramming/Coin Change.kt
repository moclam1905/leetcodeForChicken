package dynamicProgramming


// dp
fun coinChange(coins: IntArray, amount: Int): Int {
    //coins.sort()
    val dp = IntArray(amount +1) {Int.MAX_VALUE}
    dp[0] = 0

    for (i in 1..amount){
        for (coin in coins) {
            if (i >= coin && dp[i - coin] != Int.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1)
            }

        }
    }

    return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]

}
