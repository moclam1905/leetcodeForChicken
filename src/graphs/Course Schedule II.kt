package graphs

import java.util.*

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val adj = Array<MutableList<Int>>(numCourses) { arrayListOf() }
    // Mảng để lưu bậc vào của mỗi khóa học
    val inDegree = IntArray(numCourses) { 0 }

    // Xây dựng đồ thị và tính bậc vào
    for (p in prerequisites) {
        adj[p[1]].add(p[0])
        inDegree[p[0]]++
    }

    // Khởi tạo queue với các khóa học có bậc vào bằng 0
    val queue: Queue<Int> = LinkedList()
    for (i in inDegree.indices) {
        if (inDegree[i] == 0)
            queue.offer(i)
    }

    val result = IntArray(numCourses)
    var idx = 0

    while (queue.isNotEmpty()) {
        val crrValue = queue.poll()
        // Đây là một khóa học có bậc vào = 0 → có thể học (hoặc xử lý) ngay
        result[idx] = crrValue

        idx++

        // Giảm bậc vào của các khóa học tiếp theo
        for (c in adj[crrValue]){
            inDegree[c]--

            // Nếu bậc vào của neighbor giảm xuống 0, thêm vào queue
            if (inDegree[c] == 0) {
                queue.offer(c)
            }
        }
    }

    // 5. Kiểm tra xem đã xếp được tất cả khóa học chưa
    return if (idx == numCourses) {
        // Xếp được đủ numCourses khóa học
        result
    } else {
        // Có khóa học không thể xếp do tồn tại chu trình
        IntArray(0)
    }

}