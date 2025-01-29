package slidingWindow

//prefixSum
fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    var count = 0
    var prefixSum = 0
    val map = mutableMapOf<Int,Int>()
    map[0] = 1
    for(n in nums){
        prefixSum+=n
        val needed = prefixSum - goal
        if (map.containsKey(needed)){
            count += map[needed]!!
        }
        map[prefixSum] = map.getOrDefault(prefixSum, 0) +1
    }
    return count
}

fun main() {
    println(numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2))
}
