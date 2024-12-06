package stacks

import java.util.*


/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

class MinStack {
    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(value: Int) {
        stack.push(value)
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value)
        } else {
            minStack.push(minStack.peek())
        }
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}