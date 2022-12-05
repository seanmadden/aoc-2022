package day4

val testInput = """
    2-4,6-8
    2-3,4-5
    5-7,7-9
    2-8,3-7
    6-6,4-6
    2-6,4-8
""".trimIndent()

fun part1(): Int {
    var countOfCompletelyContained = 0

    for (line in puzzleInput.lines()) {
        val assignments = line.split(",")
        val firstElf = assignments[0].split("-")
        val secondElf = assignments[1].split("-")

        val assignmentSet = HashSet<Int>()
        var completelyContained = true

        //put the larger range into a hashmap
        if (firstElf[1].toInt() - firstElf[0].toInt() + 1 >= secondElf[1].toInt() - secondElf[0].toInt() + 1) {
            firstElf[0].toInt().rangeTo(firstElf[1].toInt()).forEach {
                assignmentSet.add(it)
            }

            secondElf.forEach {
                if (!assignmentSet.contains(it.toInt())) {
                    completelyContained = false
                }
            }
        } else {
            secondElf[0].toInt().rangeTo(secondElf[1].toInt()).forEach {
                assignmentSet.add(it)
            }

            firstElf.forEach {
                if (!assignmentSet.contains(it.toInt())) {
                    completelyContained = false
                }
            }

        }

        if (completelyContained) {
            countOfCompletelyContained++
        }
    }

    return countOfCompletelyContained
}

fun part2(): Int {
    var countAnyContained = 0

    for (line in puzzleInput.lines()) {
        val assignments = line.split(",")
        val firstElf = assignments[0].split("-")
        val secondElf = assignments[1].split("-")

        val assignmentSet = HashSet<Int>()
        var anyContained = false

        //put the larger range into a hashmap
        if (firstElf[1].toInt() - firstElf[0].toInt() + 1 >= secondElf[1].toInt() - secondElf[0].toInt() + 1) {
            firstElf[0].toInt().rangeTo(firstElf[1].toInt()).forEach {
                assignmentSet.add(it)
            }

            secondElf.forEach {
                if (assignmentSet.contains(it.toInt())) {
                    anyContained = true
                }
            }
        } else {
            secondElf[0].toInt().rangeTo(secondElf[1].toInt()).forEach {
                assignmentSet.add(it)
            }

            firstElf.forEach {
                if (assignmentSet.contains(it.toInt())) {
                    anyContained = true
                }
            }

        }

        if (anyContained) {
            countAnyContained++
        }
    }

    return countAnyContained
}

fun main(args: Array<String>) {
    println(part2())
}
