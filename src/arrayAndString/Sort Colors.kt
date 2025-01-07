package arrayAndString

fun sortColors(nums: IntArray): Unit {
    var indexColor0 = 0
    var indexColor2 = nums.size - 1
    var i = 0

    while (i <= indexColor2) {
        when(nums[i]) {
            0 -> {
                nums[i] = nums[indexColor0].also { nums[indexColor0] = nums[i] }
                i++
                indexColor0++
            }
            2 -> {
                nums[i] = nums[indexColor2].also { nums[indexColor2] = nums[i] }
                indexColor2--
            }

            else -> {
                i++ //intArrayOf(2, 0, 1)
            }

        }
    }

}