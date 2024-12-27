package graphs

import java.util.*

//Thuật toán Kahn thực hiện topological sort và đồng thời kiểm tra xem đồ thị có chứa chu trình hay không.
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
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

    var processedCourse = 0

    while (queue.isNotEmpty()) {
        val crrValue = queue.poll()
        processedCourse++

        // Giảm bậc vào của các khóa học tiếp theo
        for (c in adj[crrValue]){
            inDegree[c]--

            // Nếu bậc vào của neighbor giảm xuống 0, thêm vào queue
            if (inDegree[c] == 0) {
                queue.offer(c)
            }
        }
    }

    // Nếu đã xử lý hết tất cả các khóa học, không có chu trình
    return processedCourse == numCourses

}
