package twoPointers

fun isPalindrome(s: String): Boolean {
    val n = s.length
    if (n == 1 && s[0] == ' ')
        return true

    var i = 0
    var j = n - 1

    while (i < j) {
        while (i < j && !s[i].isLetterOrDigit()) {
            i++
        }
        while (i < j && !s[j].isLetterOrDigit()) {
            j--
        }

        if (i < j) {
            if (s[i].lowercaseChar() != s[j].lowercaseChar()) {
                return false
            }
        }
        i++
        j--
    }

    return true
}

fun isOnlyLetters(word: Char): Boolean {
    val regex = "^[A-Za-z]*$".toRegex()
    return regex.matches(word.toString())
}

//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
