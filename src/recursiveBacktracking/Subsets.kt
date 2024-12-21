package recursiveBacktracking


fun subsets(nums: IntArray): List<List<Int>> {
    val rs: MutableList<List<Int>> = arrayListOf()
    val tmp: MutableList<Int> = arrayListOf()
    backtrackSubset(nums, rs, tmp, 0)
    return rs
}

fun backtrackSubset(nums: IntArray, rs: MutableList<List<Int>>, tmp: MutableList<Int>, indexStart: Int){
    rs.add(tmp)
    for (i in indexStart..<nums.size) {
        tmp.add(nums[i])
        backtrackSubset(nums,rs, tmp, i +1)
        tmp.removeAt(tmp.size -1)
    }
}