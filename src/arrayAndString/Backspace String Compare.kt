package arrayAndString

import java.util.Stack

fun backspaceCompareV2(s: String, t: String): Boolean {
    return buidlStringToCompare(s) == buidlStringToCompare(t)
}

private fun buidlStringToCompare(string: String): String{
    val stack = Stack<Char>()
    for (c in string){
        if (c != '#') {
            stack.push(c)
        } else {
            if (stack.isNotEmpty()) {
                stack.pop()
            }
        }
    }
    return stack.toString()
}

fun main(args: Array<String>) {
    println(backspaceCompare("ab##", "c#d#")) // true
}

fun backspaceCompare(s: String, t: String): Boolean {
    var i = s.length -1
    var j = t.length -1

    while (i >=0 || j >=0) {
        i = nextValidIndex(s, i)
        j = nextValidIndex(t , j)

        if (i<0 && j<0) return true
        if (i< 0 || j <0) return false
        if (s[i] != t[j]) return false


        i--
        j--
    }

    return true
}

private fun nextValidIndex(string: String, index: Int): Int {
    var skip = 0
    var i = index

    while (i>=0) {
        if (string[i] == '#') {
            skip++
        } else if ( skip > 0) {
            skip--
        } else {
            break
        }
        i--
    }

    return i
}
