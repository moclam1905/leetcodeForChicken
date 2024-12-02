fun merge(intervals: Array<IntArray>): Array<IntArray> {

    if (intervals.isEmpty()) return arrayOf()

    intervals.sortBy { it[0] }

    val listMerged = mutableListOf<IntArray>()

    for (item in intervals) {
        if (listMerged.isEmpty() || listMerged.last()[1] < item[0]) {
            listMerged.add(item)
        } else {
            listMerged.last()[1] = maxOf(listMerged.last()[1], item[1])
        }
    }

    return listMerged.toTypedArray()
}