package recursiveBacktracking

fun combine(n: Int, k: Int): List<List<Int>> {
    val rs: MutableList<List<Int>> = arrayListOf()
    val tmp: MutableList<Int> = arrayListOf()
    backtrackCombine(rs, tmp, 1, n, k)
    return rs
}

fun backtrackCombine(rs: MutableList<List<Int>>, tmp: MutableList<Int>, start: Int, n: Int, k: Int){
   if (tmp.size == k) {
       rs.add(ArrayList(tmp))
       return
   }

    for (i in start..n) {
        tmp.add(i)
        backtrackCombine(rs, tmp, i + 1, n, k)
        tmp.removeAt(tmp.size - 1)
    }
}