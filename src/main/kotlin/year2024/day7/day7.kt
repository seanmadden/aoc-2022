package year2024.day7

val testInput = """
    190: 10 19
    3267: 81 40 27
    83: 17 5
    156: 15 6
    7290: 6 8 6 15
    161011: 16 10 13
    192: 17 8 14
    21037: 9 7 18 13
    292: 11 6 16 20
""".trimIndent()

class Equation(val target: Long, val inputs: List<Long>) {
    fun canGetTargetRecursive(sum: Long, remainingInputs: List<Long>): Boolean {
        if (sum == target && remainingInputs.isEmpty()) return true
        if (remainingInputs.isEmpty()) return false

        var times =
            canGetTargetRecursive(sum * remainingInputs.first(), remainingInputs.subList(1, remainingInputs.size))
        times = times || canGetTargetRecursive(
            sum + remainingInputs.first(),
            remainingInputs.subList(1, remainingInputs.size)
        )

        return times
    }

    fun canGetTargetRecursivePartTwo(sum: Long, remainingInputs: List<Long>): Boolean {
        if (sum == target && remainingInputs.isEmpty()) return true
        if (remainingInputs.isEmpty()) return false

        var times =
            canGetTargetRecursive(sum * remainingInputs.first(), remainingInputs.subList(1, remainingInputs.size))
        times = times || canGetTargetRecursive(
            sum + remainingInputs.first(),
            remainingInputs.subList(1, remainingInputs.size)
        )
        times = times || canGetTargetRecursive(
            (sum.toString() + remainingInputs.first().toString()).toLong(),
            remainingInputs.subList(1, remainingInputs.size)
        )

        return times
    }

    override fun toString(): String {
        return "$target: $inputs"
    }
}

fun part1(equations: List<Equation>) {
    val valid = mutableListOf<Equation>()
    equations.forEach {
        val canGetThere = it.canGetTargetRecursive(it.inputs.first(), it.inputs.subList(1, it.inputs.size))
        println("Equation $it: $canGetThere")

        if (canGetThere) {
            valid.add(it)
        }
    }

    var sum = 0L
    for (validEquation in valid) {
        sum += validEquation.target
    }

    println(sum)
}

fun part2(equations: List<Equation>) {
    val valid = mutableListOf<Equation>()
    equations.forEach {
        val canGetThere = it.canGetTargetRecursivePartTwo(it.inputs.first(), it.inputs.subList(1, it.inputs.size))
        println("Equation $it: $canGetThere")

        if (canGetThere) {
            valid.add(it)
        }
    }

    var sum = 0L
    for (validEquation in valid) {
        sum += validEquation.target
    }

    println(sum)
}

fun main(args: Array<String>) {
    val equations = mutableListOf<Equation>()

    for (line in puzzleInput.lines()) {
        val splitLine = line.split(":").map { it.trim() }
        val target = splitLine[0].toLong()
        val inputs = splitLine[1].split(" ").map { it.trim().toLong() }

        equations.add(Equation(target, inputs))
    }

    part2(equations)
}
