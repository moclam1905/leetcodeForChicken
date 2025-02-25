package binarySearch

fun peakIndexInMountainArray(arr: IntArray): Int {
    val n = arr.size - 1
    var l = 0
    var r = n
    while (l < r) {
        val m = l + (r -l) /2
        if (arr[m] >= arr[m +1]){
            r = m
        } else {
            l = m + 1
        }
    }

    return l
}

fun main() {
    peakIndexInMountainArray(intArrayOf(0,10,5,2))
}