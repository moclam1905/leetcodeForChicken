package arrayAndString

fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    for (i in 0..<n){
        for(j in i+1..<n){
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }


    for (i in 0..<n){
        for(j in 0..(n-1)/2){
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[i][n-j-1]
            matrix[i][n-j-1] = tmp
        }
    }
}