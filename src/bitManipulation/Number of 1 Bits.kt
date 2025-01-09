package bitManipulation

fun hammingWeight1(n: Int): Int {

    var tmpN = n
    var count = 0
    while (tmpN!=0){
        count += tmpN and 1
        tmpN = tmpN ushr 1 //right shift
    }

    return count
}

fun hammingWeight(n: Int): Int {

    var tmpN = n
    var count = 0
    while (tmpN!=0){
        tmpN = tmpN and (tmpN - 1)
        count++
    }

    return count
}