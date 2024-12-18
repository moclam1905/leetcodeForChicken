package trees

import TreeNode

fun isSymmetric(root: TreeNode?): Boolean {
    return  isSymmetricNode(root, root)
}

fun isSymmetricNode(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` != q.`val`) return false

    return isSymmetricNode(p.right, q.left) && isSymmetricNode(p.left, q.right)
}