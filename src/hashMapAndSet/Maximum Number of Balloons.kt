package hashMapAndSet

fun maxNumberOfBalloons(text: String): Int {
    val hs = HashMap<Char, Int>()
    val balloonString = "balloon"

    for (c in text) {
        if (balloonString.indexOf(c) != -1) {
            hs[c] = hs.getOrDefault(c, 0) + 1
        }
    }

    return if (!hs.containsKey('b') ||
        !hs.containsKey('a') ||
        !hs.containsKey('l') ||
        !hs.containsKey('o') ||
        !hs.containsKey('n')
    ) {
        0
    } else {
        minOf(
            hs.getValue('b'),
            hs.getValue('a'),
            hs.getValue('n'),
            hs.getValue('l') / 2,
            hs.getValue('o') / 2
        )
    }
}

fun maxNumberOfBalloonsV2(text: String): Int {
    val countList = IntArray(26)

    for (t in text) {
        if (t in 'a'..'z') {
            countList[t - 'a']++
        }
    }

    val b = countList['b' - 'a']
    val a = countList['a' - 'a']
    val n = countList['n' - 'a']

    val l = countList['l' - 'a'] / 2
    val o = countList['o' - 'a'] / 2

    return minOf(b, a, n, l, o)


}