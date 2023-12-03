package year2022.day1

val testInput = """
    1000
    2000
    3000

    4000

    5000
    6000

    7000
    8000
    9000

    10000
""".trimIndent()


fun part1() {
    val elfWeight = mutableMapOf<Int, Long>()
    var elfCount = 1

    for ((index, line) in year2022.day1.puzzleInput.lines().withIndex()) {
        if (line.isEmpty()) {
            elfCount++
            continue
        }

        var currentWeight = elfWeight.getOrDefault(elfCount, 0)

        currentWeight += line.toLong()

        elfWeight[elfCount] = currentWeight
    }

    println("elf with most food: " + elfWeight.maxBy { it.value })
}

fun part2() {
    val elfWeight = mutableMapOf<Int, Long>()
    var elfCount = 1

    for ((index, line) in year2022.day1.puzzleInput.lines().withIndex()) {
        if (line.isEmpty()) {
            elfCount++
            continue
        }

        var currentWeight = elfWeight.getOrDefault(elfCount, 0)

        currentWeight += line.toLong()

        elfWeight[elfCount] = currentWeight
    }

    println("3 elfs with most food: " + elfWeight.values.sortedDescending().take(3).sum())
}

fun main(args: Array<String>) {
    year2022.day1.part2()
}
