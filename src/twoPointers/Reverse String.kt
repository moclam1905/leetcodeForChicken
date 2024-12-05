package twoPointers

fun reverseString(s: CharArray): Unit {
    val n = s.size
    for(i in 0..<n/2){
        val t = s[i]
        s[i] = s[n-i-1]
        s[n-i-1] = t
    }
}