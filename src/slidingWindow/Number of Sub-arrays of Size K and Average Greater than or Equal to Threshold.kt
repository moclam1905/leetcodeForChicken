package slidingWindow

fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
    var windowSum = 0
    var count = 0
    val target = k * threshold

    // sum of first window
    for (i in 0 until k){
        windowSum+= arr[i]
    }

    if (windowSum >= target) count++

    for (i in k until arr.size){
        windowSum+= arr[i] - arr[i-k]
        if (windowSum >= target) count++
    }

    return count
}

fun main() {
    println(
        numOfSubarrays(intArrayOf(11,13,17,23,29,31,7,5,2,3), 3, 5)
    )
}