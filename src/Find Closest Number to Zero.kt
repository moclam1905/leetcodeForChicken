import kotlin.math.abs

fun findClosestNumber(nums: IntArray): Int {
    return nums.minWithOrNull(
        compareBy({ abs(it)}, {-it} )
    ) ?: 0
}