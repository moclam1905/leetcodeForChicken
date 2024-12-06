package stacks

import java.util.Stack
import kotlin.math.ceil
import kotlin.math.floor

fun evalRPNV1(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    for (tk in tokens) {
        if (tk == "+" || tk == "-" || tk == "*" || tk == "/") {
            val b = stack.pop()
            val a = stack.pop()

            when (tk) {
                "+" -> stack.push(a + b)
                "-" -> stack.push(a - b)
                "*" -> stack.push(a * b)
                "/" -> {
                    val value = (a / b).toDouble()
                    stack.push(if (value > 0) floor(value).toInt() else ceil(value).toInt())
                }
            }
        } else {
            stack.push(tk.toInt())
        }
    }

    return stack.pop()
}

fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    for (tk in tokens) {
        when (tk) {
            "+" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a + b)
            }

            "-" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a - b)
            }

            "*" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a * b)
            }

            "/" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a / b)
            }

            else -> stack.push(tk.toInt())

        }
    }

    return stack.pop()
}