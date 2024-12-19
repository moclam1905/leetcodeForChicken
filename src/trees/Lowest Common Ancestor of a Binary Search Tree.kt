package trees

import TreeNode

fun lowestCommonAncestorV2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var currNode = root
    while (currNode != null) {
        val currValue = currNode.`val`
        if (p != null) {
            if (q != null) {
                currNode = when {
                    currValue < p.`val` && currValue < q.`val` -> currNode.right
                    currValue > p.`val` && currValue > q.`val` -> currNode.left
                    else -> return currNode
                }
            }
        }
    }

    return null
}

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null)
        return null
    if (p == null)
        return null
    if (q == null)
        return null

    val crrValue = root.`val`
    val pValue = p.`val`
    val qValue = q.`val`

    return if (crrValue < pValue && crrValue < qValue)
        lowestCommonAncestor(root.right, p, q)
    else if (crrValue > pValue && crrValue > qValue)
        lowestCommonAncestor(root.left, p, q)
    else root

}