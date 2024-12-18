package trees

import TreeNode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return isSameNode(p, q)
}

fun isSameNode(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` != q.`val`) return false

    return isSameNode(p.left, q.left) && isSameNode(p.right, q.right)
}