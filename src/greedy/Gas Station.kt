package greedy

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0
    var crrTank = 0
    var startIdx = 0

    for (i in 0 until gas.size){
        val diff = gas[i] - cost[i]
        total += diff
        crrTank += diff
        if (crrTank < 0) {
            startIdx = i +1
            crrTank = 0
        }
    }

    return if (total >=0) startIdx else -1
}