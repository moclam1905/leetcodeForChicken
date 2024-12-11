package linkedLists

import ListNode

fun deleteDuplicates(head: ListNode?): ListNode? {
    head?.let {
        var cur : ListNode = it

        while (cur.next != null) {
            if (cur.`val` == cur.next!!.`val`) {
                cur.next = cur.next!!.next
            } else {
                cur = cur.next!!
            }
        }

        return it
    }

    return null

}