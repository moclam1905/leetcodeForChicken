package arrayAndString

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var min = Int.MAX_VALUE

    for (p in prices) {
        if (p < min) {
            min = p
        } else {
            val localProfit = p - min
            if (localProfit > profit) {
                profit = localProfit
            }
        }
    }

    return profit
}