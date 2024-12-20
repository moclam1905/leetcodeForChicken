package heaps

import ListNode
import java.util.PriorityQueue

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val heap = PriorityQueue<ListNode>( compareBy{it.`val`}).apply {
        lists.forEach { node ->
            if (node != null) {
                offer(node)
            }
        }
    }

    val dm = ListNode(0)
    var crrNode = dm

    while (heap.isNotEmpty()) {
        val nodeLocal = heap.poll()
        crrNode.next = nodeLocal
        crrNode = nodeLocal

        if (nodeLocal.next != null) {
            heap.offer(nodeLocal.next)
        }
    }

    return dm.next

}


// use mergeTwoLists()


