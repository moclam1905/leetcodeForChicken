package recursiveBacktracking

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val rs: MutableList<List<Int>> = arrayListOf()
    val tmp: MutableList<Int> = arrayListOf()
    backtrackCombinationSum(candidates, rs, tmp, target, 0, 0)
    return rs
}

fun backtrackCombinationSum(
    nums: IntArray,
    rs: MutableList<List<Int>>,
    tmp: MutableList<Int>,
    target: Int,
    total: Int,
    indexStart: Int
) {
    if (total == target) {
        rs.add(ArrayList(tmp))
        return
    }
    if (indexStart >= nums.size || total > target) {
        return
    }


    backtrackCombinationSum(nums, rs, tmp, target, total, indexStart + 1)
    tmp.add(nums[indexStart])
    backtrackCombinationSum(nums, rs, tmp, target, nums[indexStart] + total, indexStart)
    tmp.removeAt(tmp.size - 1)
}

fun combinationSumV2(candidates: IntArray, target: Int): List<List<Int>> {
    val dp = List(target + 1) { mutableListOf<List<Int>>() }

    for (c in candidates) {
        for (i in 1..target) {
            if (i < c) continue
            if (i == c) {
                dp[i].add(listOf(c))
            } else {
                for (blist in dp[i - c]) {
                    dp[i].add(blist + c)
                }
            }
        }
    }

    return dp[target]
}