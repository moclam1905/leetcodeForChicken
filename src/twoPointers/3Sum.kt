package twoPointers

fun threeSum1(nums: IntArray): List<List<Int>> {
    val result = HashSet<List<Int>>()
    nums.sort()

    for (i in 0..<nums.size - 2) {
        var l = i + 1
        var r = nums.size - 1

        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]

            when {
                sum == 0 -> {
                    result.add(arrayListOf(nums[i], nums[l], nums[r]))
                    r--
                    l++
                }

                sum > 0 -> r--
                else -> l++
            }
        }
    }
    return result.toList()

}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0..<nums.size - 2) {
        if (nums[i] > 0)
            break
        if (i > 0 && nums[i] == nums[i - 1])
            continue

        var l = i + 1
        var r = nums.size - 1

        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]

            when {
                sum == 0 -> {
                    result.add(arrayListOf(nums[i], nums[l], nums[r]))
                    r--
                    l++

                    while (l < r && nums[l] == nums[l - 1]) l++

                    while (l < r && nums[r] == nums[r + 1]) r--

                }

                sum > 0 -> r--
                else -> l++
            }
        }
    }
    return result.toList()

}