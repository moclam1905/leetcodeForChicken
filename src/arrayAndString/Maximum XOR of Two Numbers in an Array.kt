package arrayAndString

import kotlin.math.max

fun findMaximumXOR(nums: IntArray): Int {
    var maxXOR = 0
    var mask = 0
    for (i in 31 downTo 0) {
        mask = mask or (1 shl i)
        val prefixes = HashSet<Int>()
        for (num in nums) {
            prefixes.add(num and mask)
        }
        val temp = maxXOR or (1 shl i)
        var found = false
        for (prefix in prefixes) {
            if (prefixes.contains(temp xor prefix)) {
                found = true
                break
            }
        }
        if (found) {
            maxXOR = temp
        }
    }
    return maxXOR
}

fun main() {
//    println(
//        findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8))
//    )

    println(
        findMaximumXORV2(
            intArrayOf(3, 10, 5, 25, 2, 8)
        )
    )
}

fun findMaximumXORV2(nums: IntArray): Int {
    var maxXOR = 0
    val prefixSet = HashSet<Int>()

    var maxNum = nums[0]
    for (num in nums) {
        maxNum = max(maxNum.toDouble(), num.toDouble()).toInt()
    }

    // length of max number in a binary representation
    val L = (Integer.toBinaryString(maxNum)).length

    for (i in L - 1 downTo 0) {
        maxXOR = maxXOR shl 1 // shl i ≈ * (2^i)
        val maxXORForCurrentLength = maxXOR or 1
        // val prefixSet = HashSet<Int>()
        prefixSet.clear()

        for (num in nums) {
            val prefix = num shr i // shr i ≈ / (2^i)
            if (prefixSet.contains(prefix xor maxXORForCurrentLength)) {
                maxXOR = maxXORForCurrentLength
                break
            }
            prefixSet.add(prefix)
        }
    }

    return maxXOR
}



