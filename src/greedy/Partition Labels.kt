package greedy

fun partitionLabels(s: String): List<Int> {
    val tmp = IntArray(26)

    for (i in s.indices){
        tmp[s[i] - 'a'] = i
    }

    var end = 0
    var start = 0
    val rs = mutableListOf<Int>()

    for (i in s.indices){
        end = Math.max(end, tmp[s[i]- 'a'])
        if (i == end) {
            rs.add(end - start +1)
            start = i + 1
        }
    }

    return rs
}

fun main() {
    println(
        partitionLabels("abac")
    )
}