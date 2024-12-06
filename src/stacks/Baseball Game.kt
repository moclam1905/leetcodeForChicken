package stacks

import java.util.*

fun calPoints(operations: Array<String>): Int {
    val stack = Stack<Int>()

    for (i in operations.indices){
        when(operations[i]) {
            "+" -> {
                val topValue = stack.pop()
                val newValue = topValue + stack.peek()

                stack.push(topValue)
                stack.push(newValue)
            }
            "C" -> stack.pop()
            "D" -> stack.push(stack.peek()*2)
            else -> stack.push(operations[i].toInt())

        }
    }

    var sum = 0
    while (!stack.isEmpty()) {
        sum += stack.pop()
    }

    return sum
}