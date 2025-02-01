package arrayAndString

class NumArray(nums: IntArray) {
    private val prefixSum = IntArray(nums.size + 1)
    init {
        for (i in nums.indices){
            prefixSum[i+1] = prefixSum[i] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefixSum[right +1] - prefixSum[left ]
    }

}