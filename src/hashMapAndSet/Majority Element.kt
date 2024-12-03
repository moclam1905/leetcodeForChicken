package hashMapAndSet


//Boyer-Moore Voting
fun majorityElement(nums: IntArray): Int {
    var x = nums[0]
    var count = 0

    for (n in nums) {
        if (count == 0) {
            x = n
        }

        count += if (x == n) 1 else -1
    }

    return x
}
