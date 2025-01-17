package arrayAndString

//  Cycle Detection - (Floyd's Tortoise and Hare)
fun findDuplicate(nums: IntArray): Int {
    var t = nums[0]
    var h = nums[0]
    do {
        t = nums[t]
        h = nums[nums[h]]
    } while (t != h)

    t = nums[0]
    while (t != h) {
        t = nums[t]
        h = nums[h]
    }

    return t
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 3, 4, 2, 2)
    findDuplicate(nums)
}
fun findDuplicateV2(nums: IntArray): Int {
    val arr = BooleanArray(100010)
    for (num in nums) {
        if (arr[num])
            return num

        arr[num] = true
    }

    return  -1
}