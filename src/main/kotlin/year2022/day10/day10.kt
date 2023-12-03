package year2022.day10

val testInput = """
    addx 15
    addx -11
    addx 6
    addx -3
    addx 5
    addx -1
    addx -8
    addx 13
    addx 4
    noop
    addx -1
    addx 5
    addx -1
    addx 5
    addx -1
    addx 5
    addx -1
    addx 5
    addx -1
    addx -35
    addx 1
    addx 24
    addx -19
    addx 1
    addx 16
    addx -11
    noop
    noop
    addx 21
    addx -15
    noop
    noop
    addx -3
    addx 9
    addx 1
    addx -3
    addx 8
    addx 1
    addx 5
    noop
    noop
    noop
    noop
    noop
    addx -36
    noop
    addx 1
    addx 7
    noop
    noop
    noop
    addx 2
    addx 6
    noop
    noop
    noop
    noop
    noop
    addx 1
    noop
    noop
    addx 7
    addx 1
    noop
    addx -13
    addx 13
    addx 7
    noop
    addx 1
    addx -33
    noop
    noop
    noop
    addx 2
    noop
    noop
    noop
    addx 8
    noop
    addx -1
    addx 2
    addx 1
    noop
    addx 17
    addx -9
    addx 1
    addx 1
    addx -3
    addx 11
    noop
    noop
    addx 1
    noop
    addx 1
    noop
    noop
    addx -13
    addx -19
    addx 1
    addx 3
    addx 26
    addx -30
    addx 12
    addx -1
    addx 3
    addx 1
    noop
    noop
    noop
    addx -9
    addx 18
    addx 1
    addx 2
    noop
    noop
    addx 9
    noop
    noop
    noop
    addx -1
    addx 2
    addx -37
    addx 1
    addx 3
    noop
    addx 15
    addx -21
    addx 22
    addx -6
    addx 1
    noop
    addx 2
    addx 1
    noop
    addx -10
    noop
    noop
    addx 20
    addx 1
    addx 2
    addx 2
    addx -6
    addx -11
    noop
    noop
    noop
""".trimIndent()

class Machine() {
    private var currentCycle = 1
    private var x = 1
    var sumOfSignalStrengths = 0

    fun noop() {
        checkCycle()
        currentCycle++
    }

    fun addx(increment: Int) {
        checkCycle()
        currentCycle++

        checkCycle()
        currentCycle++

        x += increment
    }

    private fun printOutput() {
        val spriteWindow = listOf(x - 1, x, x + 1)

        if (spriteWindow.contains((currentCycle % 40) - 1)) {
            print("#")
        } else {
            print(".")
        }

        if (currentCycle % 40 == 0) {
            println()
        }
    }

    private fun checkCycle() {
        printOutput()

        if (currentCycle == 20 ||
            currentCycle == 60 ||
            currentCycle == 100 ||
            currentCycle == 140 ||
            currentCycle == 180 ||
            currentCycle == 220
        ) {
//            println("Cycle $currentCycle: signal strength: ${currentCycle * x}")
//            println()
            sumOfSignalStrengths += currentCycle * x
        }
    }
}

fun main(args: Array<String>) {
    var cycleCount = 0
    var x = 1

    val machine = Machine()

    for (line in puzzleInput.lines()) {
        if (line == "noop") {
            machine.noop()
        } else if (line.startsWith("addx")) {
            machine.addx(line.split(" ")[1].toInt())
        }
    }

    println("Sum of signal strengths: ${machine.sumOfSignalStrengths}")

}