package heaps

import java.util.*


fun topKFrequentV2(nums: IntArray, k: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    for (n in nums) {
        hashMap[n] = hashMap.getOrDefault(n, 0) + 1
    }

    val heap = PriorityQueue { a: Map.Entry<Int, Int>, b: Map.Entry<Int, Int>
        ->
        a.value.compareTo(b.value)
    }

    for (entry in  hashMap.entries) {
        if (heap.size < k){
            heap.offer(entry)
        } else {
            heap.offer(entry)
            heap.poll()
        }
    }

    val rs = IntArray(k)
    for (i in 0..<k) {
        rs[i] = heap.poll().key
    }

    return rs
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    for (n in nums) {
        hashMap[n] = hashMap.getOrDefault(n, 0) + 1
    }

    val heap = PriorityQueue<Map.Entry<Int,Int>>(compareByDescending{it.value}).apply {
        addAll(
            hashMap.entries
        )
    }


    val rs = IntArray(k) {
        heap.poll().key
    }


    return rs
}

