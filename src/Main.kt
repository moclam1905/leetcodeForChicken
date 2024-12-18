import binarySearch.minEatingSpeed
import slidingWindow.characterReplacement
import slidingWindow.checkInclusion
import slidingWindow.findMaxAverage
import trees.diameterOfBinaryTree
import trees.invertTree

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//    val node1 = ListNode(1)
//    val node2 = ListNode(2)
//    val node3 = ListNode(3)
//    val node4 = ListNode(4)
//    val node5 = ListNode(5)
//
//    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//
//
//    val node1a = ListNode(1)
//    val node2a = ListNode(3)
//    val node3a = ListNode(4)
//
//    node1a.next = node2a
//    node2a.next = node3a
//
//    val node1x = ListNode(1)


//    val a = Node(7)
//    val s = Node(13)
//    val d = Node(11)
//    val f = Node(10)
//    val g = Node(1)
//
//    a.next = s
//    s.next = d
//    d.next=f
//    f.next=g
//
//    a.random =null
//    s.random = a
//    d.random = g
//    f.random = d
//    g.random = a

    //copyRandomList(a)


    //isPerfectSquare(2147483647)

//    val x = intArrayOf(3,6,7,11)
//    minEatingSpeed(x, 8)
//    val s1 = "ab"
//    val s2 = "eidbaooo"
//    checkInclusion(s1, s2)


    var a = TreeNode(1)
    var b = TreeNode(2)
    var c = TreeNode(3)
    var d = TreeNode(4)
    var e = TreeNode(5)


    a.left = b
    a.right = c
    b.left = d
    b.right = e


    diameterOfBinaryTree(a)


}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

 class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
 }
