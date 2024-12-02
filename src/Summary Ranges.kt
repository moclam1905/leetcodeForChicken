fun summaryRanges(nums: IntArray): List<String> {
    if (nums.isEmpty()) return emptyList()

    var start = nums[0]
    var end = nums[0]

    val result = mutableListOf<String>()

    for (i in 1..<nums.size) {
        val currentValue = nums[i]
        val prevValue = nums[i - 1]

        if (currentValue - prevValue == 1) {
            end = currentValue
        } else {
            if (start == end) {
                result.add("$start")
            } else {
                result.add("$start->$end")
            }

            start = currentValue
            end = start
        }
    }
    if (start == end) {
        result.add("$start")
    } else {
        result.add("$start->$end")
    }


    return result
}