package slidingWindow

fun totalFruitV2(fruits: IntArray): Int {
    val hashMap = mutableMapOf<Int,Int>()
    var max = 0
    var s = 0
    for (e in fruits.indices) {
        hashMap[fruits[e]] = hashMap.getOrDefault(fruits[e], 0) +1
        while (hashMap.size >2){
            hashMap[fruits[s]] = hashMap.getOrDefault(fruits[s], 0) -1
            if (hashMap[fruits[s]] == 0) {
                hashMap.remove(fruits[s])
            }

            s++
        }
        max = Math.max(max, e - s + 1)
    }
    return max
}

fun main() {
    println(totalFruit(intArrayOf(1,2,3,2,2)))
}

fun totalFruit(fruits: IntArray): Int {
    val hashMap = IntArray(100001)
    var max = 0
    var s = 0
    var distinct = 0
    for (e in fruits.indices) {
        if (hashMap[fruits[e]] == 0) distinct++
        hashMap[fruits[e]] ++
        while (distinct >2){
            hashMap[fruits[s]] --
            if (hashMap[fruits[s]] == 0) {
                distinct --
            }
            s++
        }
        max = Math.max(max, e - s + 1)
    }
    return max
}