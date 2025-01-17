package slidingWindow

fun findAnagrams(s: String, p: String): List<Int> {
    if (p.length > s.length)
        return emptyList()

    // create 2 hash map for sliding window(size = p.length) and p string
    val window = IntArray(26)
    val pChars = IntArray(26)

    val rs = mutableListOf<Int>()

    // fill data p hash map
    for (i in p) {
        pChars[i - 'a'] ++
    }

    for (i in s.indices) {
        // add data to window hash map
        window[s[i] - 'a']++

        // just process on window with p length
        if (i >= p.length) {
            // remove a char in window
            window[s[i - p.length] - 'a']--
        }

        // check content. exp window : [1,1,0...] = pChars : [1,1,0...]
        if (window.contentEquals(pChars)) {
            rs.add(i - p.length +1) // +1 to guarantee the index is not -1
        }
    }

    return rs
}