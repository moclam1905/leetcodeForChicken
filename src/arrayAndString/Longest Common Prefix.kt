package arrayAndString

fun longestCommonPrefix(strs: Array<String>): String {
    val firstItem = strs[0]

    for(i in firstItem.indices){
        val letterOfFirstItem = strs[0][i]

        for (j in 1..<strs.size){
            if (i >= strs[j].length || strs[j][i] != letterOfFirstItem) {
                return strs[0].substring(0, i)
            }
        }
    }

    return firstItem
}