package year2023.day12

import java.awt.Point
import java.awt.geom.Point2D
import kotlin.math.abs

val testInput = """
    ???.### 1,1,3
    .??..??...?##. 1,1,3
    ?#?#?#?#?#?#?#? 1,3,1,6
    ????.#...#... 4,1,1
    ????.######..#####. 1,6,5
    ?###???????? 3,2,1
""".trimIndent()

val puzzleInput = """
""".trimIndent()

val part2TestInput = """
""".trimIndent()

val test2Input = """
""".trimIndent()

fun part1() {
}

fun part2(values: List<Long>) {
}

// ? Unknown
// . Operational
// # Damaged
fun main(args: Array<String>) {
    val input = testInput.lines()
        .map { it.split(" ") }

    val regex = Regex("([?]+|#+)")

    for (line in input) {
        val result = regex.findAll(line[0])
//        println("Found ${result.map { it.groups }.joinToString(",") }} groups")
        val biggestConsecutive = line[1].split(",").maxOf { it.toInt() }

        println("Biggest consecutive: $biggestConsecutive")
        for ((idx, matches) in result.withIndex()) {
//            println("Looking for a group of # to matches max(nums)")
            val knownBroken = matches.groups.filter { it!!.value.length > 1 && it!!.value.contains('#') }
            val largestGroup = matches.groups.map { mg -> mg!!.value.length }.max()

            println("Known broken: ${knownBroken.joinToString(",") } / largest group $largestGroup")
        }
    }

    val startTime = System.currentTimeMillis()

    val endTime = System.currentTimeMillis()
    println("millis elapsed ${endTime - startTime}")
}
