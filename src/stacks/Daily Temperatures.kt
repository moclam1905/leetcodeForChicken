package stacks

import java.util.Stack

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val n = temperatures.size
    val arr = IntArray(n) {0}
    val stack = Stack<Int>()

    for (i in n -1 downTo 0){

        // remove all index with a lower or equal temperature than the curr index
        while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
            stack.pop()
        }

        if (!stack.isEmpty()) {
            arr[i] = stack.peek() - i
        }

        stack.push(i)
    }

    return arr
}