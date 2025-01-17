package arrayAndString

fun validPalindromeV2(s: String): Boolean {
    fun isPalindrome(s: String, l: Int, r: Int): Boolean {
        var i = l
        var j = r
        while (i < j) {
            if (s[i] != s[j])
                return false
            i++
            j--
        }

        return true
    }

    var i = 0
    var j = s.length - 1
    while (i < j) {
        if (s[i] != s[j])
            return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)

        i++
        j--
    }

    return true
}

fun validPalindrome(s: String): Boolean {

    return isPalindromeHelper(s, 0, s.length - 1, 1)
}

fun isPalindromeHelper(s: String, l: Int, r: Int, badValue: Int): Boolean {
    if (badValue < 0)
        return false

    var i = l
    var j = r
    while (i < j) {
        if (s[i] != s[j])
            return isPalindromeHelper(s, i + 1, j, badValue - 1) || isPalindromeHelper(s, i, j - 1, badValue - 1)
        i++
        j--
    }

    return true
}

fun main() {
    println(validPalindrome("abc"))
}