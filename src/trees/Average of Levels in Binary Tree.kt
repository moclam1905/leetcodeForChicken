package trees

import TreeNode
import java.util.LinkedList
import java.util.Queue

fun averageOfLevels(root: TreeNode?): DoubleArray {
    val rsList = mutableListOf<Double>()
    if (root == null)
        return doubleArrayOf()

    val queue : Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        var levelSum = 0.0

        for (i in 0..<levelSize) {
            val crrNode = queue.poll()
            levelSum += crrNode.`val`

            crrNode.left?.let { queue.add(it) }
            crrNode.right?.let { queue.add(it) }
        }

        rsList.add(levelSum/levelSize)
    }
    return rsList.toDoubleArray()

}