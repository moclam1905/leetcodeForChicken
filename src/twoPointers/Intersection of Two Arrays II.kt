package twoPointers

fun intersectHS(nums1: IntArray, nums2: IntArray): IntArray {
    val hashMap = mutableMapOf<Int, Int>()
    val rs = mutableListOf<Int>()

    for (n in nums1) {
        hashMap[n] = hashMap.getOrDefault(n,0) + 1
    }

    for (n in nums2){
        if (hashMap.getOrDefault(n, 0) >0) {
            rs.add(n)
            hashMap[n] = hashMap[n]!! -1
        }
    }

    return rs.toIntArray()

}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

    val rs = mutableListOf<Int>()
    nums1.sort()
    nums2.sort()

    var i = 0
    var j = 0
    while (i< nums1.size && j < nums2.size){
        if (nums1[i] < nums2[j]) i++
         else if (nums1[i] > nums2[j]) j++

        else {
            rs.add(nums1[i])
            i++
            j++
        }


    }

    return rs.toIntArray()

}