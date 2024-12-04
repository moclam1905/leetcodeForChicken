package hashMapAndSet

import kotlin.math.max

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty())
        return 0
    val set = nums.toSet()
    var countLongest = 0

    for (item in set) {
        if (!set.contains(item - 1)) {
            var currItem = item
            var currCount = 1

            while (set.contains(currItem + 1)) {
                currItem++
                currCount++
            }

            countLongest = max(countLongest, currCount)
        }
    }

    return countLongest

}