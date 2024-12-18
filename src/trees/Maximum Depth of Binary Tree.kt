package trees

import TreeNode
import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
    if (root == null)
        return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return  1 + max(left, right)
}