package trees

import TreeNode
import kotlin.math.abs
import kotlin.math.max

fun isBalanced(root: TreeNode?): Boolean {
    return height(root) != -1
}

fun height(root: TreeNode?): Int {
    if (root == null)
        return 0

    val left = height(root.left)
    if (left == -1 )
        return -1

    val right = height(root.right)
    if (right == -1)
        return -1

    if (abs(left - right) >1)
        return -1

    return  1 + max(left, right)
}
