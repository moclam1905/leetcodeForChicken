package linkedLists

import ListNode

fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    var crr = head
    while (crr?.next !=  null) {
        val gdc = gdc(crr.`val`, crr.next!!.`val`)
        val newNode = ListNode(gdc)
        newNode.next = crr.next
        crr.next = newNode
        crr = newNode.next
    }

    return head
}

private fun gdc(a: Int, b: Int):Int {
    return if (b == 0) a else gdc(b, a%b)
}