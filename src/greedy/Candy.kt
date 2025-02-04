package greedy

//two-pass greedy
fun candy(ratings: IntArray): Int {
    // each child gets 1 candy
    val tmp = IntArray(ratings.size){1}

    // left to right
    // if child at i has rating > child i-1 rating
    // => child ad i with take more candy compared to child i -1
    for (i in 1 until  ratings.size){
        if (ratings[i] > ratings[i-1]){
            tmp[i]  = tmp[i -1] +1
        }
    }

    for (i in ratings.size -2 downTo 0){
        if (ratings[i] > ratings[i+1]){
            tmp[i] = Math.max(tmp[i +1] +1, tmp[i])
        }
    }

    return tmp.sum()
}

