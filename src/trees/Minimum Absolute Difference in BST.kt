package trees

import TreeNode
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun getMinimumDifference(root: TreeNode?): Int {
    var m = Int.MAX_VALUE
    val stack = Stack<TreeNode>()
    var crrNode = root
    var preValue: Int? = null

    while (crrNode != null || !stack.isEmpty()) {
        while (crrNode != null) {
            stack.push(crrNode)
            crrNode = crrNode.left
        }
        crrNode = stack.pop()

        if (preValue != null) {
            m = min(m, abs(preValue - crrNode.`val`))
        }

        preValue = crrNode.`val`

        crrNode = crrNode.right
    }

    return m
}

var minDiff = Int.MAX_VALUE
var preNode: TreeNode? = null

private fun inOrderTraversal(root: TreeNode?) {
    if (root == null)
        return

    inOrderTraversal(root.left)


    if (preNode != null) {
        minDiff = min(minDiff, root.`val` - preNode!!.`val`)
    }

    preNode = root

    inOrderTraversal(root.right)
}

private fun getMinimumDifferenceV2(root: TreeNode?): Int {
    inOrderTraversal(root)
    return minDiff
}