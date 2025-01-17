package arrayAndString

fun reverseVowels(s: String): String {
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val chars = s.toCharArray()
    var i =0
    var j = chars.size -1

    while (i< j){
        while (i< j && chars[i] !in  vowels) i++
        while (i< j && chars[j] !in  vowels) j--

        if (i < j) {
            val tmp = chars[i]
            chars[i] = chars[j]
            chars[j] = tmp
            i++
            j--
        }

//        if (chars[i] in  vowels){
//            if (chars[j] in vowels){
//                val tmp = chars[i]
//                chars[i] = chars[j]
//                chars[j] = tmp
//                i++
//                j--
//            }else j--
//        } else i++

    }

    return String(chars)
}

fun main() {
    println(reverseVowels("leetcode"))
}
