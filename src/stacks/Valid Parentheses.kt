package stacks

import java.util.*
import kotlin.collections.HashMap

fun isValid2(s: String): Boolean {
    val hashMap = HashMap<Char, Char> ()
    hashMap[')'] = '('
    hashMap[']'] = '['
    hashMap['}'] = '{'

    val stack = Stack<Char>()

    for (c in s.toCharArray()){
        if (!hashMap.containsKey(c)){
            stack.push(c)
        } else {
            if (stack.isEmpty() ||  hashMap.getValue(c) != stack.pop())
                return false
        }
    }

    return stack.isEmpty()
}

fun isValid1(s: String): Boolean {
    val stack = Stack<Char>()

    for (c in s){
        when (c) {
            '(', '[','{' -> stack.push(c)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false

        }
    }

    return stack.isEmpty()
}

fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()

    for (c in s) {
        when (c) {
            '(', '[', '{' -> stack.add(c)
            ')' -> {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != '(') return false
            }
            ']' -> {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != '[') return false
            }
            '}' -> {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != '{') return false
            }
            else -> continue
        }
    }

    return stack.isEmpty()
}
