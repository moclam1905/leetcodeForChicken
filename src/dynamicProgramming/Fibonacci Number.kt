package dynamicProgramming

private var memo: MutableMap<Int, Int> = mutableMapOf()
fun fib1(n: Int): Int {
    if (n == 0)
        return 0
    else if (n == 1)
        return 1

    if (memo.containsKey(n))
        return memo.getValue(n)
    else {
        memo[n] = fib1(n - 1) + fib1(n - 2)
        return memo.getValue(n)
    }
}

fun fib(n: Int): Int {

    val memo1 = mutableMapOf<Int, Int>()
    memo1[0] = 0
    memo1[1] = 1
    for (i in 2..n) {
        memo1[i] = memo1[i - 1]!! + memo1[i - 2]!!
    }

    return memo1[n]!!
}

fun fib2(n: Int): Int {
    if (n == 0)
        return 0
    else if (n == 1)
        return 1

    var prev = 0
    var curr = 1
    for (i in 2..n) {
        val next = prev + curr
        prev = curr
        curr = next
    }

    return curr
}
