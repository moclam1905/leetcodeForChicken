package twoPointers

fun longestMountain(arr: IntArray): Int {
    var i =1
    var max = 0

    while (i< arr.size -1 ) {
        if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
            var l = i -1
            var r = i +1

            while (l >0 && arr[l] > arr[l-1]) l--
            while (r < arr.size -1  && arr[r] > arr[r+1]) r++
            max = Math.max(max, r - l +1)
            i =r
        } else{
            i++
        }
    }
    return max
}

fun main() {
    println(longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5)))
}