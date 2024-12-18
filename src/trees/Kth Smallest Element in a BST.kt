package trees

import TreeNode
import java.util.*

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var n = k
    val stack = Stack<TreeNode>()
    var crrNode = root

    while (crrNode != null || !stack.isEmpty()) {
        while (crrNode != null) {
            stack.push(crrNode)
            crrNode = crrNode.left
        }

        crrNode = stack.pop()
        n--
        if (n == 0)
            return crrNode.`val`

        crrNode = crrNode.right
    }

    return -1
}