package recursiveBacktracking

fun permute(nums: IntArray): List<List<Int>> {
    val rs: MutableList<List<Int>> = arrayListOf()
    val tmp: MutableList<Int> = arrayListOf()

    backtrackPermute(nums, rs, tmp)

    return rs
}

fun backtrackPermute(nums: IntArray, rs: MutableList<List<Int>>, tmp: MutableList<Int>) {
    if (tmp.size == nums.size) {
        rs.add(ArrayList(tmp))
        return
    }
    for (n in nums) {
        if (tmp.contains(n))
            continue

        tmp.add(n)

        backtrackPermute(nums, rs, tmp)

        tmp.removeAt(tmp.size - 1)
    }
}