package graphs

import NodeGraph as Node
import java.util.LinkedList
import java.util.Queue

fun cloneGraphV2(node: Node?): Node? {
    if (node == null)
        return null

    val visited: MutableMap<Node, Node> = mutableMapOf()
    val queue: Queue<Node> = LinkedList()
    queue.offer(node)

    val cloneNode = Node(node.`val`)
    cloneNode.neighbors = ArrayList()
    visited[node] = cloneNode

    while (queue.isNotEmpty()) {
        val crrNode = queue.poll()

        for (n in crrNode.neighbors) {
            n?.let {
                if (!visited.containsKey(n)) {
                    val cloneNodeTmp = Node(n.`val`)
                    cloneNodeTmp.neighbors = ArrayList()

                    visited[n] = cloneNodeTmp
                    queue.offer(n)
                }

                (visited[crrNode]?.neighbors as MutableList<Node>).add(visited[n]!!)
            }

        }
    }

    return cloneNode
}

fun cloneGraph(node: Node?): Node? {
    if (node == null)
        return null

    val visited: MutableMap<Node, Node> = mutableMapOf()
    return dfsCloneGraph(node, visited)

}

private fun dfsCloneGraph(node: Node, visited: MutableMap<Node, Node>): Node {
    if (visited.containsKey(node))
        return visited[node]!!

    val cloneNode = Node(node.`val`)
    cloneNode.neighbors = ArrayList()
    visited[node] = cloneNode

    for (n in node.neighbors) {
        (cloneNode.neighbors as MutableList<Node>).add(dfsCloneGraph(n!!, visited))
    }

    return cloneNode

}