package greedy

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    // sort by end time
    intervals.sortBy { it[1] }

    var count = 0
    // value end of first interval
    var lastEnd = intervals[0][1]

    for (i in 1 until intervals.size){
        // if the current interval start before lastEnd => overlap
        if (intervals[i][0] < lastEnd) {
            count++
        } else {
            // update lastEnd to current interval end
            lastEnd = intervals[i][1]
        }
    }

    return count
}

fun main() {
    println(
        eraseOverlapIntervals(
            arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3))
        )
    )
}