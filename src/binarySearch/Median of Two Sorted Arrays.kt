package binarySearch

//O(m+n)
fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
    val totalSize = nums1.size + nums2.size
    val mergedArr = IntArray(totalSize)
    var i = 0
    var j = 0
    var indexOfMergedArr = 0

    while (i < nums1.size && j < nums2.size) {
        if (nums1[i] < nums2[j]) {
            mergedArr[indexOfMergedArr++] = nums1[i++]
        } else {
            mergedArr[indexOfMergedArr++] = nums2[j++]
        }
    }

    while (i < nums1.size) {
        mergedArr[indexOfMergedArr++] = nums1[i++]
    }

    while (j < nums2.size) {
        mergedArr[indexOfMergedArr++] = nums2[j++]
    }

    return if (totalSize % 2 ==0) {
        (mergedArr[totalSize /2 -1] + mergedArr[totalSize/2]) / 2.0
    } else {
        mergedArr[totalSize/2].toDouble()
    }
}

fun main() {
    findMedianSortedArrays(intArrayOf(1, 3, 8), intArrayOf(7,9,10,11))
}

//O(log(min(n, m)))
// Partitioning Solution
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    // make sure nums1 is smaller than nums2
    if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)

    val num1Size = nums1.size
    val num2Size = nums2.size
    val totalSize = num1Size + num2Size

    var left = 0
    var right = nums1.size

    while (left <= right) {
        val indexMid1ToCheck = (left + right) / 2
        // formula : (m + n + 1) / 2 - indexMid1ToCheck
        val indexMid2ToCheck = (totalSize + 1) /2 - indexMid1ToCheck

        // if indexMid1ToCheck == 0, don't have any item in left side, use -infinity
        val maxLeftMid1 = if (indexMid1ToCheck == 0) Int.MIN_VALUE else nums1[indexMid1ToCheck - 1]
        // if indexMid2ToCheck == 0, don't have any item in left side, use -infinity
        val maxLeftMid2 = if (indexMid2ToCheck == 0) Int.MIN_VALUE else nums2[indexMid2ToCheck - 1]

        // if indexMid1ToCheck == num1Size, don't have any item in right side, use +infinity
        val minRightMid1 = if (indexMid1ToCheck == num1Size) Int.MAX_VALUE else  nums1[indexMid1ToCheck]
        // if indexMid2ToCheck == num2Size, don't have any item in right side, use +infinity
        val minRightMid2 = if (indexMid2ToCheck == num2Size) Int.MAX_VALUE else  nums2[indexMid2ToCheck]

        // Partition is valid
        if (maxLeftMid1 <= minRightMid2 && maxLeftMid2 <= minRightMid1) {
            return if (totalSize %2 == 0) {
                (maxOf(maxLeftMid1, maxLeftMid2) + minOf(minRightMid1, minRightMid2)) / 2.0
            } else {
                maxOf(maxLeftMid1, maxLeftMid2).toDouble()
            }
        } else if (maxLeftMid1 > minRightMid2) {
            // move left
            right = indexMid1ToCheck - 1
        } else {
            // move right
            left = indexMid1ToCheck + 1
        }
    }
    throw IllegalArgumentException("Input arrays are not valid")
}
