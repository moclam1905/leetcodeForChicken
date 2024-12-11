package linkedLists

import ListNode

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val tmpNode = ListNode(0)
    var curr = tmpNode
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null){
        if (l1.`val` < l2.`val`) {
            curr.next = l1
            l1 = l1.next
        } else {
            curr.next = l2
            l2 = l2.next
        }

        curr = curr.next!!
    }

    curr.next = l1 ?: l2
    return tmpNode.next

}