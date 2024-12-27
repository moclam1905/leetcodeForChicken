package graphs

import java.util.*


data class GraphEdge(val source: Int, val destination: Int, val weight: Int)

class WeightedGraph(val numVertices: Int) {
    val vertices: Array<MutableList<GraphEdge>> = Array(numVertices) { ArrayList() }

    fun addDirectedEdge(u: Int, v: Int, w: Int) {
        vertices[u].add(GraphEdge(u, v, w))
    }
}


fun dijkstraShortestPath(graph: WeightedGraph, source: Int): IntArray {
    val numVertices = graph.numVertices
    val distance = IntArray(numVertices) { Int.MAX_VALUE }


    val priorityQueue = PriorityQueue<GraphEdge>(compareBy { it.weight })

    distance[source] = 0
    priorityQueue.add(GraphEdge(source, source, 0))

    while (priorityQueue.isNotEmpty()) {
        val currentEdge = priorityQueue.poll()
        val currDestination = currentEdge.destination

        for (edge in graph.vertices[currDestination]) {
            val localDestination = edge.destination
            val localWeight = edge.weight

            if (distance[currDestination] + localWeight < distance[localDestination]) {
                distance[localDestination] = distance[currDestination] + localWeight
                priorityQueue.add(GraphEdge(currDestination, localDestination, distance[localDestination]))
            }
        }
    }

    return distance
}

fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
    val source = K - 1

    val graph = WeightedGraph(N)
    for (time in times) {
        val u = time[0] - 1
        val v = time[1] - 1
        val w = time[2]
        graph.addDirectedEdge(u, v, w)
    }

    val distances = dijkstraShortestPath(graph, source)

    var maxDistance = 0
    for (i in 0..<N) {
        if (distances[i] == Int.MAX_VALUE) {
            return -1
        }
        if (distances[i] > maxDistance) {
            maxDistance = distances[i]
        }
    }

    return maxDistance
}