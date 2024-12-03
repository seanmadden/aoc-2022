package year2024.day3

val testInput = """
    xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
""".trimIndent()

val testInput2 = """
    xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
""".trimIndent()

fun part1(input: List<String>) {
    val re = Regex("mul(\\([\\d]+,[\\d]+\\))")

    var sum = 0
    for (line in input) {
        val groups = re.findAll(line)
        for (group in groups) {
            val nums = group.groupValues[1].removePrefix("(").removeSuffix(")").split(",").map { s -> s.toInt() }
            println(nums)
            sum += nums[0] * nums[1]
        }
    }

    println("sum is $sum")

}

fun part2(input: List<String>) {
    val re = Regex("mul(\\([\\d]+,[\\d]+\\))|do\\(\\)|don't\\(\\)")

    var sum = 0
    var active = true
    for (line in input) {
        val groups = re.findAll(line)
        for (group in groups) {
            println(group.groupValues)
            if (group.groupValues[0] == "do()") {
                active = true
                continue
            } else if (group.groupValues[0] == "don't()") {
                active = false
                continue
            }
            if (active) {
                val nums = group.groupValues[1].removePrefix("(").removeSuffix(")").split(",").map { s -> s.toInt() }
                println(nums)
                sum += nums[0] * nums[1]
            }
        }
    }

    println("sum is $sum")
}

fun main(args: Array<String>) {
    part2(puzzleInput)

}
