package day11

class Monkey(
    number: String,
    startingItems: String,
    operation: String,
    test: String,
    trueAction: String,
    falseAction: String
) {
    private var number: Int
    private val items: MutableList<ULong>
    private var operation: Operation
    private var operationValue: String
    private var test: Int
    private var trueAction: Int
    private var falseAction: Int
    private var reductionFactor: ULong

    private var inspectionCount = 0

    init {
        this.number = number.split(" ")[1].removeSuffix(":").toInt()

        this.items = startingItems.split(":")[1].split(",").map {
            it.trim().toULong()
        }.toMutableList()

        // [old, op, val]
        val rightSide = operation.split("=")[1].trim().split(" ")

        this.operation = when (rightSide[1]) {
            "+" -> Operation.ADD
            "*" -> Operation.MULTIPLY
            else -> {
                // Having perfectly formatted input is the best ever
                throw RuntimeException()
            }
        }

        this.operationValue = rightSide[2]

        this.test = test.split("by")[1].trim().toInt()
        this.reductionFactor = this.test.toULong()
        this.trueAction = trueAction.split("monkey")[1].trim().toInt()
        this.falseAction = falseAction.split("monkey")[1].trim().toInt()
    }

    fun setReductionFactor(value: ULong) {
        this.reductionFactor = value
    }

    fun getTestValue(): Int {
        return test
    }

    // returns a list of destination monkeys
    fun takeTurn(): List<Int> {
        return List(items.size) { index ->
            println("Monkey #$number")
            println("\tInspecting item with worry level ${items[index]}")
//            println("\tWorry level after inspection ${items[index]}")

            val nextVal = performOperation(items[index])

            // part2: no relief
//            relief(index)
            reduce(index)

            print("\tChecking if $nextVal is divisible by $test")

            val action = if (testValue(nextVal)) {
                println("\tit is! passing to Monkey #$trueAction")
                trueAction
            } else {
                println("\tit's not. passing to Monkey #$falseAction")
                falseAction
            }

            inspect(index)

            action
        }
    }

    private fun testItem(itemIndex: Int) = testValue(items[itemIndex])

    private fun testValue(value: ULong) = value.mod(test.toULong()) == 0UL

    private fun relief(itemIndex: Int) {
        items[itemIndex] = items[itemIndex] / 3UL
    }

    private fun reduce(itemIndex: Int) {
        items[itemIndex] = items[itemIndex].mod(reductionFactor)
    }

    private fun inspect(itemIndex: Int) {
        items[itemIndex] = getNewWorryLevel(itemIndex)
        inspectionCount++
    }

    fun getNextItem(): ULong {
        return items.removeFirst()
    }

    fun getInspectionCount(): Int {
        return inspectionCount
    }

    fun giveItem(item: ULong) {
        items.add(item)
    }

    fun listItems(): MutableList<ULong> {
        return items
    }

    private fun performOperation(value: ULong): ULong {
        if (this.operationValue == "old") {
            return when (operation) {
                Operation.MULTIPLY -> value.times(value)
                Operation.ADD -> value.plus(value)
            }
        }

        return when (operation) {
            Operation.MULTIPLY -> value.times(operationValue.toULong())
            Operation.ADD -> value.plus(operationValue.toULong())
        }

    }

    private fun getNewWorryLevel(itemIndex: Int): ULong {
        return performOperation(items[itemIndex])
    }

    override fun toString(): String {
        return """
            Monkey $number:
                Items: $items
        """.trimIndent()
//        Operation: new = old $operation $operationValue
//        Test: divisible by $test
//        If true: throw to monkey $trueAction
//        If false: throw to monkey $falseAction
    }
}