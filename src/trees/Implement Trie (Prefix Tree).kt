package trees

//private class TrieNode {
//    var children: MutableMap<Char,TrieNode> = HashMap()
//    var isEndOfWord = false
//
//}
//
//private val root: TrieNode = TrieNode()
//
//
//fun insert(word: String) {
//    var node = root
//    for (c in word) {
//        if (!node.children.containsKey(c)) {
//            node.children[c] = TrieNode()
//        }
//        node = node.children[c]!!
//    }
//    node.isEndOfWord = true
//}
//
//fun search(word: String): Boolean {
//    var node = root
//    for (c in word) {
//        if (!node.children.containsKey(c))
//            return false
//
//        node = node.children[c]!!
//    }
//
//    return node.isEndOfWord
//}
//
//fun startsWith(prefix: String): Boolean {
//    var node = root
//    for (c in prefix) {
//        if (!node.children.containsKey(c))
//            return false
//
//        node = node.children[c]!!
//    }
//
//   return true
//}



private class TrieNode {
    var childrenChars = arrayOfNulls<TrieNode>(26)
    var isEndOfWord = false

    fun insert(c: Char): TrieNode {
        childrenChars[c - 'a'] = TrieNode()
        return childrenChars[c - 'a']!!
    }

    fun get(c: Char): TrieNode? {
        return childrenChars[c - 'a']
    }

    fun contains(c: Char): Boolean {
        return childrenChars[c - 'a'] != null
    }

}

private val root: TrieNode = TrieNode()


fun insert(word: String) {
    var node = root
    for (c in word) {
        if (!node.contains(c)) {
            node.insert(c)
        }
        node = node.get(c)!!
    }

    node.isEndOfWord = true
}

fun search(word: String): Boolean {
    var node = root
    for (c in word) {
        if (!node.contains(c))
            return false

        node = node.get(c)!!
    }

    return node.isEndOfWord
}

fun startsWith(prefix: String): Boolean {
    var node = root
    for (c in prefix) {
        if (!node.contains(c))
            return false

        node = node.get(c)!!
    }

    return true
}
