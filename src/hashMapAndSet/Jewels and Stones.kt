package hashMapAndSet

fun numJewelsInStones(jewels: String, stones: String): Int {
    val jewelSet = jewels.toSet()
    return stones.count { it in jewelSet }
}
