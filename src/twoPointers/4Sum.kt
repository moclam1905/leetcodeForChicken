package twoPointers

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0 until nums.size - 3) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        for (j in i + 1 until nums.size - 2) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue

            var l = j + 1
            var r = nums.size - 1

            while (l < r) {
                val sum = nums[i].toLong() + nums[j].toLong() + nums[l].toLong() + nums[r].toLong()
                when {
                    sum == target.toLong() -> {
                        result.add(listOf(nums[i], nums[j], nums[l], nums[r]))
                        l++
                        r--
                        while (l < r && nums[l] == nums[l - 1]) l++
                        while (l < r && nums[r] == nums[r + 1]) r--
                    }
                    sum < target.toLong() -> l++
                    else -> r--
                }
            }
        }
    }

    return result
}
