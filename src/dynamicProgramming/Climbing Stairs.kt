package dynamicProgramming

fun climbStairs(n: Int): Int {
    when (n) {
        0 -> return 0
        1 -> return 1
        2 -> return 2
    }

    val arr = IntArray(n +1) {0}
    arr[1] = 1
    arr[2] = 2

    for (i in 3..n){
        arr[i] = arr[i -1] + arr[i -2]
    }

    return arr[n]


}