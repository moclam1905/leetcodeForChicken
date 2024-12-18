package trees

import TreeNode

fun isValidBST(root: TreeNode?): Boolean {
    return isValidNode(root, Long.MAX_VALUE, Long.MIN_VALUE)
}

private fun isValidNode(root: TreeNode?, max: Long, min: Long): Boolean {
    if (root == null)
        return true

    if (root.`val` >= max || root.`val` <= min)
        return false

    return isValidNode(root.left, root.`val`.toLong(), min) && isValidNode(root.right, max, root.`val`.toLong())
}