package trees

import TreeNode

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (subRoot == null)
        return true

    if (root == null)
         return false
    if (isSameSubTree(root, subRoot)) {
        return true
    }

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
}

fun isSameSubTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` != q.`val`) return false

    return isSameSubTree(p.left, q.left) && isSameSubTree(p.right, q.right)
}