package binarySearch


//override fun firstBadVersion(n: Int) : Int {
//    if (n == 1) return n
//
//    var l = 1
//    var r = n
//    var badVersion = 1
//    while (l<= r) {
//        val mid = l + (r - l)/2
//        if (isBadVersion(mid)) {
//            r =mid - 1
//            badVersion = mid
//        }
//        else {
//            l = mid + 1
//        }
//    }
//
//    return badVersion
//}