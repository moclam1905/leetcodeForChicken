package linkedLists

import Node

fun copyRandomListHashMap(head: Node?): Node? {
    if (head == null) return  null

    val hm = HashMap<Node, Node>()
    var curr = head

    while (curr !=null) {
        hm[curr] = Node(curr.`val`)
        curr = curr.next
    }

    curr = head

    while (curr != null) {
        val newNode = hm[curr]
        newNode?.next = hm[curr.next]
        newNode?.random = hm[curr.random]

        curr = curr.next
    }

    return hm[head]
}

fun copyRandomList(node: Node?): Node? {

    if (node == null) return null
    var curr = node

    while (curr != null) {
        val newNode = Node(curr.`val`)
        newNode.next = curr.next
        curr.next = newNode

        curr = newNode.next
    }

    curr = node

    while (curr != null) {
        val copyNode = curr.next
        copyNode?.random = curr.random?.next
        curr = copyNode?.next

    }

    curr = node
    val tmp = Node(0)
    var cCurr : Node? = tmp
    while (curr != null) {
        val copyNode = curr.next
        val originNext = copyNode?.next

        cCurr?.next = copyNode
        cCurr = copyNode

        curr.next = originNext
        curr = originNext

    }

    return tmp.next
}
