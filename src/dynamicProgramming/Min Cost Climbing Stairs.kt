package dynamicProgramming

fun minCostClimbingStairs(cost: IntArray): Int {
    val n = cost.size
    var prev = 0
    var crr = 0

    for (i in 2..n) {
        val next = Math.min(cost[i-2] + prev, cost[i-1] + crr)
        prev = crr
        crr = next
    }

    return  crr
}