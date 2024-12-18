package trees

import TreeNode
import java.util.Stack

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    return hasSum(root, targetSum, 0)
}

private fun hasSum(root: TreeNode?, targetSum: Int, cS: Int): Boolean {
    var csLocal = cS
    if (root == null) return false
    csLocal += root.`val`

    if (root.left == null && root.right == null) {
        return csLocal == targetSum
    }

    return hasSum(root.left, targetSum, csLocal) || hasSum(root.right, targetSum, csLocal)

}

fun hasPathSumWith2Stack(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null)
        return false

    val stackPatch = Stack<TreeNode>()
    val stackSum = Stack<Int>()

    stackPatch.push(root)
    stackSum.push(root.`val`)

    while (!stackPatch.isEmpty()) {
        val tmpPath = stackPatch.pop()
        val tmpSum = stackSum.pop()

        if (tmpPath.left == null && tmpPath.right == null && tmpSum == targetSum)
            return true

        if (tmpPath.left != null) {
            stackPatch.push(tmpPath.left)
            stackSum.push(tmpSum + tmpPath.left!!.`val`)
        }

        if (tmpPath.right != null) {
            stackPatch.push(tmpPath.right)
            stackSum.push(tmpSum + tmpPath.right!!.`val`)
        }

    }

    return false
}
