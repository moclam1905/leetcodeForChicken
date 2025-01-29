package slidingWindow


fun maxSlidingWindowV2(nums: IntArray, k: Int): IntArray {
    var maxIndex = -1
    val rs = mutableListOf<Int>()
    for (i in 0..nums.size - k) {
        if (maxIndex < i) {
            maxIndex = i
            for (j in i until i + k) {
                if (nums[j] > nums[maxIndex])
                    maxIndex = j
            }

        } else if (nums[i + k - 1] > nums[maxIndex])
            maxIndex = i + k - 1

        rs.add(nums[maxIndex])

    }
    return rs.toIntArray()
}

fun main() {
    println(maxSlidingWindowV4(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3))
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    // use ArrayDeque store index of element in nums to make sure the first element is the max value in window
    val deque = ArrayDeque<Int>()
    val rs = mutableListOf<Int>()

    for (i in nums.indices) {
        // remove a element in deque if outside the window
        if (deque.isNotEmpty() && deque.first() < i - k + 1) {
            deque.removeFirst()
        }

        // remove all elements if it <= nums[i]
        // only check with the last element in deque
        while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
            deque.removeLast()
        }

        // add index to deque
        deque.addLast(i)

        // add max value to rs with the first element in deque
        if (i >= k - 1) {
            rs.add(nums[deque.first()])
        }
    }

    return rs.toIntArray()
}

fun maxSlidingWindowV3(nums: IntArray, k: Int): IntArray {
    var maxIndex = -1
    val rs = mutableListOf<Int>()
    var maxValue = Int.MIN_VALUE
    for (i in 0..nums.size - k) {
        val s = i
        val e = i + k - 1
        if (maxIndex < s) {
            maxIndex = s
            maxValue = nums[s]
            for (j in s + 1..e) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j
                    maxValue = nums[j]
                }
            }
        } else {
            if (nums[e] > nums[maxIndex]) {
                maxIndex = e
                maxValue = nums[e]
            }
        }

        rs.add(maxValue)
    }
    return rs.toIntArray()
}

fun maxSlidingWindowV4(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    if (n * k == 0) return intArrayOf()

    val maxLeft = IntArray(n)
    val maxRight = IntArray(n)

    val rs = IntArray(n - k + 1)

    for (i in nums.indices) {
        if (i % k == 0) {
            maxLeft[i] = nums[i] // start of 1 block
        } else {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i])
        }
    }

    for (j in nums.indices.reversed()) {
        if (j == n - 1 || (j + 1) % k == 0) {
            maxRight[j] = nums[j] // end of 1 block
        } else {
            maxRight[j] = Math.max(maxRight[j + 1], nums[j])
        }
    }

    // find the max value in start of window and end of window
    for (i in 0 until rs.size) {
        rs[i] = Math.max(maxRight[i], maxLeft[i + k - 1])
    }

    return rs
}
