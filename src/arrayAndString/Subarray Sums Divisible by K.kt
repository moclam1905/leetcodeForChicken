package arrayAndString

fun subarraysDivByK(nums: IntArray, k: Int): Int {
    //val modCount = mutableMapOf<Int, Int>()
    val modCount = IntArray(k)
    modCount[0] = 1

    var prefixSum = 0
    var count = 0

    for (num in nums) {
        prefixSum += num

        var mod = prefixSum % k
        if (mod <0)
            mod += k

        count += modCount[mod]

        modCount[mod] = modCount[mod] + 1
    }

    return count
}

fun main() {
    println(
        subarraysDivByK(intArrayOf(-1,2,9), 2)
    )
}


