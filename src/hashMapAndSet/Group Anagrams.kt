package hashMapAndSet

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val hashMap = HashMap<String, ArrayList<String>>()

    for (item in strs){
        val sortedString = item.toCharArray().sorted().joinToString("")

        if (!hashMap.containsKey(sortedString)) {
            hashMap[sortedString] = ArrayList()
        }

        hashMap[sortedString]?.add(item)
    }

    return ArrayList(hashMap.values)
}

fun groupAnagramsV2(strs: Array<String>): List<List<String>> {
    val hashMap = HashMap<String, MutableList<String>>()

    for(str in strs){
        val countArr = IntArray(26)

        for (s in str) {
            countArr[s - 'a']++
        }

        val keyString = countArr.joinToString("#")

        hashMap.getOrPut(keyString){ mutableListOf() }.add(str)
    }

    return ArrayList(hashMap.values)
}

fun groupAnagramsV3(strs: Array<String>): List<List<String>> {
    val hashMap = HashMap<String, MutableList<String>>()

    for (str in strs) {
        val count = IntArray(26)
        for (ch in str) {
            count[ch - 'a']++
        }
        val sb = StringBuilder()
        for (c in count) {
            sb.append(c).append("#")
        }
        val key = sb.toString()
        hashMap.getOrPut(key) { mutableListOf() }.add(str)
    }

    return hashMap.values.toList()
}
