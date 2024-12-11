package linkedLists

import ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val tmp = ListNode(0)
    tmp.next = head

    var allItemTmp: ListNode? = tmp
    var subListItem: ListNode? = tmp
    for (i in 0..n) {
        subListItem = subListItem?.next
    }

    while (subListItem != null) {
        allItemTmp = allItemTmp?.next
        subListItem = subListItem.next
    }

    allItemTmp?.next = allItemTmp?.next?.next

    return tmp.next
}
