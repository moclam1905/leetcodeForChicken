package slidingWindow

//prefix sum
fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    var count = 0
    var rs = 0
    val countMap = mutableMapOf<Int, Int>()
    countMap[0] = 1

    for (n in nums) {
        if (n % 2 != 0) {
            count += 1
        }
        val target = count - k
        if (countMap.containsKey(target)) {
            rs += countMap[target]!!
        }

        countMap[count] = countMap.getOrDefault(count, 0) + 1
    }

    return rs
}

fun main() {
    println(numberOfSubarraysV1(intArrayOf(1, 1, 2, 1, 1), 3))
}


fun numberOfSubarraysV1(nums: IntArray, k: Int): Int {
    val count = IntArray(nums.size + 1)
    count[0] = 1
    var sum = 0
    var rs = 0

    for (n in nums) {
        sum += (n and 1)

        if (sum >= k) {
            rs += count[sum - k]
        }

        count[sum]++

    }

    return rs

}