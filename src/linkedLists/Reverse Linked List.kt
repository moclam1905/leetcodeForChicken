package linkedLists

import ListNode

fun reverseList(head: ListNode?): ListNode? {
    var cur = head
    var rs: ListNode? = null
    while (cur!= null){
        val tmp : ListNode? = cur.next
        cur.next = rs
        rs = cur
        cur = tmp
    }

    return rs
}