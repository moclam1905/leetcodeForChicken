package graphs

import java.util.*
import kotlin.collections.ArrayList


fun validPathDFS(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    if (source == destination)
        return true

    val adjList: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    for (edge in edges) {
        adjList.computeIfAbsent(edge[0]) { ArrayList() }.add(edge[1])
        adjList.computeIfAbsent(edge[1]) { ArrayList() }.add(edge[0])
    }

    val visited = BooleanArray(n)
    val stack = Stack<Int>()

    stack.push(source)
    visited[source] = true

    while (stack.isNotEmpty()) {
        val crrVertex = stack.pop()


        if (crrVertex == destination)
            return true

        for (neighbor in adjList.getOrDefault(crrVertex, emptyList())) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                stack.push(neighbor)
            }
        }
    }

    return false

}

fun validPathBFS(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    if (source == destination)
        return true

    val adjList: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    for (edge in edges) {
        adjList.computeIfAbsent(edge[0]) { ArrayList() }.add(edge[1])
        adjList.computeIfAbsent(edge[1]) { ArrayList() }.add(edge[0])
    }

    val visited = BooleanArray(n)
    val queue: Queue<Int> = LinkedList()

    queue.add(source)
    visited[source] = true

    while (queue.isNotEmpty()) {
        val crrVertex = queue.poll()


        if (crrVertex == destination)
            return true

        for (neighbor in adjList.getOrDefault(crrVertex, emptyList())) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.add(neighbor)
            }
        }
    }

    return false

}