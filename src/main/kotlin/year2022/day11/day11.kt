package year2022.day11

val testInput = """
    Monkey 0:
      Starting items: 79, 98
      Operation: new = old * 19
      Test: divisible by 23
        If true: throw to monkey 2
        If false: throw to monkey 3

    Monkey 1:
      Starting items: 54, 65, 75, 74
      Operation: new = old + 6
      Test: divisible by 19
        If true: throw to monkey 2
        If false: throw to monkey 0

    Monkey 2:
      Starting items: 79, 60, 97
      Operation: new = old * old
      Test: divisible by 13
        If true: throw to monkey 1
        If false: throw to monkey 3

    Monkey 3:
      Starting items: 74
      Operation: new = old + 3
      Test: divisible by 17
        If true: throw to monkey 0
        If false: throw to monkey 1
""".trimIndent()

enum class Operation {
    ADD,
    MULTIPLY,
}

class MonkeySimulator(private val monkeys: List<Monkey>) {
    init {
        val reductionFactor = monkeys.map { it.getTestValue() }.reduce {acc, i -> acc.times(i) }

        monkeys.forEach {
            it.setReductionFactor(reductionFactor.toULong())
        }
    }

    fun doRound() {
        for (monkey in monkeys) {
            val destinations = monkey.takeTurn()
            println()

            for (destination in destinations) {
                val item = monkey.getNextItem()
                monkeys[destination].giveItem(item)
            }
        }
    }

    fun listItems() {
        monkeys.forEach { println(it.listItems()) }
    }

    fun getInspectionCounts(): List<Int> {
        return monkeys.map { it.getInspectionCount() }
    }
}

fun main(args: Array<String>) {
    val iterator = puzzleInput.lines().iterator()
    val monkeyList = mutableListOf<Monkey>()

    while (iterator.hasNext()) {
        val monkeyNumber = iterator.next()
        val startingItems = iterator.next()
        val operation = iterator.next()
        val test = iterator.next()
        val trueAction = iterator.next()
        val falseAction = iterator.next()

        val blankLine = if (iterator.hasNext()) iterator.next() else null

        val m = Monkey(monkeyNumber, startingItems, operation, test, trueAction, falseAction)
        monkeyList.add(m)
    }

//    part1(monkeyList)
    val sim = MonkeySimulator(monkeyList)
    for (i in 1..10_000) {
        println("*********** ROUND $i ***********")
        sim.doRound()
//        readLine()
    }

    sim.listItems()
    val counts = sim.getInspectionCounts()
    val top2 = counts.sortedDescending().take(2)
    println(counts)
    println(top2[0].toULong() * top2[1].toULong())

}