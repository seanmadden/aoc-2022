package year2024.day5

import kotlin.system.exitProcess

val testInput = """
    47|53
    97|13
    97|61
    97|47
    75|29
    61|13
    75|53
    29|13
    97|29
    53|29
    61|53
    97|53
    61|29
    47|13
    75|47
    97|75
    47|61
    75|61
    47|29
    75|13
    53|13

    75,47,61,53,29
    97,61,53,29,13
    75,29,13
    75,97,47,61,53
    61,13,29
    97,13,75,29,47
""".trimIndent()

fun part1(ruleMap: Map<Int, List<Int>>, updateLines: List<String>) {
    val validLines = mutableListOf<String>()
    for (line in updateLines) {
//        println("Checking line $line")
        val updates = line.split(",")
        val seen = mutableSetOf<Int>()
        var valid = true

        for (update in updates) {
            val updateInt = update.toInt()
            if (ruleMap.contains(updateInt)) {
                if (seen.any { ruleMap[updateInt]!!.contains(it) }) {
                    println("Invalid! $line")
                    valid = false
                    break
                }
            }
            seen.add(updateInt)
        }
        if (valid) {
            validLines.add(line)
        }
    }
    println("--- Valid lines ---")
    for (validLine in validLines) {
        println("$validLine")
    }
    val middles = validLines.map {
        val nums = it.split(",")
        nums[nums.lastIndex/2].toInt()
    }
    println("Middles: ")
    println(middles)
    println("Sum: ${middles.sum()}")
}

fun part2(ruleMap: Map<Int, List<Int>>, updateLines: List<String>) {
    val invalidLines = mutableListOf<String>()
    for (line in updateLines) {
//        println("Checking line $line")
        val updates = line.split(",")
        val seen = mutableSetOf<Int>()
        var valid = true

        for (update in updates) {
            val updateInt = update.toInt()
            if (ruleMap.contains(updateInt)) {
                if (seen.any { ruleMap[updateInt]!!.contains(it) }) {
                    println("Invalid! $line")
                    invalidLines.add(line)
                    valid = false
                    break
                }
            }
            seen.add(updateInt)
        }
    }
    println("--- Invalid lines ---")
    val fixedLines = mutableListOf<List<Int>>()
    for (line in invalidLines) {
        val parsedLine = line.split(",").map { it.toInt() }.toMutableList()
        parsedLine.sortWith { o1, o2 ->
            var contains = false
            if (ruleMap.contains(o2)) {
                val rulesList = ruleMap[o2]!!
                if (rulesList.contains(o1)) contains = true
            }
            if (contains) -1 else 0
        }
        println("Fixed line: $parsedLine")
        fixedLines.add(parsedLine)
    }
    val middles = fixedLines.map {
        it[it.lastIndex/2].toInt()
    }
    println("Middles: ")
    println(middles)
    println("Sum: ${middles.sum()}")
}

fun main(args: Array<String>) {
    val parts = puzzleInput.split("\n\n")

    val ruleMap = mutableMapOf<Int, MutableList<Int>>()
    for (line in parts[0].lines()) {
        val rule = line.split("|")
        val ruleList = ruleMap.getOrDefault(rule[0].toInt(), mutableListOf())

        ruleList.add(rule[1].toInt())
        ruleMap[rule[0].toInt()] = ruleList
    }

    for (entry in ruleMap) {
        println("${entry.key} | ${entry.value}")
    }

    part2(ruleMap, parts[1].lines())

}
