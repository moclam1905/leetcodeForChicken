package linkedLists

import ListNode

fun hasCycle(head: ListNode?): Boolean {
    if (head?.next == null) return false
    var slow: ListNode? = head
    var fast: ListNode? = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            return true
        }
    }
    return false
}