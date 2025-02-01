package arrayAndString

fun subarraySum(nums: IntArray, k: Int): Int {
    val hashMap = mutableMapOf<Int, Int>()
    var count = 0
    var crSum = 0
    hashMap[0] = 1

    for (i in nums){
        crSum += i

        val target = crSum - k
        if (hashMap.containsKey(target)){
            count += hashMap[target]!!
        }

        hashMap[crSum] = hashMap.getOrDefault(crSum, 0) +1
    }

    return count
}

fun main() {
    println(
        subarraySum(intArrayOf(1,2,3), 3)
    )
}