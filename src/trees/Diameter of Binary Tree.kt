package trees

import TreeNode
import java.util.Stack
import kotlin.math.max

var lDiameter = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    heightTree(root)

    return lDiameter
}

private fun heightTree(root: TreeNode?): Int {
    if (root == null)
        return 0

    val left = heightTree(root.left)
    val right = heightTree(root.right)

    lDiameter = max(left + right, lDiameter)

    return  1 + max(left, right)
}


// no recursive
fun diameterOfBinaryTreeWithoutRecursive(root: TreeNode?): Int{
    var lDiameter = 0
    val stack = Stack<TreeNode>()
    val hashMap = HashMap<TreeNode, Int>()

    if (root != null)
        stack.push(root)

    while (!stack.isEmpty()) {
        val nodeLocal = stack.peek()

        if (nodeLocal.left != null && !hashMap.containsKey(nodeLocal.left)) {
            stack.push(nodeLocal.left)
        } else if(nodeLocal.right != null && !hashMap.containsKey(nodeLocal.right)) {
            stack.push(nodeLocal.right)
        } else {
            stack.pop()

            val l = hashMap.getOrDefault(nodeLocal.left , 0)
            val r = hashMap.getOrDefault(nodeLocal.right, 0)

            hashMap[nodeLocal] = 1 + max(l , r)

            lDiameter = max(lDiameter, l + r)
        }
    }

    return lDiameter

}