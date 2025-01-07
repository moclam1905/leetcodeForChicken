package arrayAndString

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    for (i in 1..<prices.size) {
        if (prices[i] > prices[i - 1]) {
            profit += Math.max(0 , prices[i] - prices[i - 1])
        }
    }

    return profit
}