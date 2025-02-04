package greedy

import java.util.PriorityQueue

fun reorganizeStringV2(s: String): String {
    val n = s.length
    val countArr = IntArray(26)
    for (i in s.indices) {
        countArr[s[i] - 'a']++
    }

    val maxAllowed = (n +1 )/2
    for (i in countArr){
        if (i > maxAllowed) return ""
    }

    val charList = mutableListOf<Char>()
    for (i in 0 until 26) {
        repeat(countArr[i]){
            charList.add('a' + i)
        }
    }

    charList.sortWith { c1, c2 ->
        countArr[c2 - 'a'] - countArr[c1 - 'a']

    }

    val rs = CharArray(n)
    var index = 0

    for (i in charList) {
        rs[index] = i
        index += 2
        if (index >= n) {
            index = 1
        }
    }

    return String(rs )

}

fun main() {
    reorganizeString("aab")
}

fun reorganizeString(s: String): String {
    val n = s.length
    val countArr = IntArray(26)
    for (i in s.indices) {
        countArr[s[i] - 'a']++
    }

    // Check if any char is more than n/2
    val maxAllowed = (n +1 )/2
    for (i in countArr){
        if (i > maxAllowed) return ""
    }

    // use PriorityQueue to order by descending count of char
   val heap = PriorityQueue<Pair<Char,Int>>(compareByDescending { it.second })
    for (i in 0 until 26) {
        if (countArr[i] > 0) {
            heap.add(Pair('a' + i, countArr[i]))
        }
    }

    val rs = StringBuilder()

    // taking the 2 highest frequency char at the same time
    while (heap.size >= 2){
        val first = heap.poll()
        val second = heap.poll()

        rs.append(first.first)
        rs.append(second.first)

        // decrease their frequency
        val newFirst = first.second - 1
        val newSecond = second.second - 1

        // add them back to heap
        if (newFirst > 0)
            heap.add(Pair(first.first, newFirst))

        if (newSecond > 0)
            heap.add(Pair(second.first, newSecond))

    }

    // If exist 1 item in heap, add it to rs (freq = 1)
    if (heap.isNotEmpty()) {
        rs.append(heap.poll().first)
    }

    return rs.toString()


}