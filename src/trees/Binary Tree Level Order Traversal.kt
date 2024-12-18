package trees

import TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val ans = ArrayList<ArrayList<Int>>()
    if (root == null)
        return ans

    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (!queue.isEmpty()) {
        val levelList = ArrayList<Int>()
        val n = queue.size

        for (i in 0..<n) {
            val tmpNode = queue.poll()
            levelList.add(tmpNode.`val`)

            if (tmpNode.left != null) queue.add(tmpNode.left)
            if (tmpNode.right != null) queue.add(tmpNode.right)
        }

        ans.add(levelList)
    }

    return ans
}