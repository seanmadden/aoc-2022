package year2023.day7

val testInput = """
    Time:      7  15   30
    Distance:  9  40  200
""".trimIndent()

val puzzleInput = """
    Time:        51     69     98     78
    Distance:   377   1171   1224   1505
""".trimIndent()

val part2input = """
    Time:        51699878
    Distance:   377117112241505
""".trimIndent()

class Race(val timeLimit: Long, val distanceToBeat: Long) {
    fun waysToWin(): Int {
        val options = mutableListOf<Long>()
        for (i in 1..timeLimit) {
            options.add((timeLimit - i) * i)
        }
        return options.count { it > distanceToBeat }
    }

}

fun part1(timeList: List<Long>, distanceList: List<Long>) {
    val waysToWin = mutableListOf<Int>()
    for ((idx, _) in timeList.withIndex()) {
        waysToWin.add(Race(timeList[idx], distanceList[idx]).waysToWin())
    }

    println(waysToWin.fold(1) { acc, i -> acc * i })
}


fun main(args: Array<String>) {
    val timeList = mutableListOf<Long>()
    val distanceList = mutableListOf<Long>()

    for (line in part2input.lines()) {
        if (line.startsWith("Time:")) {
            timeList.addAll(line.removePrefix("Time:").trim().split(" ").filter { it.isNotEmpty() }.map { it.toLong() })
        } else if (line.startsWith("Distance:")) {
            distanceList.addAll(line.removePrefix("Distance:").trim().split(" ").filter { it.isNotEmpty() }.map { it.toLong() })
        }
    }

    if (timeList.isEmpty() || distanceList.isEmpty()) {
        error("didn't parse input correctly!")
    }

    val startTime = System.currentTimeMillis()
    part1(timeList, distanceList)
    val endTime = System.currentTimeMillis()
    println("millis elapsed ${endTime - startTime}")
}
