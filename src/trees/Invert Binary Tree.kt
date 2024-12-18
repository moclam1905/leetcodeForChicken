package trees

import TreeNode


fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null)
        return null

    val tmpNode: TreeNode? = root.left
    root.left = root.right
    root.right = tmpNode

    invertTree(root.left)
    invertTree(root.right)

    return root

}