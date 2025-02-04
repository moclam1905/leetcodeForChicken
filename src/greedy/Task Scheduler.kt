package greedy

fun leastInterval(tasks: CharArray, n: Int): Int {
    val freq = IntArray(26)
    for (i in tasks.indices){
        freq[tasks[i] - 'A']++
    }

    val maxCount = freq.maxOrNull() ?: 0
    var countMax = 0
    for (i in freq){
        if (i == maxCount)
            countMax++
    }

    // (maxCount−1)×(n+1)+countMax
    val partCount = maxCount -1
    val partLength = n +1
    val emptySlots = partCount * partLength + countMax

    return Math.max(emptySlots, tasks.size)
}
/**
 * Xây Dựng Các "Block"
 *
 * Ta hình dung rằng các lần thực hiện của tác vụ xuất hiện nhiều nhất tạo thành các “block” (khung):
 * Có maxCount lần thực hiện của tác vụ phổ biến nhất, nên ta có maxCount - 1 khoảng giữa chúng.
 * Mỗi khoảng giữa (block gap) cần có độ dài ít nhất n khoảng thời gian để đảm bảo các lần thực hiện đó không bị cận nhau
 * Thêm vào đó, mỗi block còn chứa cả tác vụ hiện tại nên ta có độ dài của block là n +1
 * Do đó, nếu ta “xếp” các block này liên tiếp, số khoảng thời gian tối thiểu cần thiết sẽ là:
 * (maxCount−1)×(n+1)
 *
 * Tuy nhiên, ở phần cuối (khối cuối cùng) ta có thể đặt thêm countMax tác vụ có tần số cao nhất (vì trong block cuối, các tác vụ đó có thể xếp liền nhau mà không vi phạm khoảng cách).
 *
 * Tổng số khoảng thời gian theo cách bố trí này là: (maxCount−1)×(n+1)+countMax
 */

